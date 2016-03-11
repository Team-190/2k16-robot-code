package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManipulatorManualActuation extends Command {

	public ManipulatorManualActuation() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.manipulator);
		System.out.println("Init");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//Robot.manipulator.move(Robot.oi.getJoystick1().getY());
		//System.out.println("M Pot: " + Robot.manipulator.getPot());
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
		System.out.println("Interrupted!");
	}
}
