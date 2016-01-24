package org.usfirst.frc.team190.robot.commands;

import org.usfirst.frc.team190.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorUnload extends Command {

    public CollectorUnload() {
        requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.unload();
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
