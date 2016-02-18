
package org.usfirst.frc190.frc2k16.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
    
    private final SpeedController leftMotor1;
    private final SpeedController leftMotor2;
    private final SpeedController rightMotor1;
    private final SpeedController rightMotor2;
    private final RobotDrive robotDrive;
    
    private final DoubleSolenoid shiftingSolenoid;
    
    private final ADXRS450_Gyro gyro;
    
    public DriveTrain() {
    	shiftingSolenoid = new DoubleSolenoid(0, RobotMap.DRIVE_SOLENOID_SHIFTING_F, RobotMap.DRIVE_SOLENOID_SHIFTING_B);
        LiveWindow.addActuator("Drive Train", "shiftingSolenoid", shiftingSolenoid);
    	
        gyro = new ADXRS450_Gyro();
        LiveWindow.addSensor("Drive Train", "Gyro", gyro);
        
    	leftEncoder = new Encoder(RobotMap.DRIVE_ENCODER_LEFT_A, RobotMap.DRIVE_ENCODER_LEFT_B, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "leftEncoder", leftEncoder);
        // driveTrainleftEncoder.setPIDSourceType(PIDSourceType.kRate);
        // driveTrainleftEncoder.setDistancePerPulse(ticksToInches);
        // driveTrainleftEncoder.setReverseDirection(invertLeftEncoder);
        
        rightEncoder = new Encoder(RobotMap.DRIVE_ENCODER_RIGHT_A, RobotMap.DRIVE_ENCODER_RIGHT_B, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "rightEncoder", rightEncoder);
        // driveTrainrightEncoder.setDistancePerPulse(1.0);
        // driveTrainrightEncoder.setPIDSourceType(PIDSourceType.kRate);
        // driveTrainleftEncoder.setDistancePerPulse(ticksToInches);
        
    	leftMotor1 = new Talon(RobotMap.DRIVE_MOTOR_LEFT1);
        LiveWindow.addActuator("Drive Train", "leftMotor1", (Talon) leftMotor1);
        
        leftMotor2 = new Talon(RobotMap.DRIVE_MOTOR_LEFT2);
        LiveWindow.addActuator("Drive Train", "leftMotor2", (Talon) leftMotor2);
        
        rightMotor1 = new Talon(RobotMap.DRIVE_ENCODER_RIGHT_A);
        LiveWindow.addActuator("Drive Train", "rightMotor1", (Talon) rightMotor1);
        
        rightMotor2 = new Talon(RobotMap.DRIVE_ENCODER_RIGHT_B);
        LiveWindow.addActuator("Drive Train", "rightMotor2", (Talon) rightMotor2);
        
        robotDrive = new RobotDrive(leftMotor2, leftMotor1, rightMotor2, rightMotor1);
        robotDrive.setInvertedMotor(MotorType.kRearLeft, RobotMap.DRIVE_INVERT_LEFTMOTOR1);
        robotDrive.setInvertedMotor(MotorType.kFrontLeft, RobotMap.DRIVE_INVERT_LEFTMOTOR2);
        robotDrive.setInvertedMotor(MotorType.kRearRight, RobotMap.DRIVE_INVERT_RIGHTMOTOR1);
        robotDrive.setInvertedMotor(MotorType.kFrontRight, RobotMap.DRIVE_INVERT_RIGHTMOTOR2);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
    }

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
    
    public double getLeftEncoderDistance() {
    	return (RobotMap.DRIVE_INVERT_LEFTENCODER) ? -leftEncoder.getDistance() : leftEncoder.getDistance();
    }
    
    public double getRightEncoderDistance() {
    	return (RobotMap.DRIVE_INVERT_RIGHTENCODER) ? -rightEncoder.getDistance() : rightEncoder.getDistance();
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
    
    public void resetGyro() {
    	gyro.reset();
    }

	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
}

