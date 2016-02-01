package org.usfirst.frc190.GabeGoat.commands;

import org.usfirst.frc190.GabeGoat.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionTest extends Command {

	NetworkTable table;
	double[] defaultValueX;
	double[] defaultValueHeight;
	double[] centerX;
	double[] height;
	final double actualHeight = 14;
	final double fovMultiplier = 4.8;

	public VisionTest() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveGabe);
		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValueX = new double[1];
		defaultValueX[0] = 160;
		defaultValueHeight = new double[1];
		defaultValueHeight[0] = 180;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		centerX = table.getNumberArray("centerX", defaultValueX);
		height = table.getNumberArray("height", defaultValueHeight);
		if (centerX.length == 0 || height.length == 0) {
			Robot.driveGabe.stop();
		} else {
			// TODO Auto-generated method stub
			//double distance = (180 - height[0]) / 180;			
			double angle = - (centerX[0] - 160) / 160;
			double distance = ((180*actualHeight)/(2*height[0]))*fovMultiplier;
			double bound = 24;
			double speed = (distance-bound)/120;
			System.out.println("Range(in): "+distance);
			System.out.println("Speed: "+speed);
			//System.out.println("Distance: " + distance + "\nAngle: " + angle);
			Robot.driveGabe.arcadeDrive(speed, angle);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
