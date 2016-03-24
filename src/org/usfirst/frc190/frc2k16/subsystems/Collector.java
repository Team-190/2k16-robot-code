
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorManualActuation;

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
	
	private final VictorSP rollersMotor;
	private final DigitalInput limitSwitch;
	
	public Collector(int motorPort, int potentiometerPort) {
		super(8.0, 0.0, 6.0, motorPort, potentiometerPort, "Collector");
		
		rollersMotor = new VictorSP(RobotMap.COLLECTOR_ROLLER_MOTOR);
		limitSwitch = new DigitalInput(RobotMap.COLLECTOR_BOULDER_SWITCH);
		
		actuationMotor.setInverted(true);
		
		LiveWindow.addActuator("Collector", "rollersMotor", rollersMotor);
		LiveWindow.addSensor("Collector", "limitSwitch", limitSwitch);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorManualActuation());
    }
    
    @Override
    protected void usePIDOutput(double output) {
    	System.out.println("C Pot: " + potentiometer.get());
    	super.usePIDOutput(output);
    }
    
    public boolean readLimitSwitch() {
		return limitSwitch.get();
	}
    
    public void stopRollers(){
    	rollersMotor.set(0);
    }
    
    public void collect(){
    	rollersMotor.set(1);
    }
    
    public void release(){
    	rollersMotor.set(-1);
    }
    
    public boolean hasBall(){
    	return limitSwitch.get();
    }

}
