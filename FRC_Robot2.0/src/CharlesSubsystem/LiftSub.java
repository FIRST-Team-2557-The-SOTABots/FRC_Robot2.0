package CharlesSubsystem;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSub extends Subsystem {
	
	WPI_TalonSRX Lifter = RobotMap.LiftMotor;
	
	public void LiftMethod() {
		
		RobotMap.LiftMotor.set(OI.Joystick2.getRawAxis(4)); 

//		RobotMap.LiftMotor.set(.5);
		
		//			LiftVar = yes;
		/*
		else if (Sensor.get() == no && LiftVar){
			Lifter.set(-1);
			LiftVar = no;
		}
		
		else if(Sensor.get() = yes) {
			if(CubeIsThere){
				Lifter.set(0)
				LiftVar = no;
		}
		
		else if(CubeIsGone){
				Lifter.set(-1)
				LiftVar = no;
		}
		else {
			
		}
	} 
		
		*/
		
	}

	
	public void IntakeMethod() {
			RobotMap.IntakeR.set(-OI.Joystick2.getRawAxis(3));
			RobotMap.IntakeL.set(OI.Joystick2.getRawAxis(3));
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

