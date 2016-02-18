
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Blooper extends PIDSubsystem {

    private final AnalogPotentiometer blooperPot = RobotMap.blooperblooperPot;
    private final SpeedController blooperMotor = RobotMap.blooperblooperMotor;

    // Initialize your subsystem here
    public Blooper() {
    	
        super("Blooper", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Blooper", "PIDSubsystem Controller", getPIDController());
        
    }

    public void initDefaultCommand() {
    	
    }

    protected double returnPIDInput() {
    	
        return blooperPot.get();

    }

    protected void usePIDOutput(double output) {
    	
        blooperMotor.pidWrite(output);

    }
}
