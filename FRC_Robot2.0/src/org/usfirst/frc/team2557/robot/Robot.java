package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandLeft;
import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandMid;
import org.usfirst.frc.team2557.robot.commands.autonomous.GroupAutoCommandRight;
import org.usfirst.frc.team2557.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static OI oi;

	public static DriveSubsystem DriveSubsystem;
	public static SolenoidSubsystem SolenoidSubsystem;
	public static WingSubsystem WingSubsystem;
	public static LiftSubsystem LiftSubsystem;
	public static IntakeSubsystem IntakeSubsystem;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	private void updateSmartDashboard() {
		SmartDashboard.putNumber("Gyro Angle", RobotMap.Gyro1.getAngle());
		
		SmartDashboard.putBoolean("S1", RobotMap.S1.get());
		SmartDashboard.putBoolean("S2", RobotMap.S2.get());
		
		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		
		SmartDashboard.putNumber("EncoderCountLeft", RobotMap.Left2.getSensorCollection().getQuadraturePosition()/10);
    	SmartDashboard.putNumber("EncoderCountRight", RobotMap.Right2.getSensorCollection().getQuadraturePosition()/10);
    	
		SmartDashboard.putBoolean("LiftHallEffect", RobotMap.liftHallEffect.get());
	}

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

		DriveSubsystem = new DriveSubsystem();
		SolenoidSubsystem = new SolenoidSubsystem();
		WingSubsystem = new WingSubsystem();
		LiftSubsystem = new LiftSubsystem();
		IntakeSubsystem = new IntakeSubsystem();
		
		oi = new OI();
		oi.OIInit();

		m_chooser.addDefault("Do Nothing", null);
		m_chooser.addObject("Mid Auto", new GroupAutoCommandMid());
		m_chooser.addObject("Left Auto", new GroupAutoCommandLeft());
		m_chooser.addObject("Right Auto", new GroupAutoCommandRight());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	@Override
	public void autonomousInit() {
		// Reset the lift encoder to zero
		// LIFT ***MUST*** BE AT THE BOTTOM AT THE START OF AUTO!!!!!!
		RobotMap.LiftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		
		m_autonomousCommand = m_chooser.getSelected();
		m_autonomousCommand.start();
		
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
		Scheduler.getInstance().run();
		updateSmartDashboard();
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
		updateSmartDashboard();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		updateSmartDashboard();
	}
}
