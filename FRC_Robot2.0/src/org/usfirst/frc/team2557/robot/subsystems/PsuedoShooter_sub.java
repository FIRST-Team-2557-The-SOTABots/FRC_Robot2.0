package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.PsuedoShooter_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PsuedoShooter_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final double min_left 	= 16800;
	public final double max_left 	= 21520;
	public final double prime_left 	= 19160;
	
	public final double min_right 	= -17100;
	public final double max_right 	= -21680;
	public final double prime_right = -19390;
   

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PsuedoShooter_cmd());
    }
    
    public double speedChangeLeft(){
    	
    	if(RobotMap.Lshooter.getEncVelocity() <= min_left){
    		return RobotMap.Lshooter.get() - 0.007;
    	}
    	else if(RobotMap.Lshooter.getEncVelocity() >= max_left){
    		return RobotMap.Lshooter.get() + 0.0025;
    	}
    	else if(RobotMap.Lshooter.getEncVelocity() != prime_left){
    		if(RobotMap.Lshooter.getEncVelocity() < prime_left){
    			return RobotMap.Lshooter.get() - 0.0001;
    		}
    		else if(RobotMap.Lshooter.getEncVelocity() > prime_left){
    			return RobotMap.Lshooter.get() + 0.0001;
    		}
    	}
    	return RobotMap.Lshooter.get();
    }
public double speedChangeRight(){
    	
    	if(RobotMap.Rshooter.getEncVelocity() >= min_right){
    		return RobotMap.Rshooter.get() + 0.007;
    	}
    	else if(RobotMap.Rshooter.getEncVelocity() <= max_right){
    		return RobotMap.Rshooter.get() - 0.0025;
    	}
    	else if(RobotMap.Rshooter.getEncVelocity() != prime_right){
    		if(RobotMap.Rshooter.getEncVelocity() > prime_right){
    			return RobotMap.Rshooter.get() + 0.00015;
    		}
    		else if(RobotMap.Rshooter.getEncVelocity() < prime_right){
    			return RobotMap.Rshooter.get() - 0.00015;
    		}
    	}
    	return RobotMap.Rshooter.get();
    }
    public void set(){
    	RobotMap.Lshooter.set(speedChangeLeft());
    	RobotMap.Rshooter.set(speedChangeRight());
    }
    
}


/*
  if(encoderRate <= min){
  	leftWheel.set() = leftWheel.get() + 0.03;
  }
  else if(encoderRate >= max){
  	leftWheel.set() = leftWheel.get() - 0.02;
  }
  else if(encoderRate <= max && encoderRate >= min && ecnoderRate != prime){
  	if(ecnoderRate < prime){
  		leftWeel.set() = leftWheel.get() + 0.02;
  	}
  	else if(encoderRate > prime){
  		leftWheel.set() = leftWheel.get() -0.01;
  	}
  }
  
  
  at 65%  +16,800 && -17,100
  at 100% +26,900 && -27,100
 
  
 */

