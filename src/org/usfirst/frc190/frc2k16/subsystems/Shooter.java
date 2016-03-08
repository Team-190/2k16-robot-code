package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
	
    //private final DoubleSolenoid actuationSolenoid;
    private final Victor actuationMotor;
	private final DoubleSolenoid triggerSolenoid;
    private final Solenoid airSpringSolenoid;
    
    private final DigitalInput reedSensor;
    private final DigitalInput limitSwitch;
    private final AnalogInput actuationPot;
    
    private boolean latchOn;
    public Shooter() {
    	//actuationSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_SOLENOID_ACTUATION_F, RobotMap.SHOOTER_SOLENOID_ACTUATION_B);
    	actuationMotor = new Victor(RobotMap.SHOOTER_MOTOR);
    	triggerSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_SOLENOID_TRIGGER_F, RobotMap.SHOOTER_SOLENOID_TRIGGER_B);
    	airSpringSolenoid = new Solenoid(RobotMap.SHOOTER_SOLENOID_AIRSPRING);
    	
    	reedSensor = new DigitalInput(RobotMap.SHOOTER_REEDSENSOR);
    	limitSwitch = new DigitalInput(RobotMap.SHOOTER_LIMIT_SWITCH);
    	actuationPot = new AnalogInput(RobotMap.SHOOTER_POT);
    	latchOn = true;
	}

    public void initDefaultCommand() {
       
    }
    
    public void extend(){
    	airSpringSolenoid.set(true);
    }
    
    public void retract(){
    	airSpringSolenoid.set(false);
    }
    
    public void raise() {
    	//actuationSolenoid.set(DoubleSolenoid.Value.kForward);
    	actuationMotor.set(1);
    }
    
    public void lower() {
    	//actuationSolenoid.set(DoubleSolenoid.Value.kReverse);
    	actuationMotor.set(-1);
    }
    
    public void stop(){
    	actuationMotor.set(0);
    }
    
    public boolean isStowed(){
    	return limitSwitch.get();
    }
    
    public void release(){
    	triggerSolenoid.set(DoubleSolenoid.Value.kForward);
    	latchOn = false;
    }
    
    public void latch(){
    	triggerSolenoid.set(DoubleSolenoid.Value.kReverse);
    	latchOn = true;
    }
    public void latchToggle(){
    	if(latchOn)release();
    	else latch();
    }
}

