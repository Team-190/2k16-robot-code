
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class BlooperBloopUp extends Command {

    private double m_setpoint;

    public BlooperBloopUp() {

        m_setpoint = RobotMap.BLOOPERS_SETPOINT_UP;

        requires(Robot.blooper);

    }

    protected void initialize() {
    	
        Robot.blooper.enable();
        Robot.blooper.setSetpoint(m_setpoint);
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.blooper.manualControl(Robot.oi.getJoystick2().getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.blooper.onTarget();

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
