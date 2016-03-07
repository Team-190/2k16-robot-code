package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StowManipulators extends CommandGroup {
    
    public  StowManipulators() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	requires(Robot.manipulator);
    	requires(Robot.collector);
    	
    	addParallel(new ManipulatorToSetpoint(RobotMap.MANIPULATOR_SETPOINT_STOW));
    	addParallel(new CollectorToSetpoint(RobotMap.COLLECTOR_SETPOINT_STOW));
    }
}
