
package org.usfirst.frc190.frc2k16.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;

/**
 *
 */
public class CollectorPositionDown extends Command {

    private double m_setpoint;
    
    public CollectorPositionDown(double setpoint) {
    	
        m_setpoint = setpoint;
        
        requires(Robot.collector);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {

       // Robot.collector.enable();
       // Robot.collector.setSetpoint(m_setpoint);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false; //Robot.collector.onTarget();

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
