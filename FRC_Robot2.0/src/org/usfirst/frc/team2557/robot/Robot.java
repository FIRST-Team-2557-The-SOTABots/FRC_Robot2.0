package org.usfirst.frc.team2557.robot;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.CombinedHumanErrorDriveCommand;
import org.usfirst.frc.team2557.robot.commands.CorrectStrafeCommand;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand1;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand2;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand3;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand4;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand5;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand6;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand7;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandLeft;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandMid;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandRight;
import org.usfirst.frc.team2557.robot.commands.GroupForward;
import org.usfirst.frc.team2557.robot.commands.GyroCommand;
import org.usfirst.frc.team2557.robot.commands.GyroCommandLeft;
import org.usfirst.frc.team2557.robot.commands.GyroCommandRight;
import org.usfirst.frc.team2557.robot.commands.HumanErrorMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.HumanErrorTractionCommand;
import org.usfirst.frc.team2557.robot.commands.IntakeCommand;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;
import org.usfirst.frc.team2557.robot.commands.LiftEncoderCommand;
import org.usfirst.frc.team2557.robot.commands.MecanumStrafeCommand;
import org.usfirst.frc.team2557.robot.commands.SolenoidAutoCommand;
import org.usfirst.frc.team2557.robot.commands.SolenoidCommand;
import org.usfirst.frc.team2557.robot.commands.TeleDriveCommand;
import org.usfirst.frc.team2557.robot.commands.TimedAutoDriveCommand;
import org.usfirst.frc.team2557.robot.commands.TimedAutoMecanumDriveCommand;
import org.usfirst.frc.team2557.robot.commands.WheelCheck;
import org.usfirst.frc.team2557.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static OI m_oi;
	public static Timer timer = new Timer();
	
	public static DriveSub DriveSub1;
	public static SolenoidSub SolSub;
	
	public static GyroCommand GC;
	public static GyroCommandLeft GCL;
	public static GyroCommandRight GCR;
	public static CorrectStrafeCommand CFC;
	public static CombinedHumanErrorDriveCommand CHEDC;
	public static EncoderDriveCommand1 EDC1;
	public static EncoderDriveCommand2 EDC2;
	public static EncoderDriveCommand3 EDC3;
	public static EncoderDriveCommand4 EDC4;
	public static EncoderDriveCommand5 EDC5;
	public static EncoderDriveCommand6 EDC6;
	public static EncoderDriveCommand7 EDC7;
	
	public static TimedAutoMecanumDriveCommand TAMDC;
	public static TimedAutoDriveCommand TADC;
	public static SolenoidCommand SC;
	public static SolenoidAutoCommand SAC;
	public static HumanErrorMecanumCommand HEMC;
	public static HumanErrorTractionCommand HETC;
	public static TeleDriveCommand TDC;
	public static MecanumStrafeCommand MSC;
	public static WheelCheck WC;
	

	public static LiftSub LS;
	public static LiftCommand LC;
	public static IntakeCommand IC;
	public static LiftEncoderCommand LEC;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 1000);
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 1000);
		
		RobotMap.DS1.set(Value.kReverse);
//		RobotMap.DS1.set(Value.kForward);
    	RobotMap.S1.set(true);
    	RobotMap.S2.set(false);
		
		DriveSub1 = new DriveSub();
		SolSub = new SolenoidSub();
		
		GC = new GyroCommand();
		GCL = new GyroCommandLeft();
		GCR = new GyroCommandRight();
		CFC = new CorrectStrafeCommand();
		CHEDC = new CombinedHumanErrorDriveCommand();
		EDC1 = new EncoderDriveCommand1(1, 0);
		EDC2 = new EncoderDriveCommand2(1, 0);
		EDC3 = new EncoderDriveCommand3(1, 0);
		EDC4 = new EncoderDriveCommand4(1, 0);
		EDC5 = new EncoderDriveCommand5(1, 0);
		EDC6 = new EncoderDriveCommand6(1, 0);
		EDC7 = new EncoderDriveCommand7(1, 0);
		
		TAMDC = new TimedAutoMecanumDriveCommand(1, 0, 0, 1);
		TADC = new TimedAutoDriveCommand(1, 0, 1);
		SC = new SolenoidCommand();
		SAC = new SolenoidAutoCommand();
		HEMC = new HumanErrorMecanumCommand();
		HETC = new HumanErrorTractionCommand();
		TDC = new TeleDriveCommand();
		MSC = new MecanumStrafeCommand();
		WC = new WheelCheck();
		
		
		LS = new LiftSub();
		
		LC = new LiftCommand();
		IC = new IntakeCommand(false);
		
		m_oi = new OI();
		m_oi.OIInit();
		
		m_chooser.addDefault("Mid Auto", new GroupAutoCommandMid());
		m_chooser.addObject("Left Auto", new GroupAutoCommandLeft());
		m_chooser.addObject("Right Auto", new GroupAutoCommandRight());
		m_chooser.addObject("For Auto", new GroupForward());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
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
		m_autonomousCommand = m_chooser.getSelected();
		timer.start();
//		RobotMap.Gyro1.reset();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
//		CFC.start();
//		MSC.start();
		SmartDashboard.putNumber("Time passed", timer.get());
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		GC.start();
		CHEDC.start();
//		LC.start();
//		HETC.start();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}
	
	/**
	 * This function is called periodically during operator control.
	 */	
	@Override
	public void teleopPeriodic() {
		SC.start();
		CHEDC.start();
//		HETC.start();
//		LC.start();
		IC.start();
//		MSC.start();
//		CFC.start();
//    	SmartDashboard.putNumber("EncoderCountLeft", - RobotMap.Left2.getSensorCollection().getQuadraturePosition()/1000);
//    	SmartDashboard.putNumber("EncoderCountRight", RobotMap.Right2.getSensorCollection().getQuadraturePosition()/1000);
//		SmartDashboard.putNumber("Right2Velocity", RobotMap.Right2.getSensorCollection().getQuadratureVelocity());
//		SmartDashboard.putNumber("Left2Velocity", RobotMap.Left2.getSensorCollection().getQuadratureVelocity());
//		TDC.start();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
