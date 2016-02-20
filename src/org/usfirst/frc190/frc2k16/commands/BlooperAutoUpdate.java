package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.subsystems.Bloopers;
import org.usfirst.frc190.frc2k16.subsystems.Bloopers.BlooperPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BlooperAutoUpdate extends Command {

	private double mBackwardsThreshold = 0;
	private double mForwardsThreshold = 0;
	private BlooperPosition mCurrentPosition = Bloopers.BlooperPosition.NEUTRAL;

    public BlooperAutoUpdate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.blooper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.blooper.enable();
    	Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_UP);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.driveTrain.getLeftEncoderRate() > mForwardsThreshold &&
    		Robot.driveTrain.getRightEncoderRate() > mForwardsThreshold &&
    		mCurrentPosition != Bloopers.BlooperPosition.FORWARD) {    		
    		Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_FORWARD);
    	} else if(Robot.driveTrain.getLeftEncoderRate() < mBackwardsThreshold &&
    			Robot.driveTrain.getRightEncoderRate() < mBackwardsThreshold &&
    			mCurrentPosition != Bloopers.BlooperPosition.BACKWARD) {
			Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_BACKWARD);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
