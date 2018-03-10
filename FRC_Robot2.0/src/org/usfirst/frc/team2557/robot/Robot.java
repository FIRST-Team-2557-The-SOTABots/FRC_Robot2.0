package org.usfirst.frc.team2557.robot;

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
import org.usfirst.frc.team2557.robot.commands.LiftCommandWithAxis;
import org.usfirst.frc.team2557.robot.commands.LiftEncoderCommand;
//import org.usfirst.frc.team2557.robot.commands.LiloAutoCommandGroup;
import org.usfirst.frc.team2557.robot.commands.MecanumStrafeCommand;
import org.usfirst.frc.team2557.robot.commands.RiseCommandLeft;
import org.usfirst.frc.team2557.robot.commands.RiseCommandRight;
import org.usfirst.frc.team2557.robot.commands.SolenoidAutoCommand;
import org.usfirst.frc.team2557.robot.commands.SolenoidCommand;
import org.usfirst.frc.team2557.robot.commands.TeleDriveCommand;
import org.usfirst.frc.team2557.robot.commands.TimedAutoDriveCommand;
import org.usfirst.frc.team2557.robot.commands.TimedAutoMecanumDriveCommand;
import org.usfirst.frc.team2557.robot.commands.WheelCheck;
import org.usfirst.frc.team2557.robot.commands.WingCommandLeft;
import org.usfirst.frc.team2557.robot.commands.WingCommandRight;
import org.usfirst.frc.team2557.robot.subsystems.*;

public class Robot extends TimedRobot {
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
//	public static TeleDriveCommand TDC;
	public static MecanumStrafeCommand MSC;
	public static WheelCheck WC;
	public static LiftSub LS;
	public static LiftCommand LC;
	public static LiftCommandWithAxis LCWA;
	public static IntakeCommand IC;
	public static LiftEncoderCommand LEC;
	public static WingCommandRight WCR;
	public static WingCommandLeft WCL;
	public static RiseCommandRight RCR;
	public static RiseCommandLeft RCL;
	
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		
//		double liftSpeed;
//		liftSpeed = OI.Joystick2.getRawAxis(1);
//		SmartDashboard.putNumber("Lift In Robot", liftSpeed);
		
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 1000);
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 1000);
		
		RobotMap.DS1.set(Value.kReverse);
		
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
//		TDC = new TeleDriveCommand();
		MSC = new MecanumStrafeCommand();
		WC = new WheelCheck();
		LS = new LiftSub();
		LC = new LiftCommand();
		LCWA = new LiftCommandWithAxis();
		IC = new IntakeCommand();
		WCR = new WingCommandRight();
		WCL = new WingCommandLeft();
		RCR = new RiseCommandRight();
		RCL = new RiseCommandLeft();
		
		m_oi = new OI();
		m_oi.OIInit();
		
		m_chooser.addDefault("Mid Auto", new GroupAutoCommandMid());
		m_chooser.addObject("Left Auto", new GroupAutoCommandLeft());
		m_chooser.addObject("Right Auto", new GroupAutoCommandRight());
		m_chooser.addObject("Forward Auto", new GroupForward());
//		m_chooser.addObject("Lilo Auto Command", new LiloAutoCommandGroup());
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
		m_autonomousCommand = m_chooser.getSelected();
		timer.start();
		
		m_autonomousCommand = new GroupAutoCommandLeft();
//		RobotMap.Gyro1.reset();
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
		SmartDashboard.putNumber("GyroThisOne", RobotMap.Gyro1.getAngle());
		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
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
		RCR.start();
		RCL.start();
		WCR.start();
		WCL.start();
	}
	
	/**
	 * This function is called periodically during operator control.
	 */	
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("liftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		SC.start();
		CHEDC.start();
//		LC.start();
//		HETC.start();
		IC.start();
	//	LC.start();
		LCWA.start();
		
		
//		MSC.start();
//		CFC.start();
//		TDC.start();
		Scheduler.getInstance().run();
		
		
//		SmartDashboard.putNumber("Left 1 current", RobotMap.Left1.getOutputCurrent());
//		SmartDashboard.putNumber("Right 1 current", RobotMap.Right1.getOutputCurrent());
//		SmartDashboard.putNumber("Left 2 current", RobotMap.Left2.getOutputCurrent());
//		SmartDashboard.putNumber("Right 2 current", RobotMap.Right2.getOutputCurrent());
//		SmartDashboard.putNumber("Lift current", RobotMap.LiftMotor.getOutputCurrent());
//		SmartDashboard.putNumber("Intake right current", RobotMap.IntakeR.getOutputCurrent());
//		SmartDashboard.putNumber("Intake left current", RobotMap.IntakeL.getOutputCurrent());
//		SmartDashboard.putNumber("Pdp 1 current", RobotMap.pdp.getCurrent(1));
//		SmartDashboard.putNumber("Pdp 2 current", RobotMap.pdp.getCurrent(2));
//		SmartDashboard.putNumber("Pdp 3 current", RobotMap.pdp.getCurrent(3));
//		SmartDashboard.putNumber("Pdp 4 current", RobotMap.pdp.getCurrent(4));
//		SmartDashboard.putNumber("Pdp 5 current", RobotMap.pdp.getCurrent(5));
//		SmartDashboard.putNumber("Pdp 6 current", RobotMap.pdp.getCurrent(6));
//		SmartDashboard.putNumber("Pdp 7 current", RobotMap.pdp.getCurrent(7));
//		SmartDashboard.putNumber("Pdp 8 current", RobotMap.pdp.getCurrent(8));
//		SmartDashboard.putNumber("Pdp 9 current", RobotMap.pdp.getCurrent(9));
//		SmartDashboard.putNumber("Pdp 10 current", RobotMap.pdp.getCurrent(10));
//		SmartDashboard.putNumber("Pdp 11 current", RobotMap.pdp.getCurrent(11));
//		SmartDashboard.putNumber("Pdp 12 current", RobotMap.pdp.getCurrent(12));
//		SmartDashboard.putNumber("Pdp 13 current", RobotMap.pdp.getCurrent(13));
//		SmartDashboard.putNumber("Pdp 14 current", RobotMap.pdp.getCurrent(14));
//		SmartDashboard.putNumber("Pdp 15 current", RobotMap.pdp.getCurrent(15));
//		SmartDashboard.putNumber("Pdp total current", RobotMap.pdp.getTotalCurrent());
//		SmartDashboard.putNumber("Pdp temperature", RobotMap.pdp.getTemperature());
//		SmartDashboard.putNumber("Left 1 voltage", RobotMap.Left1.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Right 1 voltage", RobotMap.Right1.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Left 2 voltage", RobotMap.Left2.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Right 2 voltage", RobotMap.Right2.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Lift voltage", RobotMap.LiftMotor.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Intake right voltage", RobotMap.IntakeR.getMotorOutputVoltage());
//		SmartDashboard.putNumber("Intake left voltage", RobotMap.IntakeL.getMotorOutputVoltage());
		SmartDashboard.putNumber("GyroThisOne", RobotMap.Gyro1.getAngle());
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
