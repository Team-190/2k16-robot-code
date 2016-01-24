package org.usfirst.frc.team190.robot.commands;

import org.usfirst.frc.team190.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

    public DriveStraight() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// Reset min/max encoder data and buffer length
    	Robot.drive.buffer = 150;
    	
    	Robot.drive.minLeftEncoderRate = 99999;
    	Robot.drive.maxLeftEncoderRate = -99999;
    	
    	Robot.drive.minRightEncoderRate = 99999;
    	Robot.drive.maxRightEncoderRate = -99999;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(0.5);
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
