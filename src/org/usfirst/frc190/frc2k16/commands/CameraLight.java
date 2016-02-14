package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraLight extends Command {

    public CameraLight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.lightRelay.set(Relay.Value.kReverse);
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

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.lightRelay.set(Relay.Value.kForward);
    }
}
