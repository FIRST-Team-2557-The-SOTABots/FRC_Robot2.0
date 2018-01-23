package org.usfirst.frc.team2557.robot;
import org.usfirst.frc.team2557.robot.math.EulerDistanceEstimator;
import org.usfirst.frc.team2557.robot.math.EulerDistanceEstimator.ForwardAxis;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static WPI_TalonSRX FRdrive;
	public static WPI_TalonSRX FLdrive;
	public static WPI_TalonSRX BRdrive;
	public static WPI_TalonSRX BLdrive;
	public static SpeedControllerGroup Left;
	public static SpeedControllerGroup Right;
	public static DifferentialDrive robotDrive;
	public static MecanumDrive mecDrive;
	public static WPI_TalonSRX Lshooter;
	public static WPI_TalonSRX Rshooter;
	public static WPI_TalonSRX intake;
	public static WPI_TalonSRX climber;
	public static WPI_TalonSRX gearMotor;
	public static WPI_TalonSRX copterAgitator;
	public static WPI_TalonSRX agitator;
	
	
	public static PowerDistributionPanel pdp;
	public static DoubleSolenoid shifter;
	public static DoubleSolenoid gearGrab;
	
	public static BuiltInAccelerometer accel;
	public static AHRS navX;
	public static boolean _gemini; //false = Fuel Forward and true = Gear Forward
	public static boolean _stage; //used in gear command or subsystem(I forgot) somewhere :)
	public static boolean shift; //boolean for the super shifters on the drive train
	public static boolean drive; //boolean to switch the drive stick
	public static boolean _switch; //boolean to activate/deactivate the momentary switch for the gear grabber
	public static double CAngle; //??? Auto Turn? :)
	public static double visionShooterSpeed;
	public static boolean shootReq;
	public static DigitalInput gearSwitch;
	public static Encoder gearEnc;
	public static boolean _leftX_gear;
	
	public static Servo leftAgitator;
	public static Servo rightAgitator;
	public static Servo cameraServo;
	public static EulerDistanceEstimator euler;
	
	public static void init(){
		FRdrive = new WPI_TalonSRX(3);
		FLdrive = new WPI_TalonSRX(1);
		BRdrive = new WPI_TalonSRX(4);
		BLdrive = new WPI_TalonSRX(2);
		Left = new SpeedControllerGroup(FLdrive, BLdrive);
		Right = new SpeedControllerGroup(FRdrive, BRdrive);
		robotDrive = new DifferentialDrive(Left, Right);
		robotDrive.setSafetyEnabled(false);
		mecDrive = new MecanumDrive(FLdrive, BLdrive, FRdrive, BRdrive);
		mecDrive.setSafetyEnabled(false);
		Lshooter = new WPI_TalonSRX(5);
		Rshooter = new WPI_TalonSRX(6);
		intake = new WPI_TalonSRX(7);
		climber = new WPI_TalonSRX(8);
		gearMotor = new WPI_TalonSRX(9);
		copterAgitator = new WPI_TalonSRX(10);
		agitator = new WPI_TalonSRX(0);
		gearSwitch = new DigitalInput(2);
		gearEnc = new Encoder(0,1);
		
		shifter = new DoubleSolenoid(1, 0,1);
		gearGrab = new DoubleSolenoid(1, 2,3);
		leftAgitator = new Servo(1);
		rightAgitator = new Servo(2);
		cameraServo = new Servo(3);
		
		pdp = new PowerDistributionPanel(0);
		navX = new AHRS(SPI.Port.kMXP);
		accel = new BuiltInAccelerometer();
		euler = new EulerDistanceEstimator(ForwardAxis.NegX);
		
		
		_leftX_gear = true;
		shootReq = false;
		_stage = true;
		_gemini = true; //boolean for manipulator, true = gear and false = fuel
		shift = true;
		drive = true; //boolean for driver, true = gear and false = fuel
		_switch = true;
		CAngle = 0;
		visionShooterSpeed = 0;
		shootReq = false;
		
		
		
		
	}
}
