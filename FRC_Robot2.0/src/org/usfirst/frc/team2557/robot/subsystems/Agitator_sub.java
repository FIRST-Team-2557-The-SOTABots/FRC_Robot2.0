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
    	if(RobotMap.leftAgitator.getAngle() == 0){
    		_positionL = true;
    	}
    	if(RobotMap.leftAgitator.getAngle() != 90 && _positionL == true){
    		RobotMap.leftAgitator.setAngle(90);
    	}
    	
    	if(RobotMap.leftAgitator.getAngle() != 0 && _positionL == false){
    		RobotMap.leftAgitator.setAngle(0);
    	}
    	
    }
    
    public void rightHopper(){
        	
        if(RobotMap.rightAgitator.getAngle() == 90){
    		_positionR = false;
    	}
    	if(RobotMap.rightAgitator.getAngle() == 0){
    		_positionR = true;
    	}
    	if(RobotMap.rightAgitator.getAngle() != 90 && _positionR == true){
    		RobotMap.rightAgitator.setAngle(90);
    	}
    	
    	if(RobotMap.rightAgitator.getAngle() != 0 && _positionR == false){
    		RobotMap.rightAgitator.setAngle(0);
    	}
    	
    }
    
}

