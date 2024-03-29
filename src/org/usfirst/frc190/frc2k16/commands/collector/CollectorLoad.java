package org.usfirst.frc190.frc2k16.commands.collector;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CollectorLoad extends Command {
	
	PowerDistributionPanel pdp = new PowerDistributionPanel();
	double current_threshold = 15.0;
	
	Timer timer;
	boolean ballDetected = false;

    public CollectorLoad() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.collector);
    	//timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.collect();
    	System.out.println("Starting Collect");
    	
    	//timer.reset();
    	//timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("Ball Detected", ballDetected);
    	SmartDashboard.putBoolean("Collector Limit Switch", Robot.collector.readLimitSwitch());
    	SmartDashboard.putNumber("Roller Current", pdp.getCurrent(RobotMap.PDP_ROLLER_CHANNEL));
    	System.out.println("Collecting...");
    }

    // Make this return true when this Command no longer needs to run execute()
    double startupTime = 0.5;
	double shutdownTime = 0.0;
    protected boolean isFinished() {	
    	if (Robot.collector.readLimitSwitch()) {
    		System.out.println("Finished Collecting");
    		return true;
    	} else {
    		return false;
    	}
    	
    	/*boolean ballDetected = false;
    	
    	if (timer.get() > startupTime) {
    		if (pdp.getCurrent(RobotMap.PDP_ROLLER_CHANNEL) > current_threshold) {
    			ballDetected = true;
    			shutdownTime = timer.get() + 0.5;
    		}
    		
    		if (ballDetected && (shutdownTime != 0) && (timer.get() > shutdownTime)) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}*/
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stopRollers();
    	//timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
