package org.usfirst.frc190.frc2k16.commands.drivetrain;

import org.usfirst.frc190.frc2k16.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveShiftHigh extends Command {

    public DriveShiftHigh() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (!Robot.driveTrain.autoShifting){
    		Robot.driveTrain.shiftHigh();
    	}
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
