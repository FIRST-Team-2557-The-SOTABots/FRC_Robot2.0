package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandLeft;
import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandMid;
import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandRight;
import org.usfirst.frc.team2557.robot.commands.autonomous.GroupForward;
import org.usfirst.frc.team2557.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static OI m_oi;
	public static Timer timer = new Timer();

	public static DriveSubsystem DriveSub1;
	public static SolenoidSubsystem SolSub;
	public static WingSubsystem WS;
	public static LiftSubsystem LS;
	public static IntakeSubsystem IS;
	
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

		DriveSub1 = new DriveSubsystem();
		SolSub = new SolenoidSubsystem();
		WS = new WingSubsystem();
		LS = new LiftSubsystem();
		IS = new IntakeSubsystem();
		
		m_oi = new OI();
		m_oi.OIInit();

		m_chooser.addDefault("Do Nothing", null);
		m_chooser.addObject("Mid Auto", new GroupAutoCommandMid());
		m_chooser.addObject("Left Auto", new GroupAutoCommandLeft());
		m_chooser.addObject("Right Auto", new GroupAutoCommandRight());
		m_chooser.addObject("Forward Auto", new GroupForward());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// Reset the lift encoder to zero
		// LIFT ***MUST*** BE AT THE BOTTOM AT THE START OF AUTO!!!!!!
		RobotMap.LiftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		
		m_autonomousCommand = m_chooser.getSelected();
		m_autonomousCommand = new GroupAutoCommandLeft();
		m_autonomousCommand.start();
		timer.start();
		
		// Start the selected Auto program
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Time passed", timer.get());
		SmartDashboard.putNumber("GyroThisOne", RobotMap.Gyro1.getAngle());
		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Stop the auto command, if there was one
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */	
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("GyroThisOne", RobotMap.Gyro1.getAngle());
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
