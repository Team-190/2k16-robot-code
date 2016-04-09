package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionUnload;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorRollOut;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchDisengage;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchEngage;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonExtend;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonRetract;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShootLowGoal extends CommandGroup {
    
    public  ShootLowGoal() {
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
    	
    	addSequential(new ShooterLatchDisengage());
    	
    	addParallel(new ShooterMainPistonExtend());
    	addSequential(new CollectorRollOut(), 1);
    	
    	addSequential(new ShooterMainPistonRetract());
    	
    	addSequential(new WaitCommand(2.5));
    	
    	addSequential(new ShooterLatchEngage());
    	
    }
}
