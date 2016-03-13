
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {

    public AutoDriveForward() {
    	
    	addSequential(new StoreManipulators());
    	addSequential(new BlooperBloopForward(), 1);
    	//addSequential(new DriveStraightForDistance(13, 0), 7);
    	addSequential(new DriveStraightForTime(7));
    	
    } 
}
