package CharlesSubsystem;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSub extends Subsystem {
	
	WPI_TalonSRX Lifter = RobotMap.LiftMotor;
	
	public void LiftMethod() {
//		if(OI.Lift.get()) {
//		RobotMap.LiftMotor.set(.6);
//		}
//		else if(OI.Lift.get() == false) {
//			RobotMap.LiftMotor.set(0);
//			SmartDashboard.putBoolean("stop", true);
//		}

		RobotMap.LiftMotor.set(OI.Joystick2.getRawAxis(1)*.8);
		
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

	
	public void IntakeInMethod() {
		if(OI.IntakeIn.get()) {
			RobotMap.IntakeR.set(-.6);
			RobotMap.IntakeL.set(.6);
			RobotMap.S1.set(true);
			RobotMap.S2.set(true);
		}
		else if(OI.IntakeOut.get()){
			RobotMap.IntakeR.set(.6);
			RobotMap.IntakeL.set(-.6);
			RobotMap.S1.set(false);
			RobotMap.S2.set(false);
		}
		else {
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
//			RobotMap.S1.set(true);
//			RobotMap.S2.set(true);
		}
		}

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

