package org.usfirst.frc.team2557.robot;

import org.usfirst.frc.team2557.robot.commands.autonomous.Forward;
import org.usfirst.frc.team2557.robot.commands.autonomous.LeftEnd;
import org.usfirst.frc.team2557.robot.commands.autonomous.LeftScalePriority;
import org.usfirst.frc.team2557.robot.commands.autonomous.LeftScaleOnly;
import org.usfirst.frc.team2557.robot.commands.autonomous.LeftSwitchOnly;
import org.usfirst.frc.team2557.robot.commands.autonomous.LeftSwitchPriority;
import org.usfirst.frc.team2557.robot.commands.autonomous.MidSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.RightEnd;
import org.usfirst.frc.team2557.robot.commands.autonomous.RightScalePriority;
import org.usfirst.frc.team2557.robot.commands.autonomous.RightScaleOnly;
import org.usfirst.frc.team2557.robot.commands.autonomous.RightSwitchOnly;
import org.usfirst.frc.team2557.robot.commands.autonomous.RightSwitchPriority;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleAndCube;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleCrossoverTest;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileTurnCommand;
import org.usfirst.frc.team2557.robot.commands.drive.PIDTurn;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandLeft;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandRight;
import org.usfirst.frc.team2557.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.StrafeButtonsSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.UselessForwardSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.SolenoidSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static OI oi;

	public static DriveSubsystem DriveSubsystem;
	public static SolenoidSubsystem SolenoidSubsystem;
	public static LiftSubsystem LiftSubsystem;
	public static IntakeSubsystem IntakeSubsystem;
	public static StrafeButtonsSubsystem StrafeButtonsSubsystem;
	public static UselessForwardSubsystem UselessForwardSubsystem;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser;
	
	private void updateSmartDashboard() {
		SmartDashboard.putNumber("Gyro Angle", RobotMap.Gyro1.getAngle());
		SmartDashboard.putBoolean("S1", RobotMap.S1.get());
		SmartDashboard.putBoolean("S2", RobotMap.S2.get());
		SmartDashboard.putNumber("Lift Encoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Encoder Count Left", RobotMap.Left2.getSensorCollection().getQuadraturePosition());
    	SmartDashboard.putNumber("Encoder Count Right", RobotMap.Right2.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putBoolean("Lift Hall Effect", RobotMap.liftHallEffect.get());
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		RobotMap.a.set(true);
		RobotMap.b.set(false);
		RobotMap.c.set(false);
		RobotMap.d.set(true);
		
		RobotMap.rightWing.setAngle(180.0);
		RobotMap.leftWing.setAngle(0.0);

		RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
		
		RobotMap.DS1.set(Value.kReverse);

		DriveSubsystem = new DriveSubsystem();
		SolenoidSubsystem = new SolenoidSubsystem();
		LiftSubsystem = new LiftSubsystem();
		IntakeSubsystem = new IntakeSubsystem();
		StrafeButtonsSubsystem = new StrafeButtonsSubsystem();
		UselessForwardSubsystem = new UselessForwardSubsystem();
		
		oi = new OI();
		oi.OIInit();

		m_chooser = new SendableChooser<>();
		m_chooser.addDefault("Forward Only", new Forward());
		m_chooser.addObject("Right scale and cube", new RightScaleAndCube());
		m_chooser.addObject("Forward test using Turning Profile", new MotionProfileTurnCommand(RobotMap.drive1));
		m_chooser.addObject("Turns Right test using Turning Profile", new RightScaleCrossoverTest());
		m_chooser.addObject("Turns Left test using Turning Profile", new MotionProfileTurnCommand(RobotMap.trajectory2));
		m_chooser.addObject("PID Turn test", new PIDTurn(90.0));
		m_chooser.addObject("Mid Switch", new MidSwitch());
		m_chooser.addObject("Left Side Switch & Scale, Prioritise Switch, with crossover", new LeftSwitchPriority());
		m_chooser.addObject("Right Side Switch & Scale, Prioritise Switch with crossover", new RightSwitchPriority());
		m_chooser.addObject("Left Side Switch & Scale, Prioritise Scale with crossover", new LeftScalePriority());
		m_chooser.addObject("Right Side Switch & Scale, Prioritise Scale with crossover", new RightScalePriority());
		m_chooser.addObject("Left Side, Switch only with crossover", new LeftSwitchOnly());
		m_chooser.addObject("Right Side, Switch only with crossover", new RightSwitchOnly());
		m_chooser.addObject("Left Side, Scale only with crossover", new LeftScaleOnly());
		m_chooser.addObject("Right Side, Scale only with crossover", new RightScaleOnly());
		m_chooser.addObject("Right to Left Crossover and stop", new RightEnd());
		m_chooser.addObject("Left to Right Crossover and stop", new LeftEnd());
		m_chooser.addObject("Do Nothing", null);
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
		RobotMap.Right2.enableCurrentLimit(true);
		RobotMap.Right2.configPeakCurrentDuration(0, 0);
		RobotMap.Right2.configPeakCurrentLimit(30, 0);
		RobotMap.Right2.configContinuousCurrentLimit(30, 0);
		RobotMap.Left2.enableCurrentLimit(true);
		RobotMap.Left2.configPeakCurrentDuration(0, 0);
		RobotMap.Left2.configPeakCurrentLimit(30, 0);
		RobotMap.Left2.configContinuousCurrentLimit(30, 0);
		RobotMap.Left1.enableCurrentLimit(true);
		RobotMap.Left1.configPeakCurrentDuration(0, 0);
		RobotMap.Left1.configPeakCurrentLimit(30, 0);
		RobotMap.Left1.configContinuousCurrentLimit(30, 0);
		RobotMap.Right1.enableCurrentLimit(true);
		RobotMap.Right1.configPeakCurrentDuration(0, 0);
		RobotMap.Right1.configPeakCurrentLimit(30, 0);
		RobotMap.Right1.configContinuousCurrentLimit(30, 0);
		RobotMap.LiftMotor.enableCurrentLimit(true);
		RobotMap.LiftMotor.configPeakCurrentDuration(0, 0);
		RobotMap.LiftMotor.configPeakCurrentLimit(30, 0);
		RobotMap.LiftMotor.configContinuousCurrentLimit(30, 0);
		RobotMap.LiftMotor2.enableCurrentLimit(true);
		RobotMap.LiftMotor2.configPeakCurrentDuration(0, 0);
		RobotMap.LiftMotor2.configPeakCurrentLimit(30, 0);
		RobotMap.LiftMotor2.configContinuousCurrentLimit(30, 0);
		
//		RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
		RobotMap.rightWing.setAngle(180.0);
		RobotMap.leftWing.setAngle(0.0);
		// Reset the lift encoder to zero
		// LIFT ***MUST*** BE AT THE BOTTOM AT THE START OF AUTO!!!!!!
		RobotMap.LiftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		
		m_autonomousCommand = m_chooser.getSelected();
		
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
		WingCommandRight r = new WingCommandRight();
		WingCommandLeft l = new WingCommandLeft();
		r.start();
		l.start();
		
		RobotMap.Right2.enableCurrentLimit(true);
		RobotMap.Right2.configPeakCurrentDuration(0, 0);
		RobotMap.Right2.configPeakCurrentLimit(30, 0);
		RobotMap.Right2.configContinuousCurrentLimit(30, 0);
		RobotMap.Left2.enableCurrentLimit(true);
		RobotMap.Left2.configPeakCurrentDuration(0, 0);
		RobotMap.Left2.configPeakCurrentLimit(30, 0);
		RobotMap.Left2.configContinuousCurrentLimit(30, 0);
		RobotMap.Left1.enableCurrentLimit(true);
		RobotMap.Left1.configPeakCurrentDuration(0, 0);
		RobotMap.Left1.configPeakCurrentLimit(30, 0);
		RobotMap.Left1.configContinuousCurrentLimit(30, 0);
		RobotMap.Right1.enableCurrentLimit(true);
		RobotMap.Right1.configPeakCurrentDuration(0, 0);
		RobotMap.Right1.configPeakCurrentLimit(30, 0);
		RobotMap.Right1.configContinuousCurrentLimit(30, 0);
		RobotMap.LiftMotor.enableCurrentLimit(true);
		RobotMap.LiftMotor.configPeakCurrentDuration(0, 0);
		RobotMap.LiftMotor.configPeakCurrentLimit(30, 0);
		RobotMap.LiftMotor.configContinuousCurrentLimit(30, 0);
		RobotMap.LiftMotor2.enableCurrentLimit(true);
		RobotMap.LiftMotor2.configPeakCurrentDuration(0, 0);
		RobotMap.LiftMotor2.configPeakCurrentLimit(30, 0);
		RobotMap.LiftMotor2.configContinuousCurrentLimit(30, 0);
		
		RobotMap.IntakeL.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.IntakeR.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
		
//    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
		RobotMap.rightWing.setAngle(180.0);
		RobotMap.leftWing.setAngle(0.0);
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
//		SmartDashboard.putNumber("accelerometer rawaccelX", RobotMap.Gyro1.getRawAccelX());
//		SmartDashboard.putNumber("accelerometer rawaccelY", RobotMap.Gyro1.getRawAccelY());
//		SmartDashboard.putNumber("accelerometer rawaccelZ", RobotMap.Gyro1.getRawAccelZ());
//		SmartDashboard.putNumber("accelerometer velocityX", RobotMap.Gyro1.getVelocityX());
//		SmartDashboard.putNumber("accelerometer velocityY", RobotMap.Gyro1.getVelocityY());
//		SmartDashboard.putNumber("accelerometer velocityZ", RobotMap.Gyro1.getVelocityZ());
//		SmartDashboard.putNumber("accelerometer getWorldLinearAccelX", RobotMap.Gyro1.getWorldLinearAccelX());
//		SmartDashboard.putNumber("accelerometer getWorldLinearAccelY", RobotMap.Gyro1.getWorldLinearAccelY());
//		SmartDashboard.putNumber("accelerometer getWorldLinearAccelZ", RobotMap.Gyro1.getWorldLinearAccelZ());
//		SmartDashboard.putNumber("accelerometer getRate", RobotMap.Gyro1.getRate());
//		SmartDashboard.putNumber("talons velocity right", RobotMap.Right2.getSelectedSensorVelocity(0));
//		SmartDashboard.putNumber("talons velocity left", RobotMap.Left2.getSelectedSensorVelocity(0));
//		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
//		SmartDashboard.putNumber("GyroThisOne", RobotMap.Gyro1.getAngle());
		
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
