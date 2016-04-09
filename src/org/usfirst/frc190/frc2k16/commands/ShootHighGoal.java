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
    
	double shootTimeout = 0;
	
    public  ShootHighGoal() {
    	
    	addSequential(new ShooterRaise(), 0.25);
    	addSequential(new ShooterMainPistonExtend());
    	addSequential(new ShooterLatchDisengage());
    	addSequential(new WaitCommand(shootTimeout));
    	addSequential(new ShooterMainPistonRetract(), 1);
    	addSequential(new ShooterLatchEngage());
    	addSequential(new ShooterLower());
    	
    }
}
