
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.StoreManipulators;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopForward;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftAuto;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftLow;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftManual;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForDistance;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForTime;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
	
	final static double m_driveDistance = 15.0;
	
    public AutoDriveForward() {
    	
    	addSequential(new DriveShiftManual());
    	addSequential(new DriveShiftLow());
    	addSequential(new StoreManipulators());
    	addSequential(new BlooperBloopForward(), 1);
    	addSequential(new DriveStraightForDistance(m_driveDistance, 0), 5);
    	addSequential(new DriveShiftAuto());
    	
    } 
}
