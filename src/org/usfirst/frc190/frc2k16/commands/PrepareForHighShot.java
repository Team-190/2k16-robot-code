
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionDown;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionCVF;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionDown;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class PrepareForHighShot extends CommandGroup {
	
    public PrepareForHighShot() {

        addParallel(new CollectorPositionDown(true));
        addSequential(new ManipulatorPositionCVF(true));
    }
}