
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
    public Joystick joystick1;
    public Joystick joystick2;
    
    JoystickButton lightButton;
    JoystickButton vision;
    JoystickButton shifter;
    JoystickButton load;
    JoystickButton unload;
    JoystickButton shoot;
    
    JoystickButton bloopForward;
    JoystickButton bloopBack;
    JoystickButton bloopMiddle;

    public OI() { 
        joystick1 = new Joystick(0);
        joystick2 = new Joystick(1);
        
/******* Joystick 1 *******/  
        
        Robot.driveTrain.arcadeDrive(joystick1.getY(), joystick1.getX());
        
        lightButton = new JoystickButton(joystick1, 1);
        lightButton.toggleWhenPressed(new CameraLight());
        
        shifter = new JoystickButton(joystick1, 2);
        shifter.toggleWhenPressed(new Shifter());
        
       // vision = new JoystickButton(joystick1, 3);
       // vision.whenPressed(new VisionAlignWithGoal());
        
        bloopForward = new JoystickButton(joystick1, 4);
        bloopForward.whenPressed(new BlooperBloopForward());
        
        bloopBack = new JoystickButton(joystick1, 5);
        bloopBack.whenPressed(new BlooperBloopBackward());
        
      //  bloopMiddle = new JoystickButton(joystick1, 3);
      //  bloopMiddle.whenPressed(new BlooperBloopUp());
        
/******* Joystick 2 *******/
  /*      
        shoot = new JoystickButton(joystick2, 1);
        shoot.toggleWhenPressed(new Shoot());
        
        load = new JoystickButton(joystick2, 2);
        load.toggleWhenPressed(new CollectorLoad());
        
        unload = new JoystickButton(joystick2, 3);
        unload.toggleWhenPressed(new CollectorUnload());
        */

/******* SmartDashboard Buttons *******/
        
        SmartDashboard.putData("VisionAlignWithGoal", new VisionAlignWithGoal());
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
        SmartDashboard.putData("LED On", new CameraLight());

    }

    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }

}

