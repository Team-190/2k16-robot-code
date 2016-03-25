
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorManualActuation;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Manipulator extends PIDSubsystem {
	
    protected final AnalogPotentiometer potentiometer;
    protected final CANTalon actuationMotor;

    public Manipulator(int motorPort, int potentiometerPort) {
        super("Manipulator", 12.0, 0.0, 10.0);
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
        
        LiveWindow.addActuator("Manipulator", "PIDSubsystem Controller", getPIDController());
        
        potentiometer = new AnalogPotentiometer(potentiometerPort, 1, 0);
        actuationMotor = new CANTalon(motorPort);
        actuationMotor.setInverted(RobotMap.MANIPULATOR_INVERT_MOTOR);
        
        LiveWindow.addActuator("Manipulator", "actuationMotor", actuationMotor);
        LiveWindow.addSensor("Manipulator", "potentiometer", potentiometer);
    }
    
    public Manipulator(double kP, double kI, double kD,
    		int motorPort, int potentiometerPort, String subsystemName) {
        super(subsystemName, kP, kI, kD);
        setAbsoluteTolerance(0.01);
        getPIDController().setContinuous(false);
        
        potentiometer = new AnalogPotentiometer(potentiometerPort, 1, 0);
        actuationMotor = new CANTalon(motorPort);
        
        LiveWindow.addActuator(subsystemName, "PIDSubsystem Controller", getPIDController());
        LiveWindow.addActuator(subsystemName, "actuationMotor", actuationMotor);
        LiveWindow.addSensor(subsystemName, "potentiometer", potentiometer);
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
