package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.subsystems.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class ManipulatorToSetpoint extends Command {
	private final double setpoint;

    public ManipulatorToSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.manipulator);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.manipulator.setSetpoint(setpoint);
    	Robot.manipulator.enable();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.manipulator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.manipulator.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
