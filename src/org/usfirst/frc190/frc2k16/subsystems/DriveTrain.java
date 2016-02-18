
package org.usfirst.frc190.frc2k16.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

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
	
    private final Encoder leftEncoder = RobotMap.driveTrainleftEncoder;
    private final Encoder rightEncoder = RobotMap.driveTrainrightEncoder;
    private final SpeedController leftMotor1 = RobotMap.driveTrainleftMotor1;
    private final SpeedController leftMotor2 = RobotMap.driveTrainleftMotor2;
    private final SpeedController rightMotor1 = RobotMap.driveTrainrightMotor1;
    private final SpeedController rightMotor2 = RobotMap.driveTrainrightMotor2;
    private final RobotDrive robotDrive = RobotMap.driveTrainrobotDrive;
    private final DoubleSolenoid shiftingSolenoid = RobotMap.driveTrainshiftingSolenoid;

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new ArcadeDrive());
    }
    
    public void stop() {
    	tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	robotDrive.arcadeDrive(speed, rotate);
    }
    
    public void tankDrive(double left, double right) {
    	robotDrive.tankDrive(left, right);
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

