package org.usfirst.frc.team2557.robot;

import java.io.File;
import java.io.IOException;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class RobotMap {
	// Drive
	public static WPI_TalonSRX Left1;
	public static WPI_TalonSRX Left2;
	public static WPI_TalonSRX Right1;
	public static WPI_TalonSRX Right2;
	public static SpeedControllerGroup Left;
	public static SpeedControllerGroup Right;
	public static AHRS Gyro1;
	public static DifferentialDrive DiffDrive;
	public static MecanumDrive MecDrive;
	
	// Intake
	public static WPI_TalonSRX IntakeR;
	public static WPI_TalonSRX IntakeL;
	public static AnalogInput Ultrasonic;

	// Solenoid
	public static Compressor compressor;
	public static DoubleSolenoid DS1;
	public static Solenoid S1;
	public static Solenoid S2;

	// Lift
	public static WPI_TalonSRX LiftMotor;
	public static WPI_TalonSRX LiftMotor2;
	public static DigitalInput liftHallEffect;
	
	// Wing
	public static Servo LeftWing;
	public static Servo RightWing;
	public static Servo rightWing;
	public static Servo leftWing;
	public static Solenoid a;
	public static Solenoid b;
	public static Solenoid c;
	public static Solenoid d;
	
	public static Trajectory switchForward;
	public static Trajectory scaleForward;
	public static Trajectory scaleForward2;
	public static Trajectory scaleForwardRight;
	public static Trajectory scaleForwardRight2;
	public static Trajectory switchForwardMid;
	
	// CTRE Modules
	public static PowerDistributionPanel pdp;
	

	
	public static void init() {
		// Drive
		Left1 = new WPI_TalonSRX(1);
		Left2 = new WPI_TalonSRX(7);
		Right1 = new WPI_TalonSRX(3);
		Right2 = new WPI_TalonSRX(2);
		LiftMotor = new WPI_TalonSRX(5);
		LiftMotor2 = new WPI_TalonSRX(11);
		Left = new SpeedControllerGroup(Left1, Left2);
		Right = new SpeedControllerGroup(Right1, Right2);
		DiffDrive = new DifferentialDrive(Left, Right);
		MecDrive = new MecanumDrive(Left1, Left2, Right1, Right2);
		DiffDrive.setSafetyEnabled(false);
		MecDrive.setSafetyEnabled(false);
		Gyro1 = new AHRS(SPI.Port.kMXP);
		
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 8, 5.0, 100.0);
//        Waypoint[] points = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-12, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        switchForward = Pathfinder.generate(points, config);
//        File switchTrajectory = new File("/home/lvuser/Trajectories/switchForward.t");
//        try {
//			switchTrajectory.createNewFile();
//			Pathfinder.writeToFile(switchTrajectory, switchForward);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		switchForward = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/switchForward.t"));

//		Waypoint[] pointsScale = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-21, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        scaleForward = Pathfinder.generate(pointsScale, config);
//        File scaleTrajectory = new File("/home/lvuser/Trajectories/scaleForward.t");
//        try {
//			scaleTrajectory.createNewFile();
//			Pathfinder.writeToFile(scaleTrajectory, scaleForward);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		scaleForward = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/scaleForward.t"));
//		
//		Waypoint[] pointsScale2 = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-0.5, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        scaleForward2 = Pathfinder.generate(pointsScale2, config);
//        File scaleTrajectory2 = new File("/home/lvuser/Trajectories/scaleForward2.t");
//        try {
//			scaleTrajectory2.createNewFile();
//			Pathfinder.writeToFile(scaleTrajectory2, scaleForward2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        scaleForward2 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/scaleForward2.t"));
        
//        Waypoint[] pointsScaleRight = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-11.5, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        scaleForwardRight = Pathfinder.generate(pointsScaleRight, config);
//        File scaleTrajectoryRight = new File("/home/lvuser/Trajectories/scaleForwardRight.t");
//        try {
//			scaleTrajectoryRight.createNewFile();
//			Pathfinder.writeToFile(scaleTrajectoryRight, scaleForwardRight);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        scaleForwardRight = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/scaleForwardRight.t"));
        
//        Waypoint[] pointsScaleRight2 = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-0.4, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        scaleForwardRight2 = Pathfinder.generate(pointsScaleRight2, config);
//        File scaleTrajectoryRight2 = new File("/home/lvuser/Trajectories/scaleForwardRight2.t");
//        try {
//			scaleTrajectoryRight2.createNewFile();
//			Pathfinder.writeToFile(scaleTrajectoryRight2, scaleForwardRight2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        scaleForwardRight2 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/scaleForwardRight2.t"));
        
//        
//        Waypoint[] pointsSwitchMid = new Waypoint[] {
//        		// in feet
//        		new Waypoint(-6.5, 0, 0),
//                new Waypoint(0, 0, 0)
//        };
//        switchForwardMid = Pathfinder.generate(pointsSwitchMid, config);
//        File switchTrajectoryMid = new File("/home/lvuser/Trajectories/switchForwardMid.t");
//        try {
//			switchTrajectoryMid.createNewFile();
//			Pathfinder.writeToFile(switchTrajectoryMid, switchForwardMid);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        switchForwardMid = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/switchForwardMid.t"));
        
		
		// Intake
		IntakeR = new WPI_TalonSRX(4);
		IntakeL = new WPI_TalonSRX(6);
		Ultrasonic = new AnalogInput(0);		
		
		// Solenoid
		DS1 = new DoubleSolenoid(0, 0, 1);
		S1 = new Solenoid(0, 2);
		S2 = new Solenoid(0, 3);
		compressor = new Compressor(0);
		a = new Solenoid(7);
		b = new Solenoid(6);
		c = new Solenoid(5);
		d = new Solenoid(4);
		
		// Lift
		liftHallEffect = new DigitalInput(1);
		
		// Wing
		leftWing = new Servo(0);
		rightWing = new Servo(1);
		
		// CTRE Modules
		pdp = new PowerDistributionPanel(10);		
	}
}
