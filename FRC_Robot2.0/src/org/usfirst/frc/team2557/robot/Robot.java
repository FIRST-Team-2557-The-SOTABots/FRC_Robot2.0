//2.82 counts per foot
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearCenterShootLeft;
import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearCenterShootRight;
import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearLeftHopper;
import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearLeftShoot;
import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearRightHopper;
import org.usfirst.frc.team2557.robot.autonomous.Autonomous_GearRightShoot;
import org.usfirst.frc.team2557.robot.autonomous.ShiftToggle_autoCmd;
import org.usfirst.frc.team2557.robot.commands.Agitator_cmd;
import org.usfirst.frc.team2557.robot.commands.DriveToTarget_cmd;
import org.usfirst.frc.team2557.robot.commands.GearGrab_toggle;
import org.usfirst.frc.team2557.robot.commands.PsuedoShooter_cmd;
import org.usfirst.frc.team2557.robot.subsystems.Acceleration_sub;
import org.usfirst.frc.team2557.robot.subsystems.Agitator_sub;
import org.usfirst.frc.team2557.robot.subsystems.Chassis_sub;
import org.usfirst.frc.team2557.robot.subsystems.Climber_sub;
import org.usfirst.frc.team2557.robot.subsystems.Gear_sub;
import org.usfirst.frc.team2557.robot.subsystems.Intake_sub;
import org.usfirst.frc.team2557.robot.subsystems.PsuedoShooter_sub;
import org.usfirst.frc.team2557.robot.subsystems.Shooter_sub;
import org.usfirst.frc.team2557.robot.subsystems.SmartDashboard_sub;
import org.usfirst.frc.team2557.robot.vision.VisionArray_sub;
import org.usfirst.frc.team2557.robot.vision.Vision_cmd;
import org.usfirst.frc.team2557.robot.vision.centerX_gear;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis_sub 		chassis 		= new Chassis_sub();
	public static final Shooter_sub	 		shooter 		= new Shooter_sub();
	public static final Intake_sub 			intake 			= new Intake_sub();
	public static final Gear_sub 			gear 			= new Gear_sub();
	public static final Climber_sub 		climber 		= new Climber_sub();
	public static final Agitator_sub 		agitator 		= new Agitator_sub();
	public static final PsuedoShooter_sub 	psuedoShooter 	= new PsuedoShooter_sub();
	public static final Acceleration_sub 	accel			= new Acceleration_sub();
	public static final SmartDashboard_sub  dashboard 		= new SmartDashboard_sub();
	public static final VisionArray_sub		vision			= new VisionArray_sub();
	public static OI oi;
	public double x = 45;

	Command driveTo;
	Command shiftUp;
	Command shiftDown;
	Command Main_auto;
	Command fakePID;
	Command visionUpdate;
	Command shooterUpdate;
	Command driveToTarget;
	public static Command leftX_gear;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		CameraServer.getInstance().startAutomaticCapture();
		vision.initializer();
		shooterUpdate = new PsuedoShooter_cmd();
		visionUpdate = new Vision_cmd();
		shiftUp = new ShiftToggle_autoCmd(true);
		shiftDown = new ShiftToggle_autoCmd(false);
		leftX_gear = new centerX_gear();
//		Main_auto = new Autonomous_GearLeftHopper();
//		Main_auto = new Autonomous_GearLeftShoot();
//		Main_auto = new Autonomous_GearRightHopper();
		
//		Main_auto = new Autonomous_GearRightShoot(); //GearLine up right
//		Main_auto = new Autonomous_GearCenterShootLeft(); //GearCenter
		
		
//		Main_auto = new Autonomous_GearCenterShootRight();

		
		
		fakePID = new PsuedoShooter_cmd();
		driveToTarget = new DriveToTarget_cmd();
		oi = new OI();
		oi.init();
		
		SmartDashboard.putData("Auto mode", chooser);
		chooser.addObject("Autonomous_GearLeftShoot: ", new Autonomous_GearLeftShoot());
		chooser.addObject("Autonomous_GearLeftHopper: ", new Autonomous_GearLeftHopper());
		chooser.addObject("Autonomous_GearRightShoot: ", new Autonomous_GearRightShoot());
		chooser.addObject("Autonomous_GearRightHopper: ", new Autonomous_GearRightHopper());
		chooser.addObject("Autonomous_GearCenterShootLeft: ", new Autonomous_GearCenterShootLeft());		
		chooser.addObject("Autonomous_GearCenterShootRight: ", new Autonomous_GearCenterShootRight());
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		RobotMap.euler.autoInit();
		Robot.chassis.resetDriveStraight();
		RobotMap.FLdrive.setEncPosition(0);
		RobotMap.BRdrive.setEncPosition(0);
		RobotMap.navX.reset();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		autonomousCommand = (Command) chooser.getSelected();
		autonomousCommand.start();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		RobotMap.euler.update();
		SmartDashboard.putNumber("Left Encoder: ", RobotMap.FLdrive.getEncPosition());
		SmartDashboard.putNumber("Right Encoder: ", RobotMap.BRdrive.getEncPosition());
		SmartDashboard.putNumber("NavX Angle is: ",RobotMap.navX.getAngle());
		SmartDashboard.putNumber("DriveStraight Angle is: ",Robot.chassis.getDriveStraightAngle());
		
		if(RobotMap._stage){
			RobotMap.gearGrab.set(Value.kForward);
		}
		else if (RobotMap._stage == false){
			RobotMap.gearGrab.set(Value.kReverse);
		}
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
//		driveToTarget.start();
//		if (autonomousCommand != null)
//			autonomousCommand.cancle();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		RobotMap.euler.update();
		visionUpdate.start();
		shooterUpdate.start();
		if(oi.x1.get()){
			RobotMap.FLdrive.setEncPosition(0);
			RobotMap.FRdrive.setEncPosition(0);
			RobotMap.navX.reset();
		}
		if(oi.RB1.get()){
			shiftUp.start();
			return;
		}
		else if(oi.LB1.get()){
			shiftDown.start();
			return;
		}
		
		
		
		
//		if(oi.gamepad1.getRawAxis(3) > 0.1){
//			fakePID.start();
//		}
		
//		if(oi.a1.get()) {
//    		if(vision.averageInterpretation(2, 0, 0, 167, 0, .05) == false){
//    			if(vision.findCenterXs(0) < 167){
//    				RobotMap.robotDrive.tankDrive(-.5,.7); //-.52
//    			}
//    			else if(vision.findCenterXs(0) > 167){
//    				RobotMap.robotDrive.tankDrive(-.5,-.7); //.52
//    			}
//    			else{
//    				RobotMap.robotDrive.tankDrive(0,0);
//    			}
//    		}
//    		else{
//    			RobotMap.robotDrive.tankDrive(-.6,-.6);
//    		}
//    		
//    	}
		if(oi.a1.get()) {
    		if(vision.averageInterpretation(2, 0, 0, 217, 0, .08) == false){
    			if(vision.findCenterXs(0) < 217){
    				RobotMap.robotDrive.arcadeDrive(-.9,-.7); //-.52
    			}
    			else if(vision.findCenterXs(0) > 217){
    				RobotMap.robotDrive.arcadeDrive(-.9,.7); //.52
    			}
    			else{
    				RobotMap.robotDrive.arcadeDrive(0,0);
    			}
    		}
    		else{
    			RobotMap.robotDrive.arcadeDrive(-.8,0);
    		}
    		
    	}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
