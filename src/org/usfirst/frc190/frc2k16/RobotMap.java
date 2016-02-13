// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc190.frc2k16;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder driveTrainleftEncoder;
    public static Encoder driveTrainrightEncoder;
    public static SpeedController driveTrainleftMotor1;
    public static SpeedController driveTrainleftMotor2;
    public static SpeedController driveTrainrightMotor1;
    public static SpeedController driveTrainrightMotor2;
    public static RobotDrive driveTrainrobotDrive;
    public static DoubleSolenoid driveTrainshiftingSolenoid;
    public static AnalogPotentiometer blooperblooperPot;
    public static SpeedController blooperblooperMotor;
    public static SpeedController collectorcollectorActuationMotor;
    public static AnalogPotentiometer collectorcollectorPot;
    public static Relay collectorcollectorMotor;
    public static AnalogPotentiometer manipulatormanipulatorPot;
    public static SpeedController manipulatormanipulatorActuationMotor;
    public static DoubleSolenoid shooteractuationSolenoid;
    public static DoubleSolenoid shootertriggerSolenoid;
    public static Solenoid shootershooterSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static AnalogGyro driveTrainGyro;
    public static Relay lightRelay;
    
    // Inversions
    public static boolean invertLeftMotor1 = true;
    public static boolean invertLeftMotor2 = false;
    public static boolean invertRightMotor1 = true;
    public static boolean invertRightMotor2 = false;
    
    public static boolean invertRightEncoder = false;
	public static boolean invertLeftEncoder = false;
	public static String visionNetworkTableName = "GRIP/myContoursReport";

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainleftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "leftEncoder", driveTrainleftEncoder);
        driveTrainleftEncoder.setDistancePerPulse(1.0);
        driveTrainleftEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainrightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive Train", "rightEncoder", driveTrainrightEncoder);
        driveTrainrightEncoder.setDistancePerPulse(1.0);
        driveTrainrightEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainleftMotor1 = new Talon(0);
        LiveWindow.addActuator("Drive Train", "leftMotor1", (Talon) driveTrainleftMotor1);
        
        driveTrainleftMotor2 = new Talon(2);
        LiveWindow.addActuator("Drive Train", "leftMotor2", (Talon) driveTrainleftMotor2);
        
        driveTrainrightMotor1 = new Talon(1);
        LiveWindow.addActuator("Drive Train", "rightMotor1", (Talon) driveTrainrightMotor1);
        
        driveTrainrightMotor2 = new Talon(3);
        LiveWindow.addActuator("Drive Train", "rightMotor2", (Talon) driveTrainrightMotor2);
        
        driveTrainrobotDrive = new RobotDrive(driveTrainleftMotor2, driveTrainleftMotor1,
              driveTrainrightMotor2, driveTrainrightMotor1);
        driveTrainrobotDrive.setInvertedMotor(MotorType.kRearLeft, invertLeftMotor1);
        driveTrainrobotDrive.setInvertedMotor(MotorType.kFrontLeft, invertLeftMotor2);
        driveTrainrobotDrive.setInvertedMotor(MotorType.kRearRight, invertRightMotor1);
        driveTrainrobotDrive.setInvertedMotor(MotorType.kFrontRight, invertRightMotor2);
        driveTrainrobotDrive.setSafetyEnabled(true);
        driveTrainrobotDrive.setExpiration(0.1);
        driveTrainrobotDrive.setSensitivity(0.5);
        driveTrainrobotDrive.setMaxOutput(1.0);

        driveTrainshiftingSolenoid = new DoubleSolenoid(0, 5, 6);
        LiveWindow.addActuator("Drive Train", "shiftingSolenoid", driveTrainshiftingSolenoid);
        
        blooperblooperPot = new AnalogPotentiometer(1, 1.0, 0.0);
        LiveWindow.addSensor("Blooper", "blooperPot", blooperblooperPot);
        
        blooperblooperMotor = new Victor(4);
        LiveWindow.addActuator("Blooper", "blooperMotor", (Victor) blooperblooperMotor);
        
        collectorcollectorActuationMotor = new VictorSP(6);
        LiveWindow.addActuator("Collector", "collectorActuationMotor", (VictorSP) collectorcollectorActuationMotor);
        
        collectorcollectorPot = new AnalogPotentiometer(2, 1.0, 0.0);
        LiveWindow.addSensor("Collector", "collectorPot", collectorcollectorPot);
        
        collectorcollectorMotor = new Relay(0);
        LiveWindow.addActuator("Collector", "collectorMotor", collectorcollectorMotor);
        
        manipulatormanipulatorPot = new AnalogPotentiometer(3, 1.0, 0.0);
        LiveWindow.addSensor("Manipulator", "manipulatorPot", manipulatormanipulatorPot);
        
        manipulatormanipulatorActuationMotor = new VictorSP(7);
        LiveWindow.addActuator("Manipulator", "manipulatorActuationMotor", (VictorSP) manipulatormanipulatorActuationMotor);
        
        shooteractuationSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Shooter", "actuationSolenoid", shooteractuationSolenoid);
        
        shootertriggerSolenoid = new DoubleSolenoid(0, 3, 4);
        LiveWindow.addActuator("Shooter", "triggerSolenoid", shootertriggerSolenoid);
        
        shootershooterSolenoid = new Solenoid(0, 2);
        LiveWindow.addActuator("Shooter", "shooterSolenoid", shootershooterSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Drive Train", "Gyro", driveTrainGyro);
        lightRelay = new Relay(1);
        LiveWindow.addActuator("Drive Train", "Light", lightRelay);
    }
}
