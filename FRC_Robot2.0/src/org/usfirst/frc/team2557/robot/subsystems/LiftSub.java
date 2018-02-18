package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSub extends Subsystem {
	
	public void LiftMethod() {
//		if(OI.Lift.get()) {
//		RobotMap.LiftMotor.set(.6);
//		}
//		else if(OI.Lift.get() == false) {
//			RobotMap.LiftMotor.set(0);
//			SmartDashboard.putBoolean("stop", true);
//		}
//		boolean SolVal;
		
		SmartDashboard.putNumber("LiftEncoder", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		
		boolean SolVal = OI.LiftUp.get();
		boolean SolVal2 = OI.LiftDown.get();
		SmartDashboard.putBoolean("LiftButton", OI.LiftUp.get());
		SmartDashboard.putBoolean("LiftButtonDown", OI.LiftDown.get());
		if (SolVal == true && SolVal2 == false) {
			RobotMap.LiftMotor.set(.6);
			SmartDashboard.putBoolean("here1", true);
		}else if(SolVal == false && SolVal2 == true){
			RobotMap.LiftMotor.set(-.2);
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
		
		else if(Sensor.get() = yes) {0
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

	
	public void IntakeMethod() {
		SmartDashboard.putBoolean("S1", RobotMap.S1.get());
		SmartDashboard.putBoolean("S2", RobotMap.S2.get());
		if(OI.IntakeIn.get()) {
			RobotMap.IntakeR.set(-.6);
			RobotMap.IntakeL.set(.6);
			RobotMap.S1.set(true);
			RobotMap.S1.set(false);
			SmartDashboard.putBoolean("IN", true);
//			RobotMap.S2.set(false);
		}
		else if(OI.IntakeOut.get()){
			RobotMap.IntakeR.set(.6);
			RobotMap.IntakeL.set(-.6);
			RobotMap.S1.set(false);
			RobotMap.S2.set(true);
			SmartDashboard.putBoolean("Out", true);
//			RobotMap.S2.set(true);
		}	
		else {
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
			SmartDashboard.putBoolean("Stop", true);
//			RobotMap.S1.set(true);
//			RobotMap.S2.set(true);
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

