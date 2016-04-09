
package org.usfirst.frc190.frc2k16.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class ShooterMainPistonRetract extends Command {

    public ShooterMainPistonRetract() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.retractMainPiston();
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
