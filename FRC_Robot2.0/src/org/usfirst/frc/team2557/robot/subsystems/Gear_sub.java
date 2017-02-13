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
    	if(RobotMap.gemini){
	    	if(Robot.oi.getGamepad(1).getButton(Controller.BUTTONLB).get()
	    			&& RobotMap.gearGrab.get()==Value.kReverse){
	    		RobotMap.gearGrab.set(Value.kForward);
	    	}
	    	else if(Robot.oi.getGamepad(1).getButton(Controller.BUTTONLB).get()
	    			&& RobotMap.gearGrab.get()==Value.kForward){
	    		RobotMap.gearGrab.set(Value.kReverse);
	    	}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.getGamepad(0).getButton(Controller.BUTTONLB).get()
    				&& RobotMap.gearGrab.get()==Value.kReverse){
	    		RobotMap.gearGrab.set(Value.kForward);
	    	}
	    	else if(Robot.oi.getGamepad(0).getButton(Controller.BUTTONLB).get()
	    			&& RobotMap.gearGrab.get()==Value.kForward){
	    		RobotMap.gearGrab.set(Value.kReverse);
	    	}
    	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gearPosition(){
    	if(RobotMap.gemini){
    		//if(Robot.oi.gamepad2.getRawAxis(3) > .1){
    		if(Robot.oi.getGamepad(1).getJoystick().getRawAxis(3) > .1){
    			RobotMap.gearMotor.set(Robot.oi.getGamepad(1).getJoystick().getRawAxis(3) * .5);
    		}
    		else if(Robot.oi.getGamepad(1).getJoystick().getRawAxis(2) > .1){
    			RobotMap.gearMotor.set(-Robot.oi.getGamepad(1).getJoystick().getRawAxis(2) * .5);
    		}
    		else{
    			RobotMap.gearMotor.set(0);
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.getGamepad(0).getJoystick().getRawAxis(3) > .1){
    			RobotMap.gearMotor.set(Robot.oi.getGamepad(1).getJoystick().getRawAxis(3) * .5);
    		}
    		else if(Robot.oi.getGamepad(0).getJoystick().getRawAxis(2) > .1){
    			RobotMap.gearMotor.set(-Robot.oi.getGamepad(1).getJoystick().getRawAxis(2) * .5);
    		}
    		else{
    			RobotMap.gearMotor.set(0);
    		}
    	}
    }
    
}
