package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Controller;
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
	    	if(Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONLJ)
	    			&& Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONRJ)){
	        	RobotMap.climber.set(.9);
	    	}
	    	else{
	        	RobotMap.climber.set(0);
	    	}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONLJ)
    				&& Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONRJ)){
    	    	RobotMap.climber.set(.9);
	    	}
	    	else{
	        	RobotMap.climber.set(0);
	    	}
    	}
    }
}

