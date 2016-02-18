
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
	
    private final DoubleSolenoid actuationSolenoid = RobotMap.shooteractuationSolenoid;
    private final DoubleSolenoid triggerSolenoid = RobotMap.shootertriggerSolenoid;
    private final Solenoid shooterSolenoid = RobotMap.shootershooterSolenoid;

    public void initDefaultCommand() {
       
    }
    
    public void extend(){
    	shooterSolenoid.set(true);
    }
    
    public void retract(){
    	shooterSolenoid.set(false);
    }
    
    public void release(){
    	triggerSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void latch(){
    	triggerSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

