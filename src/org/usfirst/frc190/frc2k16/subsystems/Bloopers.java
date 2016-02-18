
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Bloopers extends PIDSubsystem {

    private final AnalogPotentiometer potentiometer;
    private final SpeedController actuationMotor;

    // Initialize your subsystem here
    public Bloopers() {
        super("Blooper", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Blooper", "PIDSubsystem Controller", getPIDController());
        
        actuationMotor = new VictorSP(RobotMap.BLOOPERS_MOTOR);
        potentiometer = new AnalogPotentiometer( RobotMap.BLOOPERS_POTENTIOMETER, 1, 0);
    }

    public void initDefaultCommand() {
    	
    }

    protected double returnPIDInput() {
        return potentiometer.get();
    }

    protected void usePIDOutput(double output) {
        actuationMotor.pidWrite(output);
    }
}
