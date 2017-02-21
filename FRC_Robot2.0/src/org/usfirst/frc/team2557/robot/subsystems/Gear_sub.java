package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Gear_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Gear_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Gear_cmd());
    }
    
    
    public void gearGrab(){ 
	    	if(RobotMap.FALL){ // && RobotMap.gearGrab.get() == Value.kReverse){
	    		RobotMap.gearGrab.set(Value.kForward);
	    		RobotMap.FALL = false;
	    	}
	    	else if(RobotMap.FALL == false){// && RobotMap.gearGrab.get() == Value.kForward){
	    		RobotMap.gearGrab.set(Value.kReverse);
	    		RobotMap.FALL = true;
	    	}
	    	else if(RobotMap.gearSwitch.get()){
	    		RobotMap.gearGrab.set(Value.kForward);
	    		return;
	    	}
    	
    		    
    		       
    	
    }
    public void gearPosition(){
    	if(RobotMap.gemini){ //While Gear Forward is active, run the gears
    		if(Robot.oi.gamepad2.getRawAxis(3) > .1){
    			RobotMap.gearMotor.set(Robot.oi.gamepad2.getRawAxis(3) * .65);
    		}
    		else if(Robot.oi.gamepad2.getRawAxis(2) > .1){
    			RobotMap.gearMotor.set(-Robot.oi.gamepad2.getRawAxis(2) * .5);
    		}
    		else{
    			RobotMap.gearMotor.set(0);
    		}
    	}
    	
    }
    
  
    public void autoGear(){
    	
    	if(RobotMap.gearEnc.get() >= -550){
    		RobotMap.gearMotor.set(-0.8);
    	}
    	else if(RobotMap.gearEnc.get() <= -550){
    		RobotMap.gearMotor.set(0);
    	}
//   	if( RobotMap.gearEnc.get() >= -670){
//   		RobotMap.gearMotor.set(.8);
//    	}
//   	else if(RobotMap.gearEnc.get() <= -670){
//   		RobotMap.gearMotor.set(0);
//   	}
//    	else 
//    		while(RobotMap.gearSwitch.get() && ( RobotMap.gearEnc).get() > -660){
//    		RobotMap.gearMotor.set(.6);
//    	}
    	
    	
    }
    
    
}
