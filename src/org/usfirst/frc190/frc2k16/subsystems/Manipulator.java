
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Manipulator extends PIDSubsystem {
	
    private final AnalogPotentiometer manipulatorPot = RobotMap.manipulatormanipulatorPot;
    private final SpeedController manipulatorActuationMotor = RobotMap.manipulatormanipulatorActuationMotor;

    public Manipulator() {

        super("Manipulator", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Manipulator", "PIDSubsystem Controller", getPIDController());

    }

    public void initDefaultCommand() {
    	
    }

    protected double returnPIDInput() {
    	
        return manipulatorPot.get();

    }

    protected void usePIDOutput(double output) {
    	
        manipulatorActuationMotor.pidWrite(output);

    }
}
