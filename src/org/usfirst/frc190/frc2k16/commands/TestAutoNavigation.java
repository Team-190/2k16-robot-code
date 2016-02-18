
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class TestAutoNavigation extends CommandGroup {

    public TestAutoNavigation() {

    	addParallel(new PrepareForLowBar());
    	addParallel(new CameraLight());
    	addSequential(new DriveStraightForDistance(1050, 0));	
    	addSequential(new DriveRotateDegrees(90));
    	addSequential(new DriveStraightForDistance(0, 0));
    	addSequential(new VisionAlignWithGoal());
 
    } 
}
