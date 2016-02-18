
package org.usfirst.frc190.frc2k16.subsystems;

import org.usfirst.frc190.frc2k16.RobotMap;
import org.usfirst.frc190.frc2k16.commands.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Collector extends Subsystem{

    private final SpeedController collectorActuationMotor = RobotMap.collectorcollectorActuationMotor;
    private final AnalogPotentiometer collectorPot = RobotMap.collectorcollectorPot;
    private final SpeedController collectorMotor = RobotMap.collectorcollectorMotor;

    public void initDefaultCommand() {
    	
    }
    
    public void stop(){
    	collectorMotor.set(0);
    }
    
    public void collect(){
    	collectorMotor.set(-1);
    }
    
    public void release(){
    	collectorMotor.set(1);
    }

}
