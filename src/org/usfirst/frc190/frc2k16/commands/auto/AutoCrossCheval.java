
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
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
public class AutoCrossCheval extends CommandGroup {
	
    public AutoCrossCheval() {
    	
    	addSequential(new DriveShiftManual());
    	addSequential(new DriveShiftLow());
    	
    	addSequential(new BlooperBloopForward(), 1);
    	
    	addSequential(new DriveStraightForDistance(5, 0));
    	
    	addSequential(new WaitCommand(1));
    	
    	addSequential(new PrepareForLowBar(), 2);
    	
    	addSequential(new DriveStraightForDistance(7, 0, 0.5));
    		
    	addSequential(new DriveShiftAuto());
 
    }
    
}
