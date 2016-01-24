package org.usfirst.frc.team190.robot.subsystems;

import org.usfirst.frc.team190.robot.RobotMap;
import org.usfirst.frc.team190.robot.commands.OperatorDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
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
	
	PIDController leftEncoderLoop;
	PIDController rightEncoderLoop;
	
    public Drivetrain() {
        leftTalon = new Talon(RobotMap.leftTalon);
    	rightTalon = new Talon(RobotMap.rightTalon);
    	
    	leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
    	rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
    	
    	leftTalon.setInverted(RobotMap.invertDriveLeft);
    	rightTalon.setInverted(RobotMap.invertDriveRight);
    	
    	// Invert encoders if the drive is inverted.
    	// Left encoder should be opposite inversion of the right encoder since they spin in opposite directions
    	leftEncoder.setReverseDirection(RobotMap.invertDriveLeft);
    	rightEncoder.setReverseDirection(!RobotMap.invertDriveRight);
    	
    	// Set encoders to output rate to the PID controller
    	leftEncoder.setPIDSourceType(PIDSourceType.kRate);
    	rightEncoder.setPIDSourceType(PIDSourceType.kRate);
    	
    	drive = new RobotDrive(leftTalon, rightTalon);
    	
    	leftEncoderLoop = new PIDController(0, 0, 0, leftEncoder, leftTalon);
    	rightEncoderLoop = new PIDController(0, 0, 0, rightEncoder, rightTalon);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new OperatorDrive());
    }
    
    // Records min/max data from encoders to estimate tolerances.
    // Waits 150 ticks before starting to record data.
    public double minLeftEncoderRate = 999999, maxLeftEncoderRate = -999999;
    public double minRightEncoderRate = 999999, maxRightEncoderRate = -999999;
    public int buffer = 150;
    void outputSensorData() {
    	double leftEncoderRate = leftEncoder.getRate();
    	double rightEncoderRate = rightEncoder.getRate();
    	
    	if (buffer-- <= 0) {
    		buffer = 0;

	    	minLeftEncoderRate = (leftEncoderRate < minLeftEncoderRate) ? leftEncoderRate : minLeftEncoderRate;
	    	maxLeftEncoderRate = (leftEncoderRate > maxLeftEncoderRate) ? leftEncoderRate : maxLeftEncoderRate;
	    	
	    	minRightEncoderRate = (rightEncoderRate < minRightEncoderRate) ? rightEncoderRate : minRightEncoderRate;
	    	maxRightEncoderRate = (rightEncoderRate > maxRightEncoderRate) ? rightEncoderRate : maxRightEncoderRate;
    	}
    	
    	SmartDashboard.putNumber("Lef2t Encoder Distance", leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Encoder Distance", rightEncoder.getDistance());
    	
    	SmartDashboard.putNumber("Left Encoder Rate", leftEncoderRate);
    	SmartDashboard.putNumber("Right Encoder Rate", rightEncoderRate);
    	
    	SmartDashboard.putNumber("Left Encoder Min Rate", minLeftEncoderRate);
    	SmartDashboard.putNumber("Left Encoder Max Rate", maxLeftEncoderRate);
    	
    	SmartDashboard.putNumber("Right Encoder Min Rate", minRightEncoderRate);
    	SmartDashboard.putNumber("Right Encoder Max Rate", maxRightEncoderRate);
    }
    
    protected double returnPIDInput() {
    	outputSensorData();
    	
    	return leftEncoder.getDistance() - rightEncoder.getDistance();
    }
    
    public void idle() {
    	tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	outputSensorData();
    	drive.arcadeDrive(speed, rotate);
    }
    
    public void tankDrive(double left, double right) {
    	outputSensorData();
    	drive.tankDrive(left, right);
    }
    
    public void driveStraight(double speed) {
    	tankDrive(speed, speed);
    }
}
