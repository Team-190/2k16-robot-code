package org.usfirst.frc190.frc2k16.commands.bloopers;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BlooperManualControl extends Command {

	public BlooperManualControl() {
    	requires(Robot.blooper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.blooper.manualControl(Robot.oi.getJoystick1().getX());
    	
    	/*if (Robot.oi.getJoystick1().getRawButton(4)) {
    		Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_BACKWARD);
    	} else if (Robot.oi.getJoystick1().getRawButton(5)) {
    		Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_UP);
    	} else if (Robot.oi.getJoystick1().getRawButton(6)) {
    		Robot.blooper.setSetpoint(RobotMap.BLOOPERS_SETPOINT_FORWARD);
    	}*/
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
    }
}
