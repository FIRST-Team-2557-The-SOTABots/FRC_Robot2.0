package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftSub extends Subsystem {
	
	public void liftInAuto(double power){
		RobotMap.LiftMotor.set(power);
	}
	
	public void LiftWithAxis(){
		
		double liftSpeed;
		liftSpeed = OI.Joystick2.getRawAxis(1);
		SmartDashboard.putNumber("Lift In LiftSub", liftSpeed);
		
		double value;
		value = OI.Joystick2.getY();
		SmartDashboard.putNumber("lift2 in sub", value);
		
		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
//		double axis = OI.Joystick2.getRawAxis(3);
//		SmartDashboard.putNumber("joystick2 axis 1", axis);
		
		RobotMap.LiftMotor.set(-value);
	
	}

	public void LiftMethod() {
		
//		double liftSpeed;
//		liftSpeed = OI.Joystick2.getRawAxis(1);
//		SmartDashboard.putNumber("Lift In LiftSub", liftSpeed);
//		
//		double value;
//		value = OI.Joystick2.getY();
//		SmartDashboard.putNumber("lift2 in sub", value);
//		
//		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
////		double axis = OI.Joystick2.getRawAxis(3);
////		SmartDashboard.putNumber("joystick2 axis 1", axis);
//		
//		RobotMap.LiftMotor.set(-value);
		
		
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		boolean x = OI.x.get();
		boolean y = OI.y.get();
		
//		if(x == false && y == true && a < 30000){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false && a > -2000){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}
		
		if(x == false && y == true){
			RobotMap.LiftMotor.set(1.0);
		}else if(x == true && y == false){
			RobotMap.LiftMotor.set(-.7);
		}else{
			RobotMap.LiftMotor.set(0);
		}
	}




	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new LiftCommand());
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

