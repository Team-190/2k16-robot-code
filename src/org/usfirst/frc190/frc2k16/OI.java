
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
    private Joystick joystick1;
    private Joystick joystick2;
    
    private Joystick panel;
    
    JoystickButton lowBar;
    JoystickButton CVF;
    JoystickButton stow;
    JoystickButton collect;
    JoystickButton highGoal;
    JoystickButton lowGoal;
    JoystickButton scalar;
    JoystickButton latch;
    JoystickButton frontUp;
    JoystickButton frontDown;
    JoystickButton backUp;
    JoystickButton backDown;
    JoystickButton shooterUp;
    JoystickButton shooterDown;
    JoystickButton rollersIn;
    JoystickButton rollersOut;
    JoystickButton pistonExtend;
    JoystickButton pistonRetract;
    
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

/******* Panel *******/
        
        lowBar = new JoystickButton(panel, 0);
        lowBar.whenPressed(new PrepareForLowBar());
        
        CVF = new JoystickButton(panel, 1);
        CVF.whenPressed(new PrepareForCVF());
        
        stow = new JoystickButton(panel, 2);
        stow.whenPressed(new StowManipulators());
        
        collect = new JoystickButton(panel, 3);
        collect.whenPressed(new CollectorCollect());
        
        highGoal = new JoystickButton(panel, 4);
        highGoal.whenPressed(new ShootHighGoal());
        
        lowGoal = new JoystickButton(panel, 5);
        lowGoal.whenPressed(new ShootLowGoal());
        
        scalar = new JoystickButton(panel, 6);
        //scalar.whenPressed(new ScalerScale());
        //ADD COMMAND FOR SCALING
        
        latch = new JoystickButton(panel, 7);
        latch.whenPressed(new ShooterLatchToggle());
        
        frontUp = new JoystickButton(panel, 8);
        frontUp.whileHeld(new CollectorPositionUp());
        
        frontDown = new JoystickButton(panel, 9);
        frontDown.whileHeld(new CollectorPositionDown());
        
        backUp = new JoystickButton(panel, 10);
        backUp.whileHeld(new ManipulatorPositionUp());
        
        backDown = new JoystickButton(panel, 11);
        backDown.whileHeld(new ManipulatorPositionDown());
        
        shooterUp = new JoystickButton(panel, 12);
        shooterUp.whileHeld(new ShooterGoUp());
        
        shooterDown =  new JoystickButton(panel, 13);
        shooterDown.whileHeld(new ShooterGoDown());
        
        rollersIn = new JoystickButton(panel, 14);
        rollersIn.whileHeld(new CollectorRollIn());
        
        rollersOut = new JoystickButton(panel, 15);
        rollersOut.whileHeld(new CollectorRollOut());
        
        pistonExtend = new JoystickButton(panel, 16);
        pistonExtend.whenPressed(new ShooterExtend());
        
        pistonRetract = new JoystickButton(panel, 17);
        pistonRetract.whenPressed(new ShooterRetract());
        
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

