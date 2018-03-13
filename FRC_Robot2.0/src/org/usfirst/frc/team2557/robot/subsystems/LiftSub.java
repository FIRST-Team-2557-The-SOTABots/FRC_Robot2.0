package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftSub extends Subsystem {
	
	public void liftInAuto(double power){
		RobotMap.LiftMotor.set(power);
		RobotMap.LiftMotor2.set(power);
	}
	
	public void LiftWithAxis(){
		double axis;
		axis = OI.Joystick2.getRawAxis(1);
		
		SmartDashboard.putNumber("THIS IS AXIS 1!!!!", axis);
		
		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		
		RobotMap.LiftMotor.set(-axis);
		RobotMap.LiftMotor2.set(-axis);
		
		SmartDashboard.putBoolean("LiftHallEffect", RobotMap.liftHallEffect.get());
		
	}

	public void LiftMethod() {
		
		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
//		double axis = OI.Joystick2.getRawAxis(3);
//		SmartDashboard.putNumber("joystick2 axis 1", axis);
		
		
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




	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new LiftCommand());
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
