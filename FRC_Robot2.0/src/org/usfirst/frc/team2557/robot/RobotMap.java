package org.usfirst.frc.team2557.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

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
	
	public static DoubleSolenoid shifter;
	public static DoubleSolenoid gearGrab;
	public static DoubleSolenoid pistonUpDown; //FuelGate
//	
	public static void init(){
		FRdrive = new CANTalon(1);
		FLdrive = new CANTalon(2);
		BRdrive = new CANTalon(3);
		BLdrive = new CANTalon(4);
		robotDrive = new RobotDrive(FLdrive, BLdrive, FRdrive, BRdrive);

		Lshooter = new CANTalon(5);
		Rshooter = new CANTalon(6);
		intake = new CANTalon(7);
		climber = new CANTalon(8);
		gearMotor = new CANTalon(9);
		
		pistonUpDown = new DoubleSolenoid(0,1);
		shifter = new DoubleSolenoid(2,3);
		gearGrab = new DoubleSolenoid(4,5);
		
	}
}
