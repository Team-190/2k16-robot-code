
package org.usfirst.frc190.frc2k16.commands.drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

/**
 *
 */
public class DriveRotateDegrees extends Command {
    private double m_heading;
    private double threshold = 3;
    private final double maxRotationalSpeed = 0.75;
	private final double Kp = 0.03;

    public DriveRotateDegrees(double heading) {

        m_heading = heading;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angle = Robot.driveTrain.getGyroAngle();
    	double error = (m_heading - angle) * Kp;
    	
    	double rotationalSpeed = error;
    	if (rotationalSpeed > maxRotationalSpeed) rotationalSpeed = maxRotationalSpeed;
    	else if (rotationalSpeed < -maxRotationalSpeed) rotationalSpeed = -maxRotationalSpeed;
    	
    	Robot.driveTrain.arcadeDrive(0, rotationalSpeed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(m_heading - Robot.driveTrain.getGyroAngle()) <= threshold;
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
