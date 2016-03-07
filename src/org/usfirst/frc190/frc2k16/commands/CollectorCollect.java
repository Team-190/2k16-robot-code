package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorCollect extends Command {

    public CollectorCollect() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.setSetpoint(RobotMap.COLLECTOR_SETPOINT_DOWN);
    	Robot.collector.enable();
    	Robot.collector.collect();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.collector.onTarget()) Robot.collector.disable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.collector.hasBall();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
