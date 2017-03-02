package org.usfirst.frc.team2557.robot;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

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
	public static CANTalon FRdrive;
	public static CANTalon FLdrive;
	public static CANTalon BRdrive;
	public static CANTalon BLdrive;
	public static RobotDrive robotDrive;
	
	public static CANTalon Lshooter;
	public static CANTalon Rshooter;
	public static CANTalon intake;
	public static CANTalon climber;
	public static CANTalon gearMotor;
	public static CANTalon copterAgitator;
	public static SpeedController agitator;
	
	public static DoubleSolenoid shifter;
	public static DoubleSolenoid gearGrab;
	
	public static AHRS navX;
	public static boolean gemini; //false = Fuel Forward and true = Gear Forward
	public static boolean FALL; //used in gear command or subsystem(I forgot) somewhere :)
	public static boolean shift; //boolean for the super shifters on the drive train
	public static boolean wall; //boolean for the backwall for the intake
	public static boolean drive; //boolean to switch the drive stick
	public static boolean pass; //boolean to allow the momentary switch to trigger
	public static double CAngle; //??? Auto Turn? :)
	public static DigitalInput gearSwitch;
	public static Encoder gearEnc;
	
	public static Servo leftAgitator;
	public static Servo rightAgitator;
	
	public static void init(){
		FRdrive = new CANTalon(1);
		FLdrive = new CANTalon(2);
		BRdrive = new CANTalon(3);
		BLdrive = new CANTalon(4);
		robotDrive = new RobotDrive(FLdrive, BLdrive, FRdrive, BRdrive);
		robotDrive.setSafetyEnabled(false);
		Lshooter = new CANTalon(5);
		Rshooter = new CANTalon(6);
		intake = new CANTalon(7);
		climber = new CANTalon(8);
		gearMotor = new CANTalon(9);
		copterAgitator = new CANTalon(10);
		agitator = new Talon(0);
		gearSwitch = new DigitalInput(2);
		gearEnc = new Encoder(0,1);
		
		shifter = new DoubleSolenoid(0,1);
		gearGrab = new DoubleSolenoid(2,3);
		leftAgitator = new Servo(1);
		rightAgitator = new Servo(2);
		
		
		navX = new AHRS(SPI.Port.kMXP);
		
		FALL = false;
		gemini = true;
		shift = true;
		wall = true;
		drive = true;
		pass = true;
		CAngle = 0;
		
		
	}
}
