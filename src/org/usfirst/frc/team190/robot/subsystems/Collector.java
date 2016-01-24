package org.usfirst.frc.team190.robot.subsystems;

import org.usfirst.frc.team190.robot.RobotMap;
import org.usfirst.frc.team190.robot.commands.CollectorIdle;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
    
	VictorSP pivot; // Pivot Joint
	VictorSP intake; // Intake Rollers 
	VictorSP roller; // Internal mechanism to move boulder inside robot
    
	public Collector() {
		pivot = new VictorSP(RobotMap.collectorPivotVictor);
		roller = new VictorSP(RobotMap.collectorRollerVictor);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new CollectorIdle());
    }
	
	public void idle() {
		pivot.set(0);
		roller.set(0);
	}
	
	public void load() {
		pivot.set(1);
		roller.set(1);
	}
	
	public void unload() {
		pivot.set(-1);
		roller.set(-1);
	}
}

