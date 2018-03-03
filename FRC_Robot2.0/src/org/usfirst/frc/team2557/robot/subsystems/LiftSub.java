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

	public void LiftMethod() {
		
		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
//		double axis = OI.Joystick2.getRawAxis(3);
//		SmartDashboard.putNumber("joystick2 axis 1", axis);
		
		boolean SolVal = OI.LiftUp.get();
		boolean SolVal2 = OI.LiftDown.get();
		SmartDashboard.putBoolean("LiftButton", OI.LiftUp.get());
		SmartDashboard.putBoolean("LiftButtonDown", OI.LiftDown.get());
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		if (SolVal == true && SolVal2 == false && -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() < 37000) {
			RobotMap.LiftMotor.set(1);
			SmartDashboard.putBoolean("here1", true);
		}else if(SolVal == false && SolVal2 == true && -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() > 2000){
			RobotMap.LiftMotor.set(-.8);
		}
		else {
			RobotMap.LiftMotor.set(0);
		}
		
//		RobotMap.LiftMotor.set(-OI.Joystick2.getRawAxis(1)*.8);
//		if(Math.abs(OI.Joystick2.getRawAxis(1)) > .1){
//SmartDashboard.putBoolean("works", true);
//	}
//		RobotMap.LiftMotor.set(.5);
		
		//			LiftVar = yes;
		/*
		else if (Sensor.get() == no && LiftVar){
			Lifter.set(-1);
			LiftVar = no;
		}
		
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		boolean x = OI.x.get();
		boolean y = OI.y.get();
//		if(x == false && y == true && a < 35000){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false && a > 2000){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}
		
		if(x == false && y == true && a < 35000){
			RobotMap.LiftMotor.set(1.0);
		}else if(x == true && y == false && a > 1000){
			RobotMap.LiftMotor.set(-.7);
		}else{
			RobotMap.LiftMotor.set(0);
		}
		
//		if(x == false && y == true ){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false ){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}

	}
	
	public void LiftAuto(double power) {
			RobotMap.LiftMotor.set(power);
	}
	
	boolean Moo = RobotMap.LiftConfirm;
	
	public void IntakeAutoMethod() {
		if(Moo == false) {
			RobotMap.IntakeR.set(.6);
			RobotMap.IntakeL.set(-.6);
			RobotMap.S1.set(false);
			RobotMap.S2.set(true);
			Moo = false;
		}
		else {
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
			RobotMap.S1.set(true);
			RobotMap.S1.set(false);
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

