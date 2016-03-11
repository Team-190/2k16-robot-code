
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Manipulator extends PIDSubsystem {
	
    private final AnalogPotentiometer potentiometer;
    private final CANTalon actuationMotor;

    public Manipulator(int motorPort, int potentiometerPort) {
        super("Manipulator", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Manipulator", "PIDSubsystem Controller", getPIDController());
        
        potentiometer = new AnalogPotentiometer(potentiometerPort, 1, 0);
        actuationMotor = new CANTalon(motorPort);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new ManipulatorManualActuation());
    }

    protected double returnPIDInput() {
    	
        return potentiometer.get();

    }

    protected void usePIDOutput(double output) {
    	
    	actuationMotor.pidWrite(output);

    }
    
    public double getPot() {
    	return potentiometer.get();
    }
    
    public void move(double speed){
    	actuationMotor.set(speed);
    }
    
    public void goUp(){
    	actuationMotor.set(1);
    }
    
    public void goDown(){
    	actuationMotor.set(-1);
    }
    
    public void stop(){
    	actuationMotor.set(0);
    }
}
