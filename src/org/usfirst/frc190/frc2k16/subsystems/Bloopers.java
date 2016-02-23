
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

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
		BACKWARD, FORWARD, NEUTRAL
	}

    private final AnalogPotentiometer potentiometer;
    private final VictorSP actuationMotor;
    
    private final DigitalInput up_limit, down_limit;
    
    // Initialize your subsystem here
    public Bloopers() {
        super("Blooper", 4.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Blooper", "PIDSubsystem Controller", getPIDController());
 
        actuationMotor = new VictorSP(RobotMap.BLOOPERS_MOTOR);
        LiveWindow.addActuator("Blooper", "PIDSubsystem", actuationMotor);
        
        potentiometer = new AnalogPotentiometer(RobotMap.BLOOPERS_POT, 1, 0);
        LiveWindow.addSensor("Blooper", "Potentiometer", potentiometer);
        
        up_limit = new DigitalInput(RobotMap.BLOOP_UP_LIMIT);
        LiveWindow.addSensor("Blooper", "PIDSubsystem Controller", up_limit);
        
        down_limit = new DigitalInput(RobotMap.BLOOP_DOWN_LIMIT);
        LiveWindow.addSensor("Blooper", "PIDSubsystem", down_limit);
        
    }
    
    public void manualControl(double speed) {
    	if(!(up_limit.get() && speed > 0) || (down_limit.get() && speed < 0)) actuationMotor.set(speed);
    }

    public void initDefaultCommand() {
    	//setDefaultCommand(new BlooperBloopUp());
    	setDefaultCommand(new ManualBloop(Robot.oi.getJoystick2()));
    }

    protected double returnPIDInput() {
        return potentiometer.get();
    }

    protected void usePIDOutput(double output) {
    	manualControl(output);
    }
}
