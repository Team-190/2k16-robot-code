
package org.usfirst.frc190.frc2k16.commands.collector;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollectSequence extends CommandGroup {
    
    public CollectorCollectSequence() {
    	addParallel(new CollectorPositionCollect(true));
    	addSequential(new CollectorLoad());
    	
    	addSequential(new CollectorRollIn(), 0.5);
    	
    	addSequential(new CollectorPositionStore(true), 2);
    }
}
