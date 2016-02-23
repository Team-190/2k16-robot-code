package org.usfirst.frc190.frc2k16;

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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {  
	
/***** PWM *****/
	
	public static final int 
		DRIVE_MOTOR_RIGHT1 = 0, 
		DRIVE_MOTOR_LEFT1 = 1, 
		DRIVE_MOTOR_LEFT2 = 2,
    	DRIVE_MOTOR_RIGHT2 = 3;
	
	public static final int 
		BLOOPERS_MOTOR = 5;
	
	public static final int 
		MANIPULATOR_MOTOR = 7;
	
	public static final int 
		COLLECTOR_MOTOR = 6, 
		COLLECTOR_ROLLER_MOTOR = 4;
	
/***** DIO *****/
	
	public static final int 
		DRIVE_ENCODER_RIGHT_A = 0, 
		DRIVE_ENCODER_RIGHT_B = 1,
		DRIVE_ENCODER_LEFT_A = 2, 
		DRIVE_ENCODER_LEFT_B = 3;
    		
	public static final int 
		COLLECTOR_BOULDER_SWITCH = 6;
	
	public static final int 
		SHOOTER_REEDSENSOR = 7;
	
	public static final int 
		BLOOP_UP_LIMIT = 4,
		BLOOP_DOWN_LIMIT = 5;
	
/***** Analog In *****/
	
	public static final int 
		BLOOPERS_POT = 0;
	
	public static final int 
		COLLECTOR_POT = 1;
	
	public static final int 
		MANIPULATOR_POT = 2;
	
/***** Relay *****/
	
	public static final int 
		CAMERA_RELAY_LIGHT = 0;
	
/***** PCM *****/
	
	public static final int 
		SHOOTER_SOLENOID_ACTUATION_F = 0, 
		SHOOTER_SOLENOID_ACTUATION_B = 1,
		SHOOTER_SOLENOID_AIRSPRING = 2,
		SHOOTER_SOLENOID_TRIGGER_F = 3, 
		SHOOTER_SOLENOID_TRIGGER_B = 4;			
	
	public static final int 
		DRIVE_SOLENOID_SHIFTING_F = 6, 
		DRIVE_SOLENOID_SHIFTING_B = 7;
    
/***** Inversions *****/
	
    public static final boolean 
    	DRIVE_INVERT_LEFTMOTOR1 = false, 
    	DRIVE_INVERT_LEFTMOTOR2 = false,
    	DRIVE_INVERT_RIGHTMOTOR1 = false, 
    	DRIVE_INVERT_RIGHTMOTOR2 = true;
    
	public static final boolean 
		DRIVE_INVERT_LEFTENCODER = false, 
		DRIVE_INVERT_RIGHTENCODER = true;
	
/***** Constants *****/
	
	public static final double 
		shiftToHighPoint = 8, 
		shiftToLowPoint = 5, 
		highGearE = 4.8, 
		lowGearE = 8.6;
	
/***** Setpoints *****/
	
	public static final double 
		BLOOPERS_SETPOINT_UP = 0.45,
		BLOOPERS_SETPOINT_FORWARD = 0.1, 
		BLOOPERS_SETPOINT_BACKWARD = 0.8;
	
	public static final double 
		COLLECTOR_SETPOINT_UP = 0, 
		COLLECTOR_SETPOINT_DOWN = 0;
	
	public static final double 
		MANIPULATOR_SETPOINT_UP = 0, 
		MANIPULATOR_SETPOINT_DOWN = 0;
	
/***** Misc. *****/
	
	public static String NETWORKTABLE_VISION = "GRIP/myContoursReport";
	
	public static final double ticksToInches = 10000/117.5;
	
    public static void init() {
        /*
        
        lightRelay = new Relay(1);
        LiveWindow.addActuator("Drive Train", "Light", lightRelay);
        
        pistonReedSensor = new DigitalInput(5);
        LiveWindow.addSensor("Shooter", "reedSensor", pistonReedSensor);*/
    }
}
