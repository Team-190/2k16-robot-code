
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class BlooperBloopForward extends Command {
	
    private double m_setpoint;
    
    public BlooperBloopForward() {
    	
        m_setpoint = RobotMap.BLOOPERS_SETPOINT_FORWARD;
        
        requires(Robot.blooper);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
        Robot.blooper.enable();
        Robot.blooper.setSetpoint(m_setpoint);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.blooper.onTarget();

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
