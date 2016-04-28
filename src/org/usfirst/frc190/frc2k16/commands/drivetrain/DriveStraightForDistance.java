
package org.usfirst.frc190.frc2k16.commands.drivetrain;

import edu.wpi.first.wpilibj.PIDController;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PIDSource;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.subsystems.DriveTrain;

public class DriveStraightForDistance extends Command {

    private double m_distance;
    private double m_heading;
    
    private double kP = 1;
    double kP_gyro = 0.03;

    public DriveStraightForDistance(double distance, double heading) {

        m_distance = distance;
        m_heading = heading;
        
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
    	double error = (((Robot.driveTrain.getLeftEncoderDistance() + Robot.driveTrain.getRightEncoderDistance())/2) - m_distance) * kP;
    	
    	Robot.driveTrain.arcadeDrive(error, (m_heading-angle)*kP_gyro);
   }
    	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ((Robot.driveTrain.getLeftEncoderDistance() + Robot.driveTrain.getRightEncoderDistance())/2) >= Math.abs(m_distance);
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
