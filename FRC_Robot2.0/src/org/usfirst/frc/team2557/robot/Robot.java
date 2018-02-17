//2.82 counts per foot
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
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
import org.usfirst.frc.team2557.robot.commands.CombinedHumanErrorDriveCommand;
import org.usfirst.frc.team2557.robot.commands.DriveCmd;
import org.usfirst.frc.team2557.robot.commands.DriveToTarget_cmd;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand1;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand2;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand3;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand4;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand5;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand6;
import org.usfirst.frc.team2557.robot.commands.EncoderDriveCommand7;
import org.usfirst.frc.team2557.robot.commands.GearGrab_toggle;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandLeft;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandMid;
import org.usfirst.frc.team2557.robot.commands.GroupAutoCommandRight;
import org.usfirst.frc.team2557.robot.commands.GroupForward;
import org.usfirst.frc.team2557.robot.commands.GyroCommandLeft;
import org.usfirst.frc.team2557.robot.commands.GyroCommandRight;
import org.usfirst.frc.team2557.robot.commands.PsuedoShooter_cmd;
import org.usfirst.frc.team2557.robot.subsystems.Acceleration_sub;
import org.usfirst.frc.team2557.robot.subsystems.Agitator_sub;
import org.usfirst.frc.team2557.robot.subsystems.Chassis_sub;
import org.usfirst.frc.team2557.robot.subsystems.Climber_sub;
import org.usfirst.frc.team2557.robot.subsystems.DriveSub;
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

	public static GyroCommandLeft GCL;
	public static GyroCommandRight GCR;
	public static EncoderDriveCommand1 EDC1;
	public static EncoderDriveCommand2 EDC2;
	public static EncoderDriveCommand3 EDC3;
	public static EncoderDriveCommand4 EDC4;
	public static EncoderDriveCommand5 EDC5;
	public static EncoderDriveCommand6 EDC6;
	public static EncoderDriveCommand7 EDC7;
	public static DriveCmd driveCmd;
	public static CombinedHumanErrorDriveCommand CHEDC;
	public static DriveSub DriveSub1;

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
	public static Preferences prefs;
	public int _auto;

	Command autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		DriveSub1 = new DriveSub();
		GCL = new GyroCommandLeft();
		GCR = new GyroCommandRight();
		CHEDC = new CombinedHumanErrorDriveCommand();
		EDC1 = new EncoderDriveCommand1(1, 0);
		EDC2 = new EncoderDriveCommand2(1, 0);
		EDC3 = new EncoderDriveCommand3(1,0);
		EDC4 = new EncoderDriveCommand4(1, 0);
		EDC5 = new EncoderDriveCommand5(1, 0);
		EDC6 = new EncoderDriveCommand6(1,0);
		EDC7 = new EncoderDriveCommand7(1,0);
		driveCmd = new DriveCmd();
		

		RobotMap.init();
		CameraServer.getInstance().startAutomaticCapture();
		prefs = Preferences.getInstance();
		vision.initializer();
		shooterUpdate = new PsuedoShooter_cmd();
		visionUpdate = new Vision_cmd();
		shiftUp = new ShiftToggle_autoCmd(true);
		shiftDown = new ShiftToggle_autoCmd(false);
		leftX_gear = new centerX_gear();


		fakePID = new PsuedoShooter_cmd();
		driveToTarget = new DriveToTarget_cmd();
		oi = new OI();
		oi.init();

		m_chooser.addDefault("Mid Auto", new GroupAutoCommandMid());
		m_chooser.addObject("Left Auto", new GroupAutoCommandLeft());
		m_chooser.addObject("Right Auto", new GroupAutoCommandRight());
		m_chooser.addObject("For Auto", new GroupForward());
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
//		RobotMap.FLdrive.getSensorCollection().setQuadraturePosition(0, 10);
//		RobotMap.BRdrive.getSensorCollection().setQuadraturePosition(0, 10);
		
		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder: ", RobotMap.FLdrive.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Right Encoder: ", RobotMap.BRdrive.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("NavX Angle is: ",RobotMap.navX.getAngle());
		SmartDashboard.putNumber("DriveStraight Angle is: ",Robot.chassis.getDriveStraightAngle());
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
		RobotMap.robotDrive.arcadeDrive(-.8,0);

	}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
