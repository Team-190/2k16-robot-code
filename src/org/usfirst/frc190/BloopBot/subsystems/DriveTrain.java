// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc190.BloopBot.subsystems;

import org.usfirst.frc190.BloopBot.Robot;
import org.usfirst.frc190.BloopBot.RobotMap;
import org.usfirst.frc190.BloopBot.commands.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder leftEncoder = RobotMap.driveTrainleftEncoder;
    private final Encoder rightEncoder = RobotMap.driveTrainrightEncoder;
    private final SpeedController leftMotor1 = RobotMap.driveTrainleftMotor1;
    private final SpeedController leftMotor2 = RobotMap.driveTrainleftMotor2;
    private final SpeedController rightMotor1 = RobotMap.driveTrainrightMotor1;
    private final SpeedController rightMotor2 = RobotMap.driveTrainrightMotor2;
    private final RobotDrive robotDrive = RobotMap.driveTrainrobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	
    	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }
    
    public void stop() {
    	tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	Robot.driveTrain.arcadeDrive(speed, rotate);
    }
    
    public void tankDrive(double left, double right) {
    	Robot.driveTrain.tankDrive(left, right);
    }
    
    double getLeftEncoderDistance() {
    	return (RobotMap.invertLeftEncoder) ? -leftEncoder.getDistance() : leftEncoder.getDistance();
    }
    
    double getRightEncoderDistance() {
    	return (RobotMap.invertRightEncoder) ? -rightEncoder.getDistance() : rightEncoder.getDistance();
    }
    
    public double minLeftEncoderRate = 999999, maxLeftEncoderRate = -999999;
    public double minRightEncoderRate = 999999, maxRightEncoderRate = -999999;
    void outputSensorData() {    	
    	double leftEncoderRate = leftEncoder.getRate();
    	double rightEncoderRate = rightEncoder.getRate();
    	
    	double leftEncoderDistance = getLeftEncoderDistance();
    	double rightEncoderDistance = getRightEncoderDistance();
    	
    	SmartDashboard.putNumber("Left Encoder Distance", leftEncoderDistance);
    	SmartDashboard.putNumber("Right Encoder Distance", rightEncoderDistance);
    	
    	SmartDashboard.putNumber("Robot Drift", leftEncoderDistance - rightEncoderDistance);
    	
    	SmartDashboard.putNumber("Left Encoder Rate", leftEncoderRate);
    	SmartDashboard.putNumber("Right Encoder Rate", rightEncoderRate);
    	
    	SmartDashboard.putNumber("Left Encoder Min Rate", minLeftEncoderRate);
    	SmartDashboard.putNumber("Left Encoder Max Rate", maxLeftEncoderRate);
    	
    	SmartDashboard.putNumber("Right Encoder Min Rate", minRightEncoderRate);
    	SmartDashboard.putNumber("Right Encoder Max Rate", maxRightEncoderRate);
    }
}

