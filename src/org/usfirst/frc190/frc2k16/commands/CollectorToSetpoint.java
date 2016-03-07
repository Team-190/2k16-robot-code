package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorToSetpoint extends Command {

	public final double setpoint;
    public CollectorToSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.setSetpoint(setpoint);
    	Robot.collector.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.collector.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
