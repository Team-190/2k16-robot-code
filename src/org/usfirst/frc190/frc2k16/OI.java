// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc190.frc2k16;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick1;
    public Joystick joystick2;
    
    JoystickButton lightOnButton;
    JoystickButton lightOffButton;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick2 = new Joystick(1);
        
        joystick1 = new Joystick(0);
        
        lightOnButton = new JoystickButton(joystick1, 1);
        lightOnButton.whenPressed(new CameraLightOn());
        
        lightOffButton = new JoystickButton(joystick1, 2);
        lightOffButton.whenPressed(new CameraLightOff());

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("VisionAlignWithGoal", new VisionAlignWithGoal());
        //SmartDashboard.putData("DriveStraightForDistance", new DriveStraightForDistance());
        SmartDashboard.putData("DriveManualControl", new DriveManualControl());
        //SmartDashboard.putData("BlooperBloopUp", new BlooperBloopUp());
        //SmartDashboard.putData("BlooperBloopForward", new BlooperBloopForward());
        //SmartDashboard.putData("BlooperBloopBackward", new BlooperBloopBackward());
        //SmartDashboard.putData("ClooperAutomaticControl", new ClooperAutomaticControl());
        //SmartDashboard.putData("CollectorPositionUp", new CollectorPositionUp());
        //SmartDashboard.putData("CollectorPositionDown", new CollectorPositionDown());
        SmartDashboard.putData("CollectorManualControl", new CollectorManualControl());
        //SmartDashboard.putData("ManipulatorPositionUp", new ManipulatorPositionUp());
        //SmartDashboard.putData("ManipulatorPositionDown", new ManipulatorPositionDown());
        SmartDashboard.putData("ManipulatorManualControl", new ManipulatorManualControl());
        SmartDashboard.putData("PrepareForLowBar", new PrepareForLowBar());
        SmartDashboard.putData("CollectorLoad", new CollectorLoad());
        SmartDashboard.putData("CollectorUnload", new CollectorUnload());
        SmartDashboard.putData("TestAutoNavigation", new TestAutoNavigation());
        SmartDashboard.putData("DriveRotateDegrees", new DriveRotateDegrees(90));
        SmartDashboard.putData("ShooterExtend", new ShooterExtend());
        SmartDashboard.putData("ShooterRetract", new ShooterRetract());
        SmartDashboard.putData("ShooterShoot", new ShooterShoot());
        SmartDashboard.putData("LED On", new CameraLightOn());
        SmartDashboard.putData("LED Off", new CameraLightOff());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        Robot.driveTrain.arcadeDrive(joystick1.getY(), joystick1.getX());
        
    
    
    
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

