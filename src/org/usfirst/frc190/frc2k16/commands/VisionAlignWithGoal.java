// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc190.frc2k16.Robot;

/**
 *
 */
public class VisionAlignWithGoal extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
	NetworkTable table;
	double[] defaultValueX;
	double[] defaultValueHeight;
	double[] centerX;
	double[] height;
	
	final double actualHeight = 14;
	final double fovMultiplier = 4.8;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	double distance;
    public VisionAlignWithGoal() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	centerX = table.getNumberArray("centerX", defaultValueX);
		height = table.getNumberArray("height", defaultValueHeight);
		if (centerX.length == 0 || height.length == 0) {
			Robot.driveTrain.stop();
		} else {
			// TODO Auto-generated method stub
			//double distance = (180 - height[0]) / 180;			
			double angle = - (centerX[0] - 160) / 160;
			distance = ((180*actualHeight)/(2*height[0]))*fovMultiplier;
			double bound = 24;
			double speed = (distance-bound)/120;
			System.out.println("Range(in): "+distance);
			System.out.println("Speed: "+speed);
			//System.out.println("Distance: " + distance + "\nAngle: " + angle);
			Robot.driveTrain.arcadeDrive(speed, angle);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distance < 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
