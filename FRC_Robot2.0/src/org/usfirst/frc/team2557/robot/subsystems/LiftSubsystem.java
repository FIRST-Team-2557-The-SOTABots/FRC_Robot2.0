package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.lift.LiftCommand;

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
		
	}

	public void LiftMethod() {
		boolean SolVal = OI.y.get();
		boolean SolVal2 = OI.x.get();
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		boolean x = OI.x.get();
		boolean y = OI.y.get();
		if(y){
			RobotMap.LiftMotor.set(1);
			RobotMap.LiftMotor2.set(1);
		}else if(x){
			RobotMap.LiftMotor.set(-.7);
			RobotMap.LiftMotor2.set(-.7);
		}else{
			RobotMap.LiftMotor.set(0);
			RobotMap.LiftMotor2.set(0);
		}
	}
	
	public void LiftAuto(double power) {
		RobotMap.LiftMotor.set(power);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new LiftCommand());
	}
}

