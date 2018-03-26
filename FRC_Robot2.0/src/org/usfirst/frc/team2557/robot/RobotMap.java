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

	public static Trajectory drive0;
	public static Trajectory drive1;
	public static Trajectory drive2;
	public static Trajectory drive3;
	public static Trajectory drive4;
	public static Trajectory drive5;
	public static Trajectory drive6;
	public static Trajectory drive7;
	public static Trajectory drive8;
	public static Trajectory drive9;
	public static Trajectory drive10;
	public static Trajectory drive11;	
	public static Trajectory drive12;	
	public static Trajectory drive13;	
	public static Trajectory trajectory;
	public static Trajectory trajectorySlow;
	public static Trajectory trajectory2;

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

//		// could increase accel !!!... done
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 8.5, 10.0, 1000000.0);
		Trajectory.Config configSlow = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 5.0, 5.0, 1000000.0);
		

		Waypoint[] pointsSlow = new Waypoint[] {
				new Waypoint(-1, -1, 0),
                new Waypoint(0, 0, Pathfinder.d2r(-90)),
                new Waypoint(0, 2.5, Pathfinder.d2r(-90)),
        };
        trajectorySlow = Pathfinder.generate(pointsSlow, configSlow);
        File fileSlow = new File("/home/lvuser/Trajectories/jacitestleftSlow.t");
		try {
			fileSlow.createNewFile();
			Pathfinder.writeToFile(fileSlow, trajectorySlow);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Waypoint[] points = new Waypoint[] {
				new Waypoint(-14.25, 4, 0),
				new Waypoint(-4, 4, 0),
//                new Waypoint(-0.5, 0.5, Pathfinder.d2r(-90)),
//                new Waypoint(-2, 1, Pathfinder.d2r(45)),
                new Waypoint(0, 0, Pathfinder.d2r(100)),
                new Waypoint(0, -15.0, Pathfinder.d2r(100)),
//                new Waypoint(0.5, -15.5, Pathfinder.d2r(45)),
//                new Waypoint(1, -16.5, 0),
//                new Waypoint(1.5, -16.5, 0)
        };
        trajectory = Pathfinder.generate(points, config);
        File file = new File("/home/lvuser/Trajectories/jacitestleft.t");
		try {
			file.createNewFile();
			Pathfinder.writeToFile(file, trajectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Waypoint[] points0 = new Waypoint[] {
//				new Waypoint(-14.25, -4, 0),
//				new Waypoint(-4, -4, 0),
////                new Waypoint(-0.5, -0.5, Pathfinder.d2r(90)),
////                new Waypoint(-2, -1, Pathfinder.d2r(-45)),
//                new Waypoint(0, 0, Pathfinder.d2r(-90)),
//                new Waypoint(0, 15.0, Pathfinder.d2r(-90)),
////                new Waypoint(0.5, 1, Pathfinder.d2r(-30)),
////                new Waypoint(1, 16.5, 0),
////                new Waypoint(1.5, 16.5, 0)
//        };
//        trajectory2 = Pathfinder.generate(points0, config);
//        File file2 = new File("/home/lvuser/Trajectories/jacitest.t");
//		try {
//			file.createNewFile();
//			Pathfinder.writeToFile(file2, trajectory2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points = new Waypoint[] {
//				new Waypoint(-4, 4, 0),
////                new Waypoint(-0.5, 0.5, Pathfinder.d2r(-90)),
////                new Waypoint(-2, 1, Pathfinder.d2r(45)),
//                new Waypoint(0, 0, 0)
//        };
//        trajectory = Pathfinder.generate(points, config);
//        File file = new File("/home/lvuser/Trajectories/jacitestleft.t");
//		try {
//			file.createNewFile();
//			Pathfinder.writeToFile(file, trajectory);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points0 = new Waypoint[] {
//				new Waypoint(-4, -4, 0),
////                new Waypoint(-0.5, -0.5, Pathfinder.d2r(90)),
////                new Waypoint(-2, -1, Pathfinder.d2r(-45)),
//                new Waypoint(0, 0, 0)
//        };
//        trajectory2 = Pathfinder.generate(points0, config);
//        File file2 = new File("/home/lvuser/Trajectories/jacitest.t");
//		try {
//			file.createNewFile();
//			Pathfinder.writeToFile(file2, trajectory2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points1 = new Waypoint[] {
//				// in feet
//				new Waypoint(-8.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive1 = Pathfinder.generate(points1, config);
//		File drive1file = new File("/home/lvuser/Trajectories/drive1.t");
//		try {
//			drive1file.createNewFile();
//			Pathfinder.writeToFile(drive1file, drive1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points2 = new Waypoint[] {
//				// in feet
//				new Waypoint(-8.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive2 = Pathfinder.generate(points2, config);
//		File drive2file = new File("/home/lvuser/Trajectories/drive2.t");
//		try {
//			drive2file.createNewFile();
//			Pathfinder.writeToFile(drive2file, drive2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points3 = new Waypoint[] {
//				// in feet
//				new Waypoint(-5.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive3 = Pathfinder.generate(points3, config);
//		File drive3file = new File("/home/lvuser/Trajectories/drive3.t");
//		try {
//			drive3file.createNewFile();
//			Pathfinder.writeToFile(drive3file, drive3);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points4 = new Waypoint[] {
//				// in feet
//				new Waypoint(-8.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive4 = Pathfinder.generate(points4, config);
//		File drive4file = new File("/home/lvuser/Trajectories/drive4.t");
//		try {
//			drive4file.createNewFile();
//			Pathfinder.writeToFile(drive4file, drive4);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points5 = new Waypoint[] {
//				// in feet
//				new Waypoint(-4.5, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive5 = Pathfinder.generate(points5, config);
//		File drive5file = new File("/home/lvuser/Trajectories/drive5.t");
//		try {
//			drive5file.createNewFile();
//			Pathfinder.writeToFile(drive5file, drive5);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points6 = new Waypoint[] {
//				// in feet
//				new Waypoint(-12.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive6 = Pathfinder.generate(points6, config);
//		File drive6file = new File("/home/lvuser/Trajectories/drive6.t");
//		try {
//			drive6file.createNewFile();
//			Pathfinder.writeToFile(drive6file, drive6);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points7 = new Waypoint[] {
//				// in feet
//				new Waypoint(-0.5, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive7 = Pathfinder.generate(points7, config);
//		File drive7file = new File("/home/lvuser/Trajectories/drive7.t");
//		try {
//			drive7file.createNewFile();
//			Pathfinder.writeToFile(drive7file, drive7);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Waypoint[] points8 = new Waypoint[] {
				// in feet
				new Waypoint(-20.0, 0, 0),
				new Waypoint(0, 0, 0)
		};
		drive8 = Pathfinder.generate(points8, config);
		File drive8file = new File("/home/lvuser/Trajectories/drive8.t");
		try {
			drive8file.createNewFile();
			Pathfinder.writeToFile(drive8file, drive8);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Waypoint[] points9 = new Waypoint[] {
//				// in feet
//				new Waypoint(-0.5, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive9 = Pathfinder.generate(points9, config);
//		File drive9file = new File("/home/lvuser/Trajectories/drive9.t");
//		try {
//			drive9file.createNewFile();
//			Pathfinder.writeToFile(drive9file, drive9);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points10 = new Waypoint[] {
//				// in feet
//				new Waypoint(-18.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive10 = Pathfinder.generate(points10, config);
//		File drive10file = new File("/home/lvuser/Trajectories/drive10.t");
//		try {
//			drive10file.createNewFile();
//			Pathfinder.writeToFile(drive10file, drive10);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points11 = new Waypoint[] {
//				// in feet
//				new Waypoint(-12.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive11 = Pathfinder.generate(points11, config);
//		File drive11file = new File("/home/lvuser/Trajectories/drive11.t");
//		try {
//			drive11file.createNewFile();
//			Pathfinder.writeToFile(drive11file, drive11);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Waypoint[] points12 = new Waypoint[] {
//				// in feet
//				new Waypoint(-14.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive12 = Pathfinder.generate(points12, config);
//		File drive12file = new File("/home/lvuser/Trajectories/drive12.t");
//		try {
//			drive12file.createNewFile();
//			Pathfinder.writeToFile(drive12file, drive12);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
//		Waypoint[] points13 = new Waypoint[] {
//				// in feet
//				new Waypoint(-2.0, 0, 0),
//				new Waypoint(0, 0, 0)
//		};
//		drive13 = Pathfinder.generate(points13, config);
//		File drive13file = new File("/home/lvuser/Trajectories/drive13.t");
//		try {
//			drive13file.createNewFile();
//			Pathfinder.writeToFile(drive13file, drive13);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		trajectory = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/jacitestleftSlow.t"));
		trajectory = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/jacitestleft.t"));
		trajectory2 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/jacitest.t"));
		drive1 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive1.t"));
		drive2 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive2.t"));
		drive3 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive3.t"));
		drive4 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive4.t"));
		drive5 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive5.t"));
		drive6 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive6.t"));
		drive7 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive7.t"));
		drive8 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive8.t"));
		drive9 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive9.t"));
		drive10 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive10.t"));
		drive11 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive11.t"));
		drive12 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive12.t"));
		drive13 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/drive13.t"));

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
