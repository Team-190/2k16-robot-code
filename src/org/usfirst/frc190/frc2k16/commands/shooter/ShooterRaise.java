package org.usfirst.frc190.frc2k16.commands.shooter;

import org.usfirst.frc190.frc2k16.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterRaise extends Command {

    public ShooterRaise() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	setTimeout(1.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.raise();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
