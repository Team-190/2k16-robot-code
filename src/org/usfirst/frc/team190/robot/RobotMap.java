package org.usfirst.frc.team190.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// JOYSTICKS
	public static int leftJoystick = 0;
	public static int rightJoystick = 1;
	
	// SPEED CONTROLLERS
	public static int rightTalon = 0;
	public static int leftTalon = 1;
	public static int collectorPivotVictor = 2;
	public static int collectorRollerVictor = 3;
	
	// INVERSIONS
	public static boolean invertLeftDrive = true;
	public static boolean invertRightDrive = true;
	
	public static boolean invertLeftEncoder = true;
	public static boolean invertRightEncoder = false;
	
	// ENCODERS
	public static int leftEncoderA = 0;
	public static int leftEncoderB = 1;
	public static int rightEncoderA = 2;
	public static int rightEncoderB = 3;
	
	// ANALOG INPUTS
	public static int blooperPot = 0;
	public static int gyro = 0;
	public static int accelerometer = 0;
}
