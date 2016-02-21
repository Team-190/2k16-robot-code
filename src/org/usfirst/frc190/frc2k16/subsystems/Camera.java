package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Relay lightRelay;
	
	public Camera() {
		lightRelay = new Relay(RobotMap.CAMERA_RELAY_LIGHT);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lightOn() {
    	lightRelay.set(Relay.Value.kForward);
    }
    
    public void lightOff() {
    	lightRelay.set(Relay.Value.kOff);
    }
}

