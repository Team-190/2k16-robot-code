
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;

import org.usfirst.frc190.frc2k16.Robot;

/**
 *
 */
public class VisionAlignWithGoal extends Command {

	NetworkTable table;
	double[] defaultValueX;
	double[] defaultValueHeight;
	double[] centerX;
	double[] height;
	
	final double actualHeight = 14;
	final double fovMultiplier = 1.5;
	
	final double desiredDistance = 5;
	
	final double FOVhorizontal = 1280 ; //pixels
	final double FOV = 59.7/2;

	double distance;
    public VisionAlignWithGoal() {

        requires(Robot.driveTrain);

        table = NetworkTable.getTable("GRIP/myContoursReport");
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
			System.out.println("Centered");
		} else {
			double angle = - (centerX[0] - 160) / 160;
			
			distance = ((180*actualHeight)/(2*height[0]))*fovMultiplier;
			
			double bound = 24;
			double speed = (distance-bound)/120;
			
			System.out.println("Range(in): "+ distance);
			System.out.println("Speed: "+ speed);
			System.out.println("Angle" + angle);
			
			Robot.driveTrain.arcadeDrive(speed, angle);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (distance < desiredDistance) || (centerX.length == 0 || height.length == 0);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
