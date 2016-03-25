
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperAutoUpdate;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */

public class Bloopers extends PIDSubsystem {
	public enum BlooperPosition{
		BACKWARD, FORWARD, UP
	}

    private final AnalogPotentiometer potentiometer;
    private final VictorSP actuationMotor;
    
    private final DigitalInput up_limit, down_limit;
    
    BlooperPosition blooperPosition;
    
    // Initialize your subsystem here
    public Bloopers() {
        super("Bloopers", 4.0, 0.0, 0.0);
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Bloopers", "PIDSubsystem Controller", getPIDController());
 
        actuationMotor = new VictorSP(RobotMap.BLOOPERS_MOTOR);
        LiveWindow.addActuator("Bloopers", "Motor", actuationMotor);
        
        potentiometer = new AnalogPotentiometer(RobotMap.BLOOPERS_POT, 1, 0);
        LiveWindow.addSensor("Bloopers", "Potentiometer", potentiometer);
        
        up_limit = new DigitalInput(RobotMap.BLOOP_UP_LIMIT);
        LiveWindow.addSensor("Bloopers", "Up Limit", up_limit);
        
        down_limit = new DigitalInput(RobotMap.BLOOP_DOWN_LIMIT);
        LiveWindow.addSensor("Bloopers", "Down Limit", down_limit);
        
    }
    
    public BlooperPosition getBlooperPosition() {
    	return blooperPosition;
    }
    
    public void bloopForward() {
    	setSetpoint(RobotMap.BLOOPERS_SETPOINT_FORWARD);
    	blooperPosition = BlooperPosition.FORWARD;
    }
    
    public void bloopUp() {
    	setSetpoint(RobotMap.BLOOPERS_SETPOINT_UP);
    	blooperPosition = BlooperPosition.UP;
    }
    
    public void bloopBackward() {
    	setSetpoint(RobotMap.BLOOPERS_SETPOINT_BACKWARD);
    	blooperPosition = BlooperPosition.BACKWARD;
    }
    
    public void manualControl(double speed) {
    	if ((up_limit.get() && speed < 0) || (down_limit.get() && speed > 0) || (!down_limit.get() && !up_limit.get())) {
    		actuationMotor.set(speed);
    	} else {
    		actuationMotor.set(0);
    	}
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new BlooperAutoUpdate());
    }

    protected double returnPIDInput() {
        return potentiometer.get();
    }

    protected void usePIDOutput(double output) {
    	manualControl(output);
    }
}
