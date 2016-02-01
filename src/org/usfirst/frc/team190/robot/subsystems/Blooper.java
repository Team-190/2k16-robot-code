package org.usfirst.frc.team190.robot.subsystems;

import org.usfirst.frc.team190.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Blooper extends PIDSubsystem {

	Potentiometer pot;
	
	VictorSP bloopMotor;
	
	public Blooper() {
        super("Blooper", 0, 0, 0);
        
        pot = new AnalogPotentiometer(RobotMap.blooperPot);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        return pot.get();
    }
    
    protected void usePIDOutput(double output) {
        
    }
}
