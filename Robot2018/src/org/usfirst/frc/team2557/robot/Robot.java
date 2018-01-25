/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.ShiftToggle_autoCmd;
import org.usfirst.frc.team2557.robot.commands.auto;
import org.usfirst.frc.team2557.robot.subsystems.Chassis_sub;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static final Chassis_sub 		chassis 		= new Chassis_sub();
	public static Timer 					timer 			= new Timer();
	public static OI oi;
	
	CommandGroup auto;
	Command auto_cmd;
	Command driveTo;
	Command shiftUp;
	Command shiftDown;
	Command Main_auto;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Auto", new auto());
		SmartDashboard.putData("Auto Mode", chooser);
		RobotMap.init();
		RobotMap.shifter.set(Value.kReverse);
		auto = new auto();
		shiftUp = new ShiftToggle_autoCmd(true);
		shiftDown = new ShiftToggle_autoCmd(false);
		
		oi = new OI();
		oi.init();
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
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		timer.start();
		auto = new auto(); 
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	//	RobotMap.euler.update();
		if(oi.x1.get()){
			RobotMap.FLdrive.getSensorCollection().setQuadraturePosition(0, 10);
			RobotMap.FRdrive.getSensorCollection().setQuadraturePosition(0, 10);
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
    		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
