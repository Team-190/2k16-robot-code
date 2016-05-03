
package org.usfirst.frc190.frc2k16.commands.drivetrain;

import edu.wpi.first.wpilibj.PIDController;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDSource;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.subsystems.DriveTrain;

public class DriveStraightForDistance extends Command {

    private double m_distance;
    private double m_heading;
    private double m_threshold;
    
    private double m_speedlimit;
    
    private double kP = 1;
    double kP_gyro = 0.03;

    public DriveStraightForDistance(double distance, double heading) {

        m_distance = distance;
        m_heading = heading;
        m_threshold = 0.666;
        
        requires(Robot.driveTrain);

    }
    
    public DriveStraightForDistance(double distance, double heading, double speedlimit) {
    	this(distance, heading);
    	
    	m_speedlimit = speedlimit;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angleError = m_heading - Robot.driveTrain.getGyroAngle();
    	double currentDistanceTraveled = (Robot.driveTrain.getLeftEncoderDistance() + Robot.driveTrain.getRightEncoderDistance()) / 2;
    	double distanceError = (currentDistanceTraveled - m_distance);
    	
    	SmartDashboard.putNumber("Distance Error", distanceError);
    	
    	double speed = distanceError * kP;
    	double angle = angleError * kP_gyro;
    	
    	Robot.driveTrain.arcadeDrive((speed > m_speedlimit) ? m_speedlimit : speed, angle);
    }
    	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double currentDistanceTraveled = (Robot.driveTrain.getLeftEncoderDistance() + Robot.driveTrain.getRightEncoderDistance()) / 2;
    	boolean isFinished = Math.abs(currentDistanceTraveled - m_distance) <= m_threshold;
    	
    	SmartDashboard.putBoolean("IsFinished", isFinished);
    	if (isFinished) {
    		System.out.println("FINISHED DRIVING");System.out.println("FINISHED DRIVING");System.out.println("FINISHED DRIVING");System.out.println("FINISHED DRIVING");System.out.println("FINISHED DRIVING");
    	}
    	
    	return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
