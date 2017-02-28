package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Agitator_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Agitator_cmd());
    }
    
    public void leftHopper(){
    	
    	if(RobotMap.leftAgitator.getAngle() >= 5 && RobotMap.leftAgitator.getAngle() <= -5){
    		RobotMap.leftAgitator.setAngle(90);
    	}
    	
    	else if(RobotMap.leftAgitator.getAngle() <= 85 && RobotMap.leftAgitator.getAngle() >= 95){
    		RobotMap.leftAgitator.setAngle(0);
    	}
    	
    }
    
    public void rightHopper(){
        	
        if(RobotMap.rightAgitator.getAngle() >= 5 && RobotMap.rightAgitator.getAngle() <= -5){
        	RobotMap.rightAgitator.setAngle(90);
        }
        	
        else if(RobotMap.rightAgitator.getAngle() <= 85 && RobotMap.rightAgitator.getAngle() >= 95){
        	RobotMap.rightAgitator.setAngle(0);
        }
    	
    }
    
}

