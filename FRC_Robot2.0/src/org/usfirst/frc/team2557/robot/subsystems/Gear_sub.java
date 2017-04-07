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
	final double _upAdjust 		= 1;
	final double _downAdjust 	= 1;
	public double _cam			= 45;
	public int _stage			= 0;
    public void initDefaultCommand() {
    	setDefaultCommand(new Gear_cmd());
    }
//    public void gearGrab(){ 
//	    if(_stage == 0){ // && RobotMap.gearGrab.get() == Value.kReverse){
//	    	_stage = 1;
//	    }
//	    else if(_stage == 1){// && RobotMap.gearGrab.get() == Value.kForward){	
//	    	_stage = 0;
//	    }	    
    public void gearIntake(){
    	if(Robot.oi.RB2.get()){
    		RobotMap.gearMotor.set(.9);
    	}
    	else if(Robot.oi.LB2.get()){
    		RobotMap.gearMotor.set(-.75);
    	}
    	else if(Robot.oi.gamepad2.getRawAxis(3) > .1){
			RobotMap.gearMotor.set(Robot.oi.gamepad2.getRawAxis(3) * _upAdjust);
			RobotMap.gearGrab.set(Value.kReverse);
		}
		else if(Robot.oi.gamepad2.getRawAxis(2) > .1){
			RobotMap.gearMotor.set(-Robot.oi.gamepad2.getRawAxis(2) * _downAdjust);
			RobotMap.gearGrab.set(Value.kReverse);
			
		}
		else{
			RobotMap.gearMotor.set(0);
			RobotMap.gearGrab.set(Value.kForward);

    	}
    	
    }
    public void gearCamera(){
    	if(Robot.oi.gamepad1.getRawAxis(5) > .25 || Robot.oi.gamepad2.getRawAxis(5) > .25){
			_cam += 1;
		}
		else if(Robot.oi.gamepad1.getRawAxis(5) < -.25 || Robot.oi.gamepad2.getRawAxis(5) < -.25){
			_cam -=1;
		}
		else{		
			_cam += 0;
		}
		RobotMap.cameraServo.setAngle(_cam);
    }
    
    /* Unused after the gear mechanism change
 	public void switchMode(){
	if(Robot.oi.gamepad2.getPOV() == 0){
		RobotMap._switch = true;
	}
	else if(Robot.oi.gamepad2.getPOV() == 180){
		RobotMap._switch = false;
	}
	
	 if(RobotMap.gearSwitch.get() && RobotMap._switch){
	    	RobotMap.gearGrab.set(Value.kForward);
	    	RobotMap.FALL = true;
//	    	return;
	    	RobotMap._switch = false; 
	    	//^^This line might have to be taken out which would mean active/inactive would be manually controlled
	    	//^^But if it is taken out then this statement might not break unless the controller deactivates the switch
	    }
}
*/
   
    
    
}
