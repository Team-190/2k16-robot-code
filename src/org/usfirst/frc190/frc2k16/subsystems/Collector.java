
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Collector extends Manipulator {
	
	private final VictorSP rollersMotor;
	private final DigitalInput limitSwitch;
	
	public Collector(int motorPort, int potentiometerPort) {
		super(20.0, 0.05, 10.0, motorPort, potentiometerPort, "Collector");
		
		rollersMotor = new VictorSP(RobotMap.COLLECTOR_ROLLER_MOTOR);
		limitSwitch = new DigitalInput(RobotMap.COLLECTOR_BOULDER_SWITCH);
		
		actuationMotor.setInverted(RobotMap.COLLECTOR_INVERT_MOTOR);
		
		LiveWindow.addActuator("Collector", "rollersMotor", rollersMotor);
		LiveWindow.addSensor("Collector", "limitSwitch", limitSwitch);
	}

    public void initDefaultCommand() {
    	//setDefaultCommand(new CollectorManualActuation());
    }
    
    @Override
    protected void usePIDOutput(double output) {
    	SmartDashboard.putBoolean("Collector OnTarget", this.onTarget());
    	SmartDashboard.putNumber("Collector POT", potentiometer.get());
    	super.usePIDOutput(output);
    }
    
    public boolean readLimitSwitch() {
		return limitSwitch.get();
	}
    
    public void stopRollers(){
    	rollersMotor.set(0);
    }
    
    public void collect(){
    	rollersMotor.set(1);
    }
    
    public void release(){
    	rollersMotor.set(-1);
    }
    
    public boolean hasBall(){
    	return limitSwitch.get();
    }

}
