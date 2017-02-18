package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Chassis_cmd;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double x = .75;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Chassis_cmd());
    }
    public void arcadeDrive_gear(){
    	RobotMap.robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *x);
    }
    public void arcadeDrive_fuel(){
    	RobotMap.robotDrive.arcadeDrive(Robot.oi.gamepad2.getRawAxis(1) *x, -Robot.oi.gamepad2.getRawAxis(0) *x);
    }
    public void tankDrive_gear(){
    	RobotMap.robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(0) *x, Robot.oi.gamepad1.getRawAxis(5) *x);
    }
    public void tankDrive_fuel(){
    	RobotMap.robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(0) *x, Robot.oi.gamepad1.getRawAxis(5) *x);
    }
    
}

