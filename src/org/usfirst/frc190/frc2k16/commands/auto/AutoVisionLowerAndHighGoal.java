
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
public class AutoVisionLowerAndHighGoal extends CommandGroup {

    public AutoVisionLowerAndHighGoal() {

    	addSequential(new AutoLowerAndDriveForward());
    	addSequential(new VisionAlignWithGoal());
    	addSequential(new DriveStraightForDistance(2, 0));
 
    } 
}
