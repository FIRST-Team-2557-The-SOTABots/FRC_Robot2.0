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
		double axis;
		axis = OI.Joystick2.getRawAxis(1);
		
		double a = -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
		
		RobotMap.LiftMotor.set(-axis);
		RobotMap.LiftMotor2.set(-axis);
		
	}

	public void LiftMethod() {
//		double axis = OI.Joystick2.getRawAxis(3);
//		SmartDashboard.putNumber("joystick2 axis 1", axis);
		
//		RobotMap.LiftMotor.set(OI.Joystick2.getRawAxis(1));
		
		
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

