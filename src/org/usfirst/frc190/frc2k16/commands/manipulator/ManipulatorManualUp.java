
package org.usfirst.frc190.frc2k16.commands.manipulator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class ManipulatorManualUp extends Command {
	
	public ManipulatorManualUp() {
    	requires(Robot.manipulator);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.manipulator.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.manipulator.move(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.manipulator.disable();
    	Robot.manipulator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
