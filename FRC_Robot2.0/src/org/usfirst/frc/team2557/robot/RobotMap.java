/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
//    private static final int[] LEFT_ULTRASONIC_PING_CHANNEL_VALS = {4, 4, 4};
//    public static final int LEFT_ULTRASONIC_PING_CHANNEL =
//                    getConstant("LEFT_ULTRASONIC_PING_CHANNEL");
//
//    private static final int[] LEFT_ULTRASONIC_ECHO_CHANNEL_VALS = {5, 5, 5};
//    public static final int LEFT_ULTRASONIC_ECHO_CHANNEL =
//                    getConstant("LEFT_ULTRASONIC_ECHO_CHANNEL");
//
//    private static final int[] RIGHT_ULTRASONIC_PING_CHANNEL_VALS = {6, 6, 6};
//    public static final int RIGHT_ULTRASONIC_PING_CHANNEL =
//                    getConstant("RIGHT_ULTRASONIC_PING_CHANNEL");
//
//    private static final int[] RIGHT_ULTRASONIC_ECHO_CHANNEL_VALS = {7, 7, 7};
//    public static final int RIGHT_ULTRASONIC_ECHO_CHANNEL =
//                    getConstant("RIGHT_ULTRASONIC_ECHO_CHANNEL");
	
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
	
	public static DifferentialDrive DiffDrive;
	public static MecanumDrive MecDrive;
	
	public static AnalogInput Ultrasonic;
	
//	public static boolean LiftVar;

//	public static AnalogInput leftAngleIR;
//	public static AnalogInput rightAngleIR;
//	public static AnalogInput leftCenterIR;
//	public static AnalogInput rightCenterIR;
	
	public static WPI_TalonSRX LiftMotor;
	public static WPI_TalonSRX Winch;
	
	public static void init() {
		
		Left1 = new WPI_TalonSRX(1);
		Left2 = new WPI_TalonSRX(7);
		Right1 = new WPI_TalonSRX(0);
		Right2 = new WPI_TalonSRX(2);
		
		IntakeR = new WPI_TalonSRX(4);
		IntakeL = new WPI_TalonSRX(6);
		
		Left = new SpeedControllerGroup(Left1, Left2);
		Right = new SpeedControllerGroup(Right1, Right2);
		
		DS1 = new DoubleSolenoid(0, 0, 1);
		Gyro1 = new AHRS(SPI.Port.kMXP);
		
		compressor = new Compressor(0);
		
		DiffDrive = new DifferentialDrive(Left, Right);
		MecDrive = new MecanumDrive(Left1, Left2, Right1, Right2);
		DiffDrive.setSafetyEnabled(false);
		MecDrive.setSafetyEnabled(false);
		
		Ultrasonic = new AnalogInput(0);
		
//		leftAngleIR = new AnalogInput(RobotMap.Analog.LeftAngleIR);
//		rightAngleIR = new AnalogInput(RobotMap.Analog.RightAngleIR);
//
//		leftCenterIR = new AnalogInput(RobotMap.Analog.LeftCenterIR);
//		rightCenterIR = new AnalogInput(RobotMap.Analog.RightCenterIR);
		
		LiftMotor = new WPI_TalonSRX(9);
		Winch = new WPI_TalonSRX(5);
	}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

//	private static int getConstant(String string) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
