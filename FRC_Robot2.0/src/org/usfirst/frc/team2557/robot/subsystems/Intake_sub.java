package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Intake_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Intake_cmd());
    }
    
    public void intake(){
    	if(RobotMap.gemini){
    		if(Robot.oi.RB2.get()){
    			RobotMap.intake.set(.8);
    		}
    		else if(Robot.oi.LB2.get()){
    			RobotMap.intake.set(-.8);
    		}
    		else{
    			RobotMap.intake.set(0);
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.RB1.get()){
    			RobotMap.intake.set(.8);
    		}
    		else if(Robot.oi.LB1.get()){
    			RobotMap.intake.set(-.8);
    		}
    		else{
    			RobotMap.intake.set(0);
    		}
    	}
    }
    public void pistonUpDown(){ //Toggle Code
    	if(RobotMap.pistonUpDown.get() == Value.kReverse){
			RobotMap.pistonUpDown.set(Value.kForward);
		}
		else if (RobotMap.pistonUpDown.get() ==Value.kForward){
			RobotMap.pistonUpDown.set(Value.kReverse);
		}
    }
    public void fuelGate(){ //Non-Toggle code
    	if(RobotMap.gemini){
    		if(Robot.oi.gamepad1.getRawAxis(2) > 0.1){
    			RobotMap.pistonUpDown.set(Value.kForward);
    		}
    		else{
    			RobotMap.pistonUpDown.set(Value.kReverse);
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.gamepad2.getRawAxis(2) > 0.1){
    			RobotMap.pistonUpDown.set(Value.kForward);
    		}
    		else{
    			RobotMap.pistonUpDown.set(Value.kReverse);
    		}
    	}
    }
}

