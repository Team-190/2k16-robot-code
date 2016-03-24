
package org.usfirst.frc190.frc2k16.commands.drivetrain;

import edu.wpi.first.wpilibj.PIDController;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PIDSource;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.subsystems.DriveTrain;

public class DriveStraightForTime extends Command {
	
	private double m_heading;
	private double m_time;
    
    private double kP = 1;
    double Kp = 0.03;

    public DriveStraightForTime(double time) {

        m_heading = 0;
        m_time = time;
        
        setTimeout(time);
        
        requires(Robot.driveTrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angle = Robot.driveTrain.getGyroAngle();
    	System.out.println("Encoders: " + (Robot.driveTrain.getLeftEncoderDistance() + Robot.driveTrain.getRightEncoderDistance())/2);
    	
    	Robot.driveTrain.arcadeDrive(-1, -angle*Kp);
   }
    	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
