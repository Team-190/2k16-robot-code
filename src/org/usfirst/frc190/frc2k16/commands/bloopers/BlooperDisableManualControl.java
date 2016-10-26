package org.usfirst.frc190.frc2k16.commands.bloopers;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BlooperDisableManualControl extends Command {

	public BlooperDisableManualControl() {
    	requires(Robot.blooper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.blooper.manualBloopEnabled = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
