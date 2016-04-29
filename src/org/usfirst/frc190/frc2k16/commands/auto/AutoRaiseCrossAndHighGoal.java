
package org.usfirst.frc190.frc2k16.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc190.frc2k16.commands.CameraLight;
import org.usfirst.frc190.frc2k16.commands.PrepareForHighShot;
import org.usfirst.frc190.frc2k16.commands.PrepareForLowBar;
import org.usfirst.frc190.frc2k16.commands.ShootHighGoal;
import org.usfirst.frc190.frc2k16.commands.VisionAlignWithGoal;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveRotateDegrees;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveStraightForDistance;
import org.usfirst.frc190.frc2k16.subsystems.*;

/**
 *
 */
public class AutoRaiseCrossAndHighGoal extends CommandGroup {
	
	enum DefenceNumber {
		ONE, TWO, THREE, FOUR, FIVE
	}

    public AutoRaiseCrossAndHighGoal(DefenceNumber number) {
    	
    	// 90 degrees
    	// 3.75
    	// -90 degrees
    	// 8.4
    	
    	// 10.8, 21.5
    	
    	addSequential(new AutoRaiseAndDriveForward(10));
    	addSequential(new PrepareForHighShot());
    	
    	switch (number) {
		case THREE: {
			
			addSequential(new DriveStraightForDistance(5, 33));
					
			break;
		}
					
		case FOUR: {
			
			addSequential(new DriveStraightForDistance(5, 0));
	    	
			break;
		}
			
		case FIVE: {
			
			addSequential(new DriveStraightForDistance(5, -45));
			
			break;
		}

		default:
			break;
		}
    	
    	addSequential(new ShootHighGoal());
 
    }
    
    public AutoRaiseCrossAndHighGoal() {
		this(DefenceNumber.FOUR);
	}
}
