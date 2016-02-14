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

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class DriveRotateDegrees extends Command {
    private double m_heading;
    private double threshold = 3;
    private final double maxRotationalSpeed = 0.75;
	private final double Kp = 0.04;

    public DriveRotateDegrees(double heading) {

        m_heading = heading;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainGyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angle = RobotMap.driveTrainGyro.getAngle();
    	double error = (m_heading - angle) * Kp;
    	
    	double rotationalSpeed = error;
    	if (rotationalSpeed > maxRotationalSpeed) rotationalSpeed = maxRotationalSpeed;
    	else if (rotationalSpeed < -maxRotationalSpeed) rotationalSpeed = -maxRotationalSpeed;
    	
    	Robot.driveTrain.arcadeDrive(0, rotationalSpeed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(m_heading - RobotMap.driveTrainGyro.getAngle()) <= threshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
