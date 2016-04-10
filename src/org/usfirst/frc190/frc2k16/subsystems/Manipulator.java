
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorManualActuation;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Manipulator extends PIDSubsystem {
	
    protected final AnalogPotentiometer potentiometer;
    protected final CANTalon actuationMotor;
    protected final double tolerance = 0.01;

    public Manipulator(int motorPort, int potentiometerPort) {
        this(15.0, 0.0, 0.0, motorPort, potentiometerPort, "Manipulator");
    }
    
    public Manipulator(double kP, double kI, double kD,
    		int motorPort, int potentiometerPort, String subsystemName) {
        super(subsystemName, kP, kI, kD);
        setAbsoluteTolerance(tolerance);
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
    	
    	SmartDashboard.putBoolean("Manipulator OnTarget", this.onTarget());
    	SmartDashboard.putNumber("Manipulator POT", potentiometer.get());
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
