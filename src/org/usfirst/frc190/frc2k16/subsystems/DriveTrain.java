
package org.usfirst.frc190.frc2k16.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveManualTank;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveZero;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	
	public enum DriveTrainGearing {
		HIGH, LOW
	}
	
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
    
    private final SpeedController leftMotor1;
    private final SpeedController leftMotor2;
    private final SpeedController rightMotor1;
    private final SpeedController rightMotor2;
    private final RobotDrive robotDrive;
    
    private final DoubleSolenoid shiftingSolenoid;
    
    private final ADXRS450_Gyro gyro;
    
    public boolean autoShifting = true;
    
    double leftUnitsToFeet = 1 / (30.685/2);
    double rightUnitsToFeet = 1 / (35.755/2);
    
    private DriveTrainGearing gearing = DriveTrainGearing.LOW;
    
    public DriveTrain() {
    	shiftingSolenoid = new DoubleSolenoid(0, RobotMap.DRIVE_SOLENOID_SHIFTING_F, RobotMap.DRIVE_SOLENOID_SHIFTING_B);
        LiveWindow.addActuator("Drive Train", "shiftingSolenoid", shiftingSolenoid);
    	
        gyro = new ADXRS450_Gyro();
        LiveWindow.addSensor("Drive Train", "Gyro", gyro);
        
        double wheelDiameter = 2.864; // Measured
        double gearRatio = 18.0 / 20.0; // Ratio between encoder and pulley
        double CPR = 1024.0;
        double leftEncoderPulleyRatio = (0.925 - (1/8)) / (0.877 - (1/8));
        double rightEncoderPulleyRatio = (0.94 - (1/8)) / (0.892 - (1/8));
        double encoderDistancePerPulse = Math.PI * wheelDiameter / CPR / gearRatio;
        
    	leftEncoder = new Encoder(RobotMap.DRIVE_ENCODER_LEFT_A, RobotMap.DRIVE_ENCODER_LEFT_B, RobotMap.DRIVE_INVERT_LEFTENCODER, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "leftEncoder", leftEncoder);
        // leftEncoder.setPIDSourceType(PIDSourceType.kRate);
        // leftEncoder.setReverseDirection(invertLeftEncoder);
        leftEncoder.setDistancePerPulse(encoderDistancePerPulse / leftEncoderPulleyRatio);
        leftEncoder.setSamplesToAverage(32);
        
        rightEncoder = new Encoder(RobotMap.DRIVE_ENCODER_RIGHT_A, RobotMap.DRIVE_ENCODER_RIGHT_B, RobotMap.DRIVE_INVERT_RIGHTENCODER, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "rightEncoder", rightEncoder);
        // rightEncoder.setDistancePerPulse(1.0);
        // rightEncoder.setPIDSourceType(PIDSourceType.kRate);
        rightEncoder.setDistancePerPulse(encoderDistancePerPulse / rightEncoderPulleyRatio);
        rightEncoder.setSamplesToAverage(32);
        
    	leftMotor1 = new Talon(RobotMap.DRIVE_MOTOR_LEFT1);
        LiveWindow.addActuator("Drive Train", "leftMotor1", (Talon) leftMotor1);
        
        leftMotor2 = new Talon(RobotMap.DRIVE_MOTOR_LEFT2);
        LiveWindow.addActuator("Drive Train", "leftMotor2", (Talon) leftMotor2);
        
        rightMotor1 = new Talon(RobotMap.DRIVE_MOTOR_RIGHT1);
        LiveWindow.addActuator("Drive Train", "rightMotor1", (Talon) rightMotor1);
        
        rightMotor2 = new Talon(RobotMap.DRIVE_MOTOR_RIGHT2);
        LiveWindow.addActuator("Drive Train", "rightMotor2", (Talon) rightMotor2);
        
        robotDrive = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
        robotDrive.setInvertedMotor(MotorType.kRearLeft, RobotMap.DRIVE_INVERT_LEFTMOTOR1);
        robotDrive.setInvertedMotor(MotorType.kFrontLeft, RobotMap.DRIVE_INVERT_LEFTMOTOR2);
        robotDrive.setInvertedMotor(MotorType.kRearRight, RobotMap.DRIVE_INVERT_RIGHTMOTOR1);
        robotDrive.setInvertedMotor(MotorType.kFrontRight, RobotMap.DRIVE_INVERT_RIGHTMOTOR2);
        //robotDrive.setSafetyEnabled(true);
        //robotDrive.setExpiration(0.1);
        //robotDrive.setSensitivity(0.5);
        //robotDrive.setMaxOutput(1.0);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveManualTank());
    }
    
    public void stop() {
    	tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotate) {
    	updateShifting();
    	outputSensorData();
    	robotDrive.arcadeDrive(-speed, -rotate);
    }
    
    public void tankDrive(double left, double right) {
    	updateShifting();
    	outputSensorData();
    	robotDrive.tankDrive(-left, -right);
    }
    
    /**
     * Get the current rate of the left encoder.
     * 
     * @return The current rate of the left encoder in ft/s
     */
    public double getLeftEncoderRate() {
    	return leftEncoder.getRate() / 12.0;
    }
    
    /**
     * Get the current rate of the right encoder.
     * 
     * @return The current rate of the right encoder in ft/s
     */
    public double getRightEncoderRate() {
    	return rightEncoder.getRate() / 12.0;
    }
    
    public double getLeftEncoderDistance() {
    	return leftEncoder.getDistance() * leftUnitsToFeet;
    }
    
    public double getRightEncoderDistance() {
    	return rightEncoder.getDistance() * rightUnitsToFeet;
    }
    
   public void shiftLow() {
    	shiftingSolenoid.set(Value.kForward);
    	gearing = DriveTrainGearing.LOW;
    }
    
    public void shiftHigh() {
    	shiftingSolenoid.set(Value.kReverse);
    	gearing = DriveTrainGearing.HIGH;
    }
    
    public void updateShifting() {
    	if (autoShifting && !RobotMap.disableAutoShifting) {
        	double avgEncoderRate = (getLeftEncoderRate() + getRightEncoderRate()) / 2;
        	
        	if ((gearing == DriveTrainGearing.LOW) && (avgEncoderRate > RobotMap.shiftToHighPoint)) {
        		shiftHigh();
        	} else if ((gearing == DriveTrainGearing.HIGH) && (avgEncoderRate < RobotMap.shiftToLowPoint)) {
        		shiftLow();
        	}
    	}
    }
    
    public double minLeftEncoderRate = 999999, maxLeftEncoderRate = -999999;
    public double minRightEncoderRate = 999999, maxRightEncoderRate = -999999;
    public void outputSensorData() {    	
    	double leftEncoderRate = getLeftEncoderRate();
    	double rightEncoderRate = getRightEncoderRate();
    	
    	double leftEncoderDistance = getLeftEncoderDistance();
    	double rightEncoderDistance = getRightEncoderDistance();
    	
    	if (leftEncoderRate < minLeftEncoderRate) minLeftEncoderRate = leftEncoderRate;
    	if (leftEncoderRate > maxLeftEncoderRate) maxLeftEncoderRate = leftEncoderRate;
    	
    	if (rightEncoderRate < minRightEncoderRate) minRightEncoderRate = rightEncoderRate;
    	if (rightEncoderRate > maxRightEncoderRate) maxRightEncoderRate = rightEncoderRate;
    	
    	if (gearing == DriveTrainGearing.LOW) {
    		SmartDashboard.putString("Drive Train Gearing", "Low Gear");
    	} else {
    		SmartDashboard.putString("Drive Train Gearing", "High Gear");
    	}
    	SmartDashboard.putNumber("Avg Encoder Rate", (leftEncoderRate + leftEncoderRate) / 2);
    	
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

