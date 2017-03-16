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
	public boolean _positionR;
	public boolean _positionL;
	public double _angle = 0;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void bothHoppers(){
    	if(Robot.oi.gamepad1.getPOV() == 270){
    		RobotMap.leftAgitator.setAngle(100);
    		RobotMap.rightAgitator.setAngle(100);
    	}
    	else if(Robot.oi.gamepad1.getPOV() == 90){
    		RobotMap.leftAgitator.setAngle(0);
    		RobotMap.rightAgitator.setAngle(0);
    	}
    }
    public void leftHopper(){
    	
    	if(RobotMap.leftAgitator.getAngle() == 90){
    		_positionL = false;
    	}
    	else if(RobotMap.leftAgitator.getAngle() == 1){
    		_positionL = true;
    	}
    	
///////////
    	if(_positionL == true){
    		RobotMap.leftAgitator.setAngle(_angle);
    		_angle ++;
    	}
    	
    	else if(_positionL == false){
    		RobotMap.leftAgitator.setAngle(_angle);
    		_angle --;
    	}
    	
    }
    
    public void rightHopper(){
        	
        if(RobotMap.rightAgitator.getAngle() == 90){
    		_positionR = false;
    	}
        else if(RobotMap.rightAgitator.getAngle() == 1){
    		_positionR = true;
    	}
    	
////////////
    	if(_positionR == true){
    		RobotMap.rightAgitator.setAngle(_angle);
    		_angle ++;
    	}
    	
    	else if(_positionR == false){
    		RobotMap.rightAgitator.setAngle(_angle);
    		_angle --;
    	}
    	
    }
    
}

