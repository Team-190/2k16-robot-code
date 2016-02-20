
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Collector extends Manipulator {
	
	private final Victor rollersMotor;
	private final DigitalInput limitSwitch;
	
	public Collector(int motorPort, int potentiometerPort) {
		super(motorPort, potentiometerPort);
		
		rollersMotor = new Victor(RobotMap.COLLECTOR_ROLLER_MOTOR);
		limitSwitch = new DigitalInput(RobotMap.COLLECTOR_BOULDER_SWITCH);
	}

    public void initDefaultCommand() {
    	
    }
    
    public void stop(){
    	rollersMotor.set(0);
    }
    
    public void collect(){
    	rollersMotor.set(-1);
    }
    
    public void release(){
    	rollersMotor.set(1);
    }

}
