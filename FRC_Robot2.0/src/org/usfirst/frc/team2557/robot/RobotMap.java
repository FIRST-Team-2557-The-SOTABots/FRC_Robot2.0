package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	public static boolean Confirm;
	public static boolean Position;
	public static double GyroAngle;
	
	public static WPI_TalonSRX Left1;
	public static WPI_TalonSRX Left2;
	public static WPI_TalonSRX Right1;
	public static WPI_TalonSRX Right2;
	public static WPI_TalonSRX IntakeR;
	public static WPI_TalonSRX IntakeL;
	public static SpeedControllerGroup Left;
	public static SpeedControllerGroup Right;
	public static AHRS Gyro1;
	public static Compressor compressor;
	public static DoubleSolenoid DS1;
	public static Solenoid S1;
	public static Solenoid S2;
	public static DifferentialDrive DiffDrive;
	public static MecanumDrive MecDrive;
	public static AnalogInput Ultrasonic;
	public static WPI_TalonSRX LiftMotor;
	public static WPI_TalonSRX Winch;
	public static Servo rightWing;
	public static Servo leftWing;
	public static Solenoid a;
	public static Solenoid b;
	public static Solenoid c;
	public static Solenoid d;
	public static PowerDistributionPanel pdp;

	// left2 = 7, liftMotor = 9, right1 = 0, left1 = 1, right2 = 6, leftIntake = 1, rightIntake = 4
	
	public static void init() {

		
//		Left1 = new WPI_TalonSRX(3); //
//		Left2 = new WPI_TalonSRX(4); //
//		Right1 = new WPI_TalonSRX(9);
//		Right2 = new WPI_TalonSRX(6);  
//		IntakeR = new WPI_TalonSRX(8);
//		IntakeL = new WPI_TalonSRX(1); //
//		LiftMotor = new WPI_TalonSRX(2);
		
		
		a = new Solenoid(7);
		b = new Solenoid(6);
		c = new Solenoid(5);
		d = new Solenoid(4);
		
		leftWing = new Servo(0);
		rightWing = new Servo(1);
		
		Left1 = new WPI_TalonSRX(1); //
		Left2 = new WPI_TalonSRX(7); //

		Left1 = new WPI_TalonSRX(1);
		Left2 = new WPI_TalonSRX(7);

		Right1 = new WPI_TalonSRX(3);
		Right2 = new WPI_TalonSRX(2);
		IntakeR = new WPI_TalonSRX(4);
		IntakeL = new WPI_TalonSRX(6); //
		LiftMotor = new WPI_TalonSRX(5);
		
		Left = new SpeedControllerGroup(Left1, Left2);
		Right = new SpeedControllerGroup(Right1, Right2);
		DS1 = new DoubleSolenoid(0, 0, 1);
		S1 = new Solenoid(0, 2);
		S2 = new Solenoid(0, 3);
		Gyro1 = new AHRS(SPI.Port.kMXP);
		compressor = new Compressor(0);
		DiffDrive = new DifferentialDrive(Left, Right);
		MecDrive = new MecanumDrive(Left1, Left2, Right1, Right2);
		DiffDrive.setSafetyEnabled(false);
		MecDrive.setSafetyEnabled(false);
		Ultrasonic = new AnalogInput(0);
		
		pdp = new PowerDistributionPanel(10);
	}
}
