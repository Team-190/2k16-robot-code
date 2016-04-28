
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.CameraLight;
import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
import org.usfirst.frc190.frc2k16.commands.ShootHighGoal;
import org.usfirst.frc190.frc2k16.commands.VisionAlignWithGoal;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveRotateDegrees;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForDistance;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoDistanceLowerAndHighGoal extends CommandGroup {

    public AutoDistanceLowerAndHighGoal() {
    	
    	// 90 degrees
    	// 3.75
    	// -90 degrees
    	// 8.4
    	
    	// 10.8, 21.5

    	addSequential(new AutoLowerAndDriveForward(12.75));
    	addSequential(new DriveStraightForDistance(7.7, -10));
    	addSequential(new ShootHighGoal());
 
    } 
}
