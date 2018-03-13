package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftSub extends Subsystem {
	
	public void liftInAuto(double power){
		RobotMap.LiftMotor.set(power);
		
		double x = SmartDashboard.getNumber("LiftEncoder", -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		
		if( (SmartDashboard.getNumber("LiftEncoder", -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition())) > x) {
			SmartDashboard.putNumber("LiftEncoder", -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		}
	}

	public void LiftMethod() {
		
		SmartDashboard.putNumber("LiftEncoder", -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
//		double axis = OI.Joystick2.getRawAxis(3);
//		SmartDashboard.putNumber("joystick2 axis 1", axis);
		
//		RobotMap.LiftMotor.set(OI.Joystick2.getRawAxis(1));
		
		
		boolean SolVal = OI.y.get();
		boolean SolVal2 = OI.x.get();
		SmartDashboard.putBoolean("LiftButton", OI.y.get());
		SmartDashboard.putBoolean("LiftButtonDown", OI.x.get());
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		if (SolVal == true && SolVal2 == false && -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() < 35000) {
			RobotMap.LiftMotor.set(1);
			SmartDashboard.putBoolean("here1", true);
		}else if(SolVal == false && SolVal2 == true && -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() > -2000){
			RobotMap.LiftMotor.set(-.8);
		}
		else {
			RobotMap.LiftMotor.set(0);
		}
	}
	//
	
		
//		RobotMap.LiftMotor.set(-OI.Joystick2.getRawAxis(1)*.8);
//		if(Math.abs(OI.Joystick2.getRawAxis(1)) > .1){
//SmartDashboard.putBoolean("works", true);
//	}
//		RobotMap.LiftMotor.set(.5);
		
		//			LiftVar = yes;
		
//		else if (Sensor.get() == no && LiftVar){
//			Lifter.set(-1);
//			LiftVar = no;
//		}
		
//		boolean x = OI.x.get();
//		boolean y = OI.y.get();
//		if(x == false && y == true && a < 35000){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false && a > 2000){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}
		
//		if(x == false && y == true && a < 35000){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false && a > 1000){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}
		
//		if(x == false && y == true ){
//			RobotMap.LiftMotor.set(1.0);
//		}else if(x == true && y == false ){
//			RobotMap.LiftMotor.set(-.7);
//		}else{
//			RobotMap.LiftMotor.set(0);
//		}

	
	public void LiftAuto(double power) {
			RobotMap.LiftMotor.set(power);
	}
	
	
	public void AutoIntake(double fire) {
		RobotMap.IntakeR.set(fire);
		RobotMap.IntakeL.set(-fire);
		RobotMap.S1.set(false);
		RobotMap.S2.set(true);
	}
	
	public void IntakeAutoMethod() {
		if(RobotMap.LiftConfirm == false) {
			RobotMap.IntakeR.set(.6);
			RobotMap.IntakeL.set(-.6);
			RobotMap.S1.set(false);
			RobotMap.S2.set(true);
			RobotMap.LiftConfirm = true;
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

