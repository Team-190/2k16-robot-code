
package org.usfirst.frc190.frc2k16.commands.bloopers;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class BlooperBloopUp extends Command {

	public BlooperBloopUp() {
		requires(Robot.blooper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.blooper.manualBloopEnabled) {
			Robot.blooper.autoBloop = false;
			Robot.blooper.enable();
			Robot.blooper.bloopUp();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Robot.blooper.manualControl(Robot.oi.getJoystick2().getY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.blooper.onTarget() || !Robot.blooper.manualBloopEnabled;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.blooper.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
