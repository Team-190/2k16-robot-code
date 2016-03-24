
package org.usfirst.frc190.frc2k16.commands.collector;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class CollectorPositionCollect extends Command {
    
    public CollectorPositionCollect() {
        requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.setSetpoint(RobotMap.COLLECTOR_SETPOINT_LOAD);
        Robot.collector.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.disable();
    	Robot.collector.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
