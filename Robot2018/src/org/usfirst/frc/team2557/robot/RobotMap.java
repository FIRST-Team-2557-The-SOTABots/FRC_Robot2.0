/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX FRdrive;
	public static WPI_TalonSRX FLdrive;
	public static WPI_TalonSRX BRdrive;
	public static WPI_TalonSRX BLdrive;
	public static SpeedControllerGroup Left;
	public static SpeedControllerGroup Right;
	public static DifferentialDrive robotDrive;
	public static MecanumDrive MecDrive;
	public static double CAngle;
	
	public static DoubleSolenoid shifter;
	public static PowerDistributionPanel pdp;
	public static BuiltInAccelerometer accel;
	public static AHRS navX;

	
	public static boolean shift; //boolean for the super shifters on the drive train
	public static boolean drive; //boolean to switch the drive stick
	
	public static void init() {
		FRdrive = new WPI_TalonSRX(3);
		FLdrive = new WPI_TalonSRX(1);
		BRdrive = new WPI_TalonSRX(4);
		BLdrive = new WPI_TalonSRX(2);
		Left = new SpeedControllerGroup(FLdrive, BLdrive);
		Right = new SpeedControllerGroup(FRdrive, BRdrive);
		robotDrive = new DifferentialDrive(Left, Right);
		robotDrive.setSafetyEnabled(false);
		MecDrive = new MecanumDrive(FLdrive,BLdrive,FRdrive,BRdrive);
		MecDrive.setSafetyEnabled(false);		
		shifter = new DoubleSolenoid(1,0,1);
		
		pdp = new PowerDistributionPanel(0);
		navX = new AHRS(SPI.Port.kMXP);
		accel = new BuiltInAccelerometer();
		
		CAngle = 0;
		shift = true;
		drive = true; //boolean for driver, true = gear and false = fuel
	}
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
