
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionDown;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionStore;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionCVF;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionDown;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonExtend;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterRaise;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class PrepareForHighShot extends CommandGroup {
	
    public PrepareForHighShot() {
    	
    	addSequential(new PrepareForCVF(), 1);
    	
    	addSequential(new ShooterMainPistonExtend());
    	
    	addSequential(new ShooterRaise());
    	
    }
}