package org.usfirst.frc190.GabeGoat.commands;

import org.usfirst.frc190.GabeGoat.Robot;
import org.usfirst.frc190.GabeGoat.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turn extends Command {

	double currentAngle;
	double finalAngle;
	double speed;
	
    public Turn(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	finalAngle = angle; 
    }
    
    public Turn()
    {
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finalAngle = SmartDashboard.getNumber("TurnAngle");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = RobotMap.gyro.getAngle();
    	speed = (finalAngle - currentAngle)/60;
    	Robot.driveGabe.turn(-speed);
    	System.out.println("Current Angle: " + currentAngle + "Speed: " + speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return speed < .05;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putNumber("TurnAngle", 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
