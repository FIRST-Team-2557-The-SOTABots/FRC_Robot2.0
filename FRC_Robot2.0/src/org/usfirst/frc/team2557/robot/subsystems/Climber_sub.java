package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Climber_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Climber_cmd());
    }

    public void climb(){
    	if(RobotMap.gemini){
	    	if(Robot.oi.LJ2.get() && Robot.oi.RJ2.get()){
	        	RobotMap.climber.set(.9);
	    	}
	    	else{
	        	RobotMap.climber.set(0);
	    	}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.LJ1.get() && Robot.oi.RJ1.get()){
    	    	RobotMap.climber.set(.9);
	    	}
	    	else{
	        	RobotMap.climber.set(0);
	    	}
    	}
    }
}

