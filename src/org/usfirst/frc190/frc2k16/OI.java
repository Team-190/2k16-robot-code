
package org.usfirst.frc190.frc2k16;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.auto.AutoNavigationTest;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperAutoUpdate;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopBackward;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopForward;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperBloopUp;
import org.usfirst.frc190.frc2k16.commands.bloopers.BlooperManualControl;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorCollectSequence;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorManualDown;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorManualUp;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionDown;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorPositionStore;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorRollIn;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorRollOut;
import org.usfirst.frc190.frc2k16.commands.collector.CollectorStopRoll;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveRotateDegrees;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftAuto;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftHigh;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftLow;
import org.usfirst.frc190.frc2k16.commands.drivetrain.DriveShiftManual;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorManualActuation;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorManualDown;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorManualUp;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionDown;
import org.usfirst.frc190.frc2k16.commands.manipulator.ManipulatorPositionStore;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonExtend;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLower;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterRaise;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterLatchToggle;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterMainPistonRetract;
import org.usfirst.frc190.frc2k16.commands.shooter.ShooterShoot;
import org.usfirst.frc190.frc2k16.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick joystick0;
    private Joystick joystick1;
    
    private Joystick panelA;
    private Joystick panelB;
    
    // Positions
    JoystickButton lowBarPositionButton;
    JoystickButton chivalDeFrisePositionButton;
    JoystickButton stowArmsPositionButton;
    JoystickButton collectPositionButton;
    
    // Shooter
    JoystickButton shootHighGoalButton;
    JoystickButton shootLowGoalButton;
    JoystickButton shooterUpButton;
    JoystickButton shooterDownButton;
    JoystickButton pistonLatchButton;
    JoystickButton pistonExtendButton;
    JoystickButton pistonRetractButton;
    
    // Scaler
    JoystickButton scalerButton;
    
    // Manipulators & Collectors
    JoystickButton collectorUpButton;
    JoystickButton collectorDownButton;
    JoystickButton manipulatorUpBitton;
    JoystickButton manipulatorDownButton;
    JoystickButton rollersInButton;
    JoystickButton rollersOutButton;
    
    // Drive Train
    JoystickButton shiftHighButton;
    JoystickButton shiftLowButton; 
    
    JoystickButton bloopForwardButton;
    JoystickButton bloopBackButton;
    JoystickButton bloopMiddleButton;
    
    JoystickButton bloopAutoButton;
    
    JoystickButton bloopManualSwitch;
    JoystickButton shiftManualSwitch;
    
    // Misc
    JoystickButton lightButton;

    public OI() { 
        joystick0 = new Joystick(0);
        joystick1 = new Joystick(1);
        
        panelA = new Joystick(2);
        panelB = new Joystick(3);
        
/******* Joystick 0 *******/  
        
        shiftLowButton = new JoystickButton(joystick0, 4);
        shiftLowButton.whenPressed(new DriveShiftLow());
        
        shiftHighButton = new JoystickButton(joystick0, 5);
        shiftHighButton.whenPressed(new DriveShiftHigh());
        
/******* Joystick 1 *******/
  /*      
        shoot = new JoystickButton(joystick2, 1);
        shoot.toggleWhenPressed(new Shoot());
        
        load = new JoystickButton(joystick2, 2);
        load.toggleWhenPressed(new CollectorLoad());
        
        unload = new JoystickButton(joystick2, 3);
        unload.toggleWhenPressed(new CollectorUnload());
        */
        
        bloopAutoButton = new JoystickButton(joystick1, 2);
        bloopAutoButton.whenPressed(new BlooperAutoUpdate());
        
        bloopMiddleButton = new JoystickButton(joystick1, 3);
        bloopMiddleButton.whenPressed(new BlooperBloopUp());
        
        bloopBackButton = new JoystickButton(joystick1, 4);
        bloopBackButton.whenPressed(new BlooperBloopBackward());
        
        bloopForwardButton = new JoystickButton(joystick1, 5);
        bloopForwardButton.whenPressed(new BlooperBloopForward());

/******* Panel A *******/
        
        pistonExtendButton = new JoystickButton(panelA, 2);
        pistonExtendButton.whenPressed(new ShooterMainPistonExtend());
        
        pistonRetractButton = new JoystickButton(panelA, 1);
        pistonRetractButton.whenPressed(new ShooterMainPistonRetract());
        
        manipulatorDownButton = new JoystickButton(panelA, 3);
        manipulatorDownButton.whileHeld(new ManipulatorManualDown());
        
        manipulatorUpBitton = new JoystickButton(panelA, 4);
        manipulatorUpBitton.whileHeld(new ManipulatorManualUp());
        
        scalerButton = new JoystickButton(panelA, 5);
        scalerButton.whenPressed(new PrepareForHighShot());
        //ADD COMMAND FOR SCALING
        
        shootLowGoalButton = new JoystickButton(panelA, 6);
        shootLowGoalButton.whenPressed(new ShootLowGoal());
        
        shootHighGoalButton = new JoystickButton(panelA, 7);
        shootHighGoalButton.whenPressed(new ShootHighGoal());
        
        collectPositionButton = new JoystickButton(panelA, 8);
        collectPositionButton.whenPressed(new CollectorCollectSequence());
        
        stowArmsPositionButton = new JoystickButton(panelA, 9);
        stowArmsPositionButton.whenPressed(new StoreManipulators());
        
        chivalDeFrisePositionButton = new JoystickButton(panelA, 10);
        chivalDeFrisePositionButton.whenPressed(new PrepareForCVF());
        
        lowBarPositionButton = new JoystickButton(panelA, 11);
        lowBarPositionButton.whenPressed(new PrepareForLowBar());
        
/******* Panel B *******/
        
        collectorDownButton = new JoystickButton(panelB, 3);
        collectorDownButton.whileHeld(new CollectorManualDown());
        
        collectorUpButton = new JoystickButton(panelB, 4);
        collectorUpButton.whileHeld(new CollectorManualUp());
        
        pistonLatchButton = new JoystickButton(panelB, 5);
        pistonLatchButton.whenPressed(new ShooterLatchToggle());
        
        shooterDownButton =  new JoystickButton(panelB, 6);
        shooterDownButton.whileHeld(new ShooterLower());
        
        shooterUpButton = new JoystickButton(panelB, 7);
        shooterUpButton.whileHeld(new ShooterRaise());
        
        rollersOutButton = new JoystickButton(panelB, 8);
        rollersOutButton.whileHeld(new CollectorRollOut());
        rollersOutButton.whenReleased(new CollectorStopRoll());
        
        rollersInButton = new JoystickButton(panelB, 9);
        rollersInButton.whileHeld(new CollectorRollIn());
        rollersInButton.whenReleased(new CollectorStopRoll());
        
        shiftManualSwitch = new JoystickButton(panelB, 10);
        shiftManualSwitch.whileHeld(new DriveShiftManual());
        shiftManualSwitch.whenReleased(new DriveShiftAuto());
        
        bloopManualSwitch = new JoystickButton(panelB, 11);
        bloopManualSwitch.whileActive(new BlooperManualControl());
        bloopManualSwitch.whenReleased(new BlooperAutoUpdate());
        
        SmartDashboard.putData("CollectorPositionDown", new CollectorPositionDown(true));

    }

    public Joystick getJoystick0() {
        return joystick0;
    }

    public Joystick getJoystick1() {
        return joystick1;
    }

}

