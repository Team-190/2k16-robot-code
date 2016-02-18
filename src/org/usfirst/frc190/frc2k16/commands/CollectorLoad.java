
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.Robot;

/**
 *
 */
public class CollectorLoad extends CommandGroup {

    public CollectorLoad() {
        
    	addSequential(new CollectorPositionDown());
    	addSequential(new CollectorRollIn());

    }
}
