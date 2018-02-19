package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class RobotMap {
	public static WPI_TalonSRX left1;
	public static WPI_TalonSRX left2;
	public static WPI_TalonSRX right1;
	public static WPI_TalonSRX right2;
	public static WPI_TalonSRX intakeR;
	public static WPI_TalonSRX intakeL;
	public static SpeedControllerGroup left;
	public static SpeedControllerGroup right;
	public static AHRS gyro;
	public static Compressor compressor;
	public static DoubleSolenoid doubleSolenoid;
	public static Solenoid solenoid;
	public static DifferentialDrive diffDrive;
	public static MecanumDrive mecDrive;
	public static AnalogInput analogInput;
	public static WPI_TalonSRX lift;
	public static WPI_TalonSRX winch;
	
	public static double[] yspeed;
	public static double[] xspeed;
	public static double[] rotation;
	public static double[] rightEncoder;
	public static double[] leftEncoder;
	public static double[] gyroReadings;
	public static double[] time;
	
	public static void init(){
		left1 = new WPI_TalonSRX(1);
		left2 = new WPI_TalonSRX(7);
		right1 = new WPI_TalonSRX(0);
		right2 = new WPI_TalonSRX(2);
		intakeR = new WPI_TalonSRX(4);
		intakeL = new WPI_TalonSRX(6);
		lift = new WPI_TalonSRX(9);
		winch = new WPI_TalonSRX(5);
		doubleSolenoid = new DoubleSolenoid(0,0,1);
		solenoid = new Solenoid(1, 0);
		gyro = new AHRS(SPI.Port.kMXP);
		compressor = new Compressor(0);
		left = new SpeedControllerGroup(left1, left2);
		right = new SpeedControllerGroup(right1, right2);
		diffDrive = new DifferentialDrive(left, right);
		mecDrive = new MecanumDrive(left1, left2, right1, right2);
		diffDrive.setSafetyEnabled(false);
		mecDrive.setSafetyEnabled(false);
		analogInput = new AnalogInput(0);
	}
}
