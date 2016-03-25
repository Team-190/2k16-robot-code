
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.CameraLight;
import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
import org.usfirst.frc190.frc2k16.commands.VisionAlignWithGoal;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveRotateDegrees;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForDistance;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoNavigationTest extends CommandGroup {

    public AutoNavigationTest() {

    	addParallel(new PrepareForLowBar());
    	addParallel(new CameraLight());
    	addSequential(new DriveStraightForDistance(1050, 0));	
    	addSequential(new DriveRotateDegrees(90));
    	addSequential(new DriveStraightForDistance(0, 0));
    	addSequential(new VisionAlignWithGoal());
 
    } 
}
