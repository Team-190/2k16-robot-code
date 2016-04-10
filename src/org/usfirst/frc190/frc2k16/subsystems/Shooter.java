package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchEngage;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
enum ShooterPosition {
	RAISED, LOWERED
}

public class Shooter extends Subsystem {
	
    //private final DoubleSolenoid actuationSolenoid;
    private final DoubleSolenoid latchSolenoid;
    private final Solenoid actuationSolenoid;
    private final Solenoid mainPistonSolenoid;
    
    private final DigitalInput shooterDownLimitSwitch;
    private final DigitalInput pistonDownLimitSwitch;
    
    private boolean latchOn;
    private boolean mainPistonOn;
    private ShooterPosition position;
    
    public Shooter() {
    	//actuationSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_SOLENOID_ACTUATION_F, RobotMap.SHOOTER_SOLENOID_ACTUATION_B);
    	latchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_SOLENOID_TRIGGER_F, RobotMap.SHOOTER_SOLENOID_TRIGGER_B);
    	actuationSolenoid = new Solenoid(RobotMap.SHOOTER_SOLENOID_ACTUATION);
    	mainPistonSolenoid = new Solenoid(RobotMap.SHOOTER_SOLENOID_MAINPISTON);
    	
    	shooterDownLimitSwitch = new DigitalInput(RobotMap.SHOOTER_DOWN_LIMIT);
    	pistonDownLimitSwitch = new DigitalInput(RobotMap.SHOOTER_PISTON_DOWN_LIMIT);
    	
    	latchOn = true;
    	mainPistonOn = false;
    	position = ShooterPosition.LOWERED;
    	
    	LiveWindow.addActuator("Shooter", "Latch Solenoid", latchSolenoid);
    	LiveWindow.addActuator("Shooter", "Actuation Solenoid", actuationSolenoid);
    	LiveWindow.addActuator("Shooter", "Main Piston Solenoid", mainPistonSolenoid);
    	
    	LiveWindow.addSensor("Shooter", "Shooter Down Switch", shooterDownLimitSwitch);
    	LiveWindow.addSensor("Shooter", "Piston Down Switch", pistonDownLimitSwitch);
	}

    public void initDefaultCommand() {
       setDefaultCommand(new ShooterLatchEngage());
    }
    
    public boolean pistonDown() {
    	return !pistonDownLimitSwitch.get();
    }
    
    public boolean shooterDown() {
    	return !shooterDownLimitSwitch.get();
    }
    
    public void extendMainPiston() {
    	mainPistonSolenoid.set(true);
    	mainPistonOn = true;
    }
    
    public void retractMainPiston() {
    	mainPistonSolenoid.set(false);
    	mainPistonOn = false;
    }
    
    public void raise() {
    	actuationSolenoid.set(true);
    	position = ShooterPosition.RAISED;
    }
    
    public void lower() {
    	actuationSolenoid.set(false);
    	position = ShooterPosition.LOWERED;
    }
    
    public boolean isStowed() {
    	return position == ShooterPosition.LOWERED;
    }
    
    public void engageLatch(){
    	latchSolenoid.set(DoubleSolenoid.Value.kReverse);
    	latchOn = true;
    }
    
    public void disengageLatch(){
    	latchSolenoid.set(DoubleSolenoid.Value.kForward);
    	latchOn = false;
    }
    
    public void latchToggle(){
    	if (latchOn) {
    		disengageLatch();
    	} else {
    		engageLatch();
    	}
    }
}

