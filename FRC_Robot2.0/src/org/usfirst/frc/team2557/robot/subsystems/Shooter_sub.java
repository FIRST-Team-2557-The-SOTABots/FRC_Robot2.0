package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Shooter_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Shooter_cmd());
    }
    
    public void shooting(){
    	if(RobotMap.gemini){ //While gear is active
//    		if(Robot.oi.gamepad1.getRawAxis(3) > 0.1){
//    	    	RobotMap.Lshooter.set(-.65);
//    	    	RobotMap.Rshooter.set(.65);
//    		}
//    		else{
//    	    	RobotMap.Lshooter.set(0);
//    	    	RobotMap.Rshooter.set(0);
//    		}
    	}
    	else if(RobotMap.gemini == false){ //While fuel is active
    		if(Robot.oi.gamepad1.getRawAxis(3) > 0.1){
    	    	RobotMap.Lshooter.set(-0.63);
    	    	RobotMap.Rshooter.set(0.63);
    		}
    		else{
    	    	RobotMap.Lshooter.set(0);
    	    	RobotMap.Rshooter.set(0);
    		}
    	}
    }
    public void moses_non(){ //non-toggle code
    	if(RobotMap.gemini){ //While gear is active
//    		if(Robot.oi.gamepad1.getRawAxis(2) > 0.1){
//    			RobotMap.pistonUpDown.set(Value.kForward);
//    		}
//    		else{
//    			RobotMap.pistonUpDown.set(Value.kReverse);
//    		}
    	}
    	else if(RobotMap.gemini == false){ //While fuel is active
    		if(Robot.oi.a1.get()){
    			RobotMap.pistonUpDown.set(Value.kForward);
    			return;
    		}
    		else if(Robot.oi.x1.get()){
    			RobotMap.pistonUpDown.set(Value.kReverse);
    			return;
    		}
    	}
    }
    public void moses_toggle(){ //Toggle code
    	if(RobotMap.gemini){ //While gear is active
//	    	if(RobotMap.pistonUpDown.get() == Value.kReverse){
//				RobotMap.pistonUpDown.set(Value.kForward);
//			}
//			else if (RobotMap.pistonUpDown.get() ==Value.kForward){
//				RobotMap.pistonUpDown.set(Value.kReverse);
//			}
    	}
    	else if(RobotMap.gemini == false){ //While fuel is active
    		if(Robot.oi.LB1.get() && RobotMap.pistonUpDown.get() == Value.kReverse){
				RobotMap.pistonUpDown.set(Value.kForward);
			}
			else if (Robot.oi.LB1.get() && RobotMap.pistonUpDown.get() ==Value.kForward){
				RobotMap.pistonUpDown.set(Value.kReverse);
			}
    	}
    }
}

