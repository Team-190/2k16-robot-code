package org.usfirst.frc.team190.robot.subsystems;

import org.usfirst.frc.team190.robot.RobotMap;
import org.usfirst.frc.team190.robot.commands.OperatorDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {
	
	RobotDrive drive;
	
	Talon leftTalon;
	Talon rightTalon;
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	PIDController straightDrivingLoop;
	double straightDrivingPIDOutput = 0;
	
    public Drivetrain() {
        leftTalon = new Talon(RobotMap.leftTalon);
    	rightTalon = new Talon(RobotMap.rightTalon);
    	
    	leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
    	rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
    	
    	leftTalon.setInverted(RobotMap.invertLeftDrive);
    	rightTalon.setInverted(RobotMap.invertRightDrive);
    	
    	// Invert encoders if the drive is inverted.
    	// Left encoder should be opposite inversion of the right encoder since they spin in opposite directions
    	leftEncoder.setReverseDirection(RobotMap.invertLeftEncoder);
    	rightEncoder.setReverseDirection(RobotMap.invertRightEncoder);
    	
    	drive = new RobotDrive(leftTalon, rightTalon);
    	
    	straightDrivingLoop = new PIDController(0.01, 0, 0, new PIDSource() {
			public void setPIDSourceType(PIDSourceType pidSource) { }
			
			public double pidGet() { return getLeftEncoderDistance() - getRightEncoderDistance(); }
			
			public PIDSourceType getPIDSourceType() { return PIDSourceType.kDisplacement; }
		}, new PIDOutput() {
			public void pidWrite(double output) { straightDrivingPIDOutput = output; }
		});
    	
    	straightDrivingLoop.setContinuous();
    	straightDrivingLoop.setPercentTolerance(25);
    	straightDrivingLoop.setOutputRange(-1, 1);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new OperatorDrive());
    }
    
    double getLeftEncoderDistance() {
    	return (RobotMap.invertLeftEncoder) ? -leftEncoder.getDistance() : leftEncoder.getDistance();
    }
    
    double getRightEncoderDistance() {
    	return (RobotMap.invertRightEncoder) ? -rightEncoder.getDistance() : rightEncoder.getDistance();
    }
    
    
    
    public void idle() {
    	tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	straightDrivingLoop.disable();
    	
    	outputSensorData();
    	drive.arcadeDrive(speed, rotate);
    }
    
    public void tankDrive(double left, double right) {
    	straightDrivingLoop.disable();
    	
    	outputSensorData();
    	drive.tankDrive(left, right);
    }
    
    
    public void driveStraight(double speed) {
    	if (!straightDrivingLoop.isEnabled()) {
    		straightDrivingLoop.setSetpoint(0);
    		straightDrivingLoop.enable();
    	}
    	    	
    	SmartDashboard.putNumber("PID Loop Output", straightDrivingPIDOutput);
    	
    	outputSensorData();
    	drive.arcadeDrive(speed, straightDrivingPIDOutput);
    }
}
