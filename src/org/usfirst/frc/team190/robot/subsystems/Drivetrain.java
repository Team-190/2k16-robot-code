package org.usfirst.frc.team190.robot.subsystems;

import org.usfirst.frc.team190.robot.RobotMap;
import org.usfirst.frc.team190.robot.commands.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends PIDSubsystem {
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	Talon leftTalon;
	Talon rightTalon;
	
	RobotDrive drive;
	
	double pidOutput;
	
    public Drivetrain() {
        super("Drive Train", 0, 0, 0);
    	
    	setSetpoint(0);
    	setPercentTolerance(10);
    	
    	leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
    	leftEncoder.setReverseDirection(RobotMap.invertDriveLeft);
    	
    	rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
    	rightEncoder.setReverseDirection(RobotMap.invertDriveRight);
    	
    	leftTalon = new Talon(RobotMap.leftTalon);
    	leftTalon.setInverted(RobotMap.invertDriveLeft);
    	
    	rightTalon = new Talon(RobotMap.rightTalon);
    	rightTalon.setInverted(RobotMap.invertDriveRight);
    	
    	drive = new RobotDrive(leftTalon, rightTalon);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    
    protected double returnPIDInput() {
    	return leftEncoder.getDistance() - rightEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        pidOutput = output;
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	drive.arcadeDrive(speed, rotate);
    }
    
    public void tankDrive(double left, double right) {
    	SmartDashboard.putNumber("Left Encoder Distance", leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Encoder Distance", rightEncoder.getDistance());
    	
    	drive.tankDrive(left, right);
    }
    
    public void driveStraight(double speed) {
    	drive.arcadeDrive(speed, pidOutput);
    }
}
