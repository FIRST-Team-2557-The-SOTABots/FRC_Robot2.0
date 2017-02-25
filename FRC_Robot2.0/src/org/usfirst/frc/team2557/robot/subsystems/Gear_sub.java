package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Controller;
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
    	if(RobotMap.gemini){ //While gear is active
	    	if(Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONRB)
	    			||Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONRB)){ // && RobotMap.gearGrab.get() == Value.kReverse){
	    		RobotMap.gearGrab.set(Value.kForward);
	    		return;
	    	}
	    	else if(Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONLB)
	    			|| Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONLB)){// && RobotMap.gearGrab.get() == Value.kForward){
	    		RobotMap.gearGrab.set(Value.kReverse);
	    		return;
	    	}
	    	else if(RobotMap.gearSwitch.get()){
	    		RobotMap.gearGrab.set(Value.kForward);
	    		return;
	    	}
    	}
    	else if(RobotMap.gemini == false){ //While Fuel is active
//    		if(Robot.oi.RB1.get() && RobotMap.gearGrab.get()==Value.kReverse){
//	    		RobotMap.gearGrab.set(Value.kForward);
//	    	}
//	    	else if(Robot.oi.RB1.get() && RobotMap.gearGrab.get()==Value.kForward){
//	    		RobotMap.gearGrab.set(Value.kReverse);
//	    	}
    		
    		
    		
    		if(RobotMap.gearSwitch.get()){
	    		RobotMap.gearGrab.set(Value.kForward);
	    		return;
	    	}
    	}
    }
    public void gearPosition(){
    	if(RobotMap.gemini){ //While Gear Forward is active, run the gears
    		if(Robot.oi.getGamepad(1).getRawAxis(3) > .1){
    			RobotMap.gearMotor.set(Robot.oi.getGamepad(1).getRawAxis(3) * .65);
    		}
    		else if(Robot.oi.getGamepad(1).getRawAxis(2) > .1){
    			RobotMap.gearMotor.set(-Robot.oi.getGamepad(1).getRawAxis(2) * .5);
    		}
    		else{
    			RobotMap.gearMotor.set(0);
    		}
    	}
    	else if(RobotMap.gemini == false){ //While Fuel Forward is  active, don't run the gears
//    		if(Robot.oi.gamepad1.getRawAxis(3) > .1){
//    			RobotMap.gearMotor.set(Robot.oi.gamepad2.getRawAxis(3) * .5);
//    		}
//    		else if(Robot.oi.gamepad1.getRawAxis(2) > .1){
//    			RobotMap.gearMotor.set(-Robot.oi.gamepad2.getRawAxis(2) * .5);
//    		}
//    		else{
//    			RobotMap.gearMotor.set(0);
//    		}
    	}
    }
    public void autoGear(){
//    	if(RobotMap.gearEnc.get() < -70){
//    		
//    	}
//    	else if(RobotMap.gearEnc.get() <= -659){
//    		RobotMap.gearMotor.set(.1);
//    	}
//    	else 
    		while(RobotMap.gearSwitch.get() && RobotMap.gearEnc.get() > -660){
    		RobotMap.gearMotor.set(.6);
    	}
    	
    	
    }
    
    
}