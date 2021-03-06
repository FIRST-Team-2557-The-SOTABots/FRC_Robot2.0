package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.StrafeButtonsCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StrafeButtonsSubsystem extends Subsystem {
	boolean mec;

	public void minimalUseButtons(){
		double triggerLeft = OI.Joystick1.getRawAxis(2);
		double triggerRight = OI.Joystick1.getRawAxis(3);
		
		SmartDashboard.putNumber("Right!", triggerRight);
		SmartDashboard.putNumber("Left!", triggerLeft);
		
		if(triggerRight > 0.2){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(-triggerRight, OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
			SmartDashboard.putNumber("MEC STRAFEEEEEEEE", triggerRight);
		}else if(triggerLeft > 0.2){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(triggerLeft, OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
			SmartDashboard.putNumber("MEC STRAFEEEEEEEE", triggerLeft);
		}
		
//		if(RobotMap.DS1.get() == Value.kForward){
//			if(triggerRight > 0.2){
//				RobotMap.MecDrive.driveCartesian(-triggerRight, OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
//				SmartDashboard.putNumber("MEC STRAFEEEEEEEE", triggerRight);
//			}else if(triggerLeft > 0.2){
//				RobotMap.MecDrive.driveCartesian(triggerLeft, OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
//				SmartDashboard.putNumber("MEC STRAFEEEEEEEE", triggerLeft);
//			}
//		}

//		if(triggerRight > 0.8){
//			RobotMap.DS1.set(Value.kForward);
//			RobotMap.MecDrive.driveCartesian(1, 0, 0);
//		}else if(triggerLeft > 0.8){
//			RobotMap.DS1.set(Value.kForward);
//			RobotMap.MecDrive.driveCartesian(-1, 0, 0);
//		}else{
//		//	RobotMap.DS1.set(Value.kReverse);	
//		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new StrafeButtonsCommand());
	}
}

