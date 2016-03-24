
package org.usfirst.frc190.frc2k16.commands.collector;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollect extends CommandGroup {
    
    public CollectorCollect() {
    	addParallel(new CollectorPositionCollect());
    	addSequential(new CollectorLoadBall());
    	addSequential(new CollectorPositionStore(), 1);
    }
}
