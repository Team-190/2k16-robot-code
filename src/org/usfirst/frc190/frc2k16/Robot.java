  	 
package org.usfirst.frc190.frc2k16;

import org.usfirst.frc190.frc2k16.commands.*;
import org.usfirst.frc190.frc2k16.commands.auto.AutoRaiseAndDriveForward;
import org.usfirst.frc190.frc2k16.commands.auto.AutoRaiseDriveForwardAndReverse;
import org.usfirst.frc190.frc2k16.commands.auto.AutoLowerAndDriveForward;
import org.usfirst.frc190.frc2k16.commands.auto.AutoLowerDriveForwardAndReverse;
import org.usfirst.frc190.frc2k16.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    
    public static DriveTrain driveTrain;
    public static Bloopers blooper;
    public static Collector collector;
    public static Manipulator manipulator;
    public static Shooter shooter;
    public static Camera camera;
    
    public static double autoSelect;
    
    Compressor compressor;
    DriverStation ds;
    
    CameraServer server;
    
    SendableChooser chooser;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	
        driveTrain = new DriveTrain();
        blooper = new Bloopers();
        collector = new Collector(RobotMap.COLLECTOR_MOTOR, RobotMap.COLLECTOR_POT);
        manipulator = new Manipulator(RobotMap.MANIPULATOR_MOTOR, RobotMap.MANIPULATOR_POT);
        shooter = new Shooter();
        camera = new Camera();

        oi = new OI();  //OI must be created after subsystems. 
        
        compressor = new Compressor(0);
    	compressor.setClosedLoopControl(true);
    	
    	ds = DriverStation.getInstance();
    	autoSelect = SmartDashboard.getNumber("DB/Slider 0", 0.0);
    	
    	server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");

/***** Autonomous Selection *****/
    	
    	chooser = new SendableChooser();
    	chooser.addDefault("No Auto", null);
    	chooser.addObject("Lower Arms and Drive Forward", new AutoLowerAndDriveForward());
    	chooser.addDefault("Raise arms & Drive Forward", new AutoRaiseAndDriveForward());
    	chooser.addDefault("Drive Forward, and Drive Back", new AutoRaiseDriveForwardAndReverse());
    	chooser.addDefault("Lower Arms, Drive Forward, and Drive Back", new AutoLowerDriveForwardAndReverse());
    	
    	// Enable these when we code the commands
    	//chooser.addObject("Drive Forward & Back (Arms Raised)", new AutoForwardBack());
       	//chooser.addObject("Drive Forward & Back (Arms Down)", new AutoLowerForwardBack());
    	//chooser.addObject("Cross & Shoot (Arms Up)", new AutoCrossShoot());
    	//chooser.addObject("Cross & Shoot (Arms Down)", new AutoLowerCrossShoot());
    	//chooser.addObject("Drive From Spy and Shoot High", new AutoShootSpy());
    	SmartDashboard.putData("Auto Mode Selector", chooser);
    	
    	autonomousCommand = new AutoRaiseAndDriveForward();
    	
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        driveTrain.shiftLow();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
