
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopForward;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForDistance;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoLowerAndDriveForward extends CommandGroup {
	
	final static double m_driveDistance = 12;
	
    public AutoLowerAndDriveForward() {
    	
    	addSequential(new PrepareForLowBar(), 3);
    	addSequential(new BlooperBloopForward(), 1);
    	addSequential(new DriveStraightForDistance(m_driveDistance, 0), 7);	
 
    } 
}
