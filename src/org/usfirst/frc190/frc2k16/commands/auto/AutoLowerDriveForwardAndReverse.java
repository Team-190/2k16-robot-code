
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopBackward;
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
public class AutoLowerDriveForwardAndReverse extends CommandGroup {
	
	final static double m_driveForwardDistance = 15.0;
	final static double m_driveReverseDistance = -10.0;
	
    public AutoLowerDriveForwardAndReverse() {
    	
    	addSequential(new DriveShiftManual());
    	addSequential(new DriveShiftLow());
    	addSequential(new PrepareForLowBar(), 2);
    	addSequential(new BlooperBloopForward(), 1);
    	addSequential(new DriveStraightForDistance(m_driveForwardDistance, 0), 5);
    	addSequential(new BlooperBloopBackward(), 1);
    	addSequential(new DriveStraightForDistance(m_driveReverseDistance, 0), 5);	
    	addSequential(new DriveShiftAuto());
 
    } 
}
