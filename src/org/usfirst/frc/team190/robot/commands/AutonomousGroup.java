package org.usfirst.frc.team190.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
    
    public  AutonomousGroup() {
    	addSequential(new DriveStraight());
    }
}
