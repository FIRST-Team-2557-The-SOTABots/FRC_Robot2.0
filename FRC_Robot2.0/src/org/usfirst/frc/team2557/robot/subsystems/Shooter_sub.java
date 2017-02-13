package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Shooter_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Shooter_cmd());
    }
    
    public void shooting(){
    	if(RobotMap.gemini){
    		if(Robot.oi.getGamepad(0).getJoystick().getRawAxis(3) > 0.1){
    	    	RobotMap.Lshooter.set(.65);
    	    	RobotMap.Rshooter.set(.65);
    		}
    		else{
    	    	RobotMap.Lshooter.set(0);
    	    	RobotMap.Rshooter.set(0);
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.getGamepad(1).getJoystick().getRawAxis(3) > 0.1){
    	    	RobotMap.Lshooter.set(.65);
    	    	RobotMap.Rshooter.set(.65);
    		}
    		else{
    	    	RobotMap.Lshooter.set(0);
    	    	RobotMap.Rshooter.set(0);
    		}
    	}
    }
}

