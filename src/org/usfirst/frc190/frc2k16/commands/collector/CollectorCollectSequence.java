
package org.usfirst.frc190.frc2k16.commands.collector;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollectSequence extends CommandGroup {
    
    public CollectorCollectSequence() {
    	addParallel(new CollectorPositionCollect(false));
    	addSequential(new CollectorLoad());
    	addSequential(new CollectorPositionStore(true), 2);
    }
}
