package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.GeminiDrive_cmd;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive robotDrive = RobotMap.robotDrive;
	double x = .75;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GeminiDrive_cmd());
    }
//    public void arcadeDrive_gear(){
//    	robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, -Robot.oi.gamepad1.getRawAxis(0) *x);
//    }
//    public void arcadeDrive_fuel(){
//    	robotDrive.arcadeDrive(Robot.oi.gamepad2.getRawAxis(1) *x, -Robot.oi.gamepad2.getRawAxis(0) *x);
//    }
//    public void tankDrive_gear(){
//    	robotDrive.tankDrive(-Robot.oi.gamepad2.getRawAxis(1) *x, Robot.oi.gamepad2.getRawAxis(5) *x);
//    }
//    public void tankDrive_fuel(){
//    	robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(5) *x);
//    }
    public void arcadeDrive(){
    	if(RobotMap.gemini){
        	robotDrive.arcadeDrive(Robot.oi.gamepad2.getRawAxis(1) *x, -Robot.oi.gamepad2.getRawAxis(0) *x);
    	}
    	else if(RobotMap.gemini == false){
    		robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, -Robot.oi.gamepad1.getRawAxis(0) *x);
    	}
    }
    public void tankDrive(){
    	if(RobotMap.gemini){
        	robotDrive.tankDrive(Robot.oi.gamepad2.getRawAxis(1) *x, -Robot.oi.gamepad2.getRawAxis(5) *x);
    	}
    	else if(RobotMap.gemini == false){
    		robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, -Robot.oi.gamepad1.getRawAxis(5) *x);
    	}
    }
    public void gemini(){
    	if(Robot.oi.start1.get() && Robot.oi.select1.get()){
    		RobotMap.gemini = false;
    	} else if(Robot.oi.start2.get() && Robot.oi.select2.get()){
    		RobotMap.gemini = true;
    	}
    }
}

