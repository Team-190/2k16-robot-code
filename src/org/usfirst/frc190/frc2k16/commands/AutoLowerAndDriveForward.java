
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoLowerAndDriveForward extends CommandGroup {

    public AutoLowerAndDriveForward() {
    	
    	addSequential(new PrepareForLowBar(), 3);
    	addSequential(new DriveStraightForDistance(168, 0));	
 
    } 
}
