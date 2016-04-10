package org.usfirst.frc190.frc2k16.commands;

import org.usfirst.frc190.frc2k16.Robot;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchDisengage;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchEngage;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLower;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonExtend;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonRetract;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterRaise;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShootHighGoal extends CommandGroup {
    
	double raiseTimeout = 1.5;
	double shootTimeout = 1.0;
	
    public  ShootHighGoal() {
    	
    	addSequential(new ShooterRaise());
    	
    	addSequential(new ShooterMainPistonExtend());
    	
    	addSequential(new ShooterLatchDisengage());
    	
    	addSequential(new WaitCommand(shootTimeout));
    	
    	addSequential(new ShooterLower(), 0.1);
    	
    	addSequential(new ShooterMainPistonRetract());
    	
    	addSequential(new ShooterLatchEngage());
    	
    }
}
