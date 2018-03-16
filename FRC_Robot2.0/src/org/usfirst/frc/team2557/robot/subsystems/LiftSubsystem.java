package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.lift.LiftCommandWithAxis;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftSubsystem extends Subsystem {
	
	public void liftInAuto(double power){
		RobotMap.LiftMotor.set(power);
		RobotMap.LiftMotor2.set(power);
	}
	
	public void LiftWithAxis(){
		double axis = OI.Joystick2.getRawAxis(1);
		
		RobotMap.LiftMotor.set(-axis);
		RobotMap.LiftMotor2.set(-axis);
		
		SmartDashboard.putNumber("This is Lifting", axis);
		
		
	}

	public void LiftAuto(double power) {
		RobotMap.LiftMotor.set(power);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new LiftCommandWithAxis());
	}
}

