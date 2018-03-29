package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MinimalUseButtonSubsystem extends Subsystem {

	boolean mec;

	public void minimalUseButtons(){
		double triggerRight = OI.Joystick1.getRawAxis(2);
		double triggerLeft = OI.Joystick1.getRawAxis(3);
		SmartDashboard.putNumber("Right!", triggerRight);
		SmartDashboard.putNumber("Left!", triggerLeft);

		if(triggerRight > 0.8){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(1, 0, 0);
		}else if(triggerLeft > 0.8){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(-1, 0, 0);
		}
		else{
		//	RobotMap.DS1.set(Value.kReverse);	
		}
	}

	
	public void uselessForward(){
		SmartDashboard.putString("Moo", "I am a duck");
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward && OI.dy.get()){
			RobotMap.MecDrive.driveCartesian(0, 1, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse && OI.dy.get()){
			RobotMap.DiffDrive.arcadeDrive(1, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward && OI.dx.get()){
			RobotMap.MecDrive.driveCartesian(0, 0.3, 0);
			SmartDashboard.putNumber("WE ARE PRESSIG X IN MEC WE HOPE", 1000000);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse && OI.dx.get()){
			RobotMap.DiffDrive.arcadeDrive(0.3, 0);
			SmartDashboard.putNumber("WE ARE PRESSIG X IN COL WE HOPE", 1000000);
		}
//		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
//			mec = true;
//		}
//		else {
//			mec = false;
//		}
//		if(OI.dy.get()){
//			if(mec){
//				RobotMap.MecDrive.driveCartesian(0, 0.3, 0);
//			}else if(mec == false){
//				RobotMap.DiffDrive.arcadeDrive(0.3, 0);
//			}
//		}else if(OI.da.get()){
//			if(mec){
//				RobotMap.MecDrive.driveCartesian(0, -0.3, 0);
//			}else if(mec == false){
//				RobotMap.DiffDrive.arcadeDrive(0.3, 0);
//			}
//		}	
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

