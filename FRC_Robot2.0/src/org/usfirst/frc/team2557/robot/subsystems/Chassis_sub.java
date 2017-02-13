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
    public void arcadeDrive_gear(){
    	robotDrive.arcadeDrive(-Robot.oi.getGamepad(0).getJoystick().getRawAxis(0) *x,
    			Robot.oi.getGamepad(0).getJoystick().getRawAxis(1) *x);
    }
    public void arcadeDrive_fuel(){
    	robotDrive.arcadeDrive(-Robot.oi.getGamepad(1).getJoystick().getRawAxis(0) *x,
    			-Robot.oi.getGamepad(1).getJoystick().getRawAxis(1) *x);
    }
    public void tankDrive_gear(){
    	robotDrive.tankDrive(-Robot.oi.getGamepad(0).getJoystick().getRawAxis(0) *x,
    			Robot.oi.getGamepad(0).getJoystick().getRawAxis(5) *x);
    }
    public void tankDrive_fuel(){
    	robotDrive.tankDrive(-Robot.oi.getGamepad(0).getJoystick().getRawAxis(0) *x,
    			Robot.oi.getGamepad(0).getJoystick().getRawAxis(5) *x);
    }
    
}

