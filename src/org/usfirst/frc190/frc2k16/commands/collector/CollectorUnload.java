
package org.usfirst.frc190.frc2k16.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.Robot;

/**
 *
 */
public class CollectorUnload extends CommandGroup {

    public CollectorUnload() {
        
    	addSequential(new CollectorPositionDown());
    	addSequential(new CollectorRollOut());

    }
    
}
