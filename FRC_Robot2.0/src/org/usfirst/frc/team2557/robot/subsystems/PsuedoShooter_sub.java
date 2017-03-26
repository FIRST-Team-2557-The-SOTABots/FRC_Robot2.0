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
	public final double leftMAX = 269;
	public final double leftMIN = 168;
	
	public final double rightMAX = -271;
	public final double rightMIN = -171;
	
	public final double lower_left 	= 168.00;
	public final double upper_left 	= 215.20;
	public final double prime_left 	= 191.60;
	
	public final double lower_right 	= -171.00;
	public final double upper_right 	= -216.80;
	public final double prime_right = -193.90;
   

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new PsuedoShooter_cmd());
    }
   
    public double speedChangeLeft(){
    	
    	if(RobotMap.Lshooter.getEncVelocity() <= -getLowerL(71)){
    		return RobotMap.Lshooter.get() - 0.025;
    	}
    	else if(RobotMap.Lshooter.getEncVelocity() >= -getUpperL(79)){
    		return RobotMap.Lshooter.get() + 0.005;
    	}
    	else if(RobotMap.Lshooter.getEncVelocity() != -getPrimeL(75)){
    		if(-getPrimeL(75) < prime_left){
    			return RobotMap.Lshooter.get() - 0.0025;
    		}
    		else if(RobotMap.Lshooter.getEncVelocity() > -getPrimeL(75)){
    			return RobotMap.Lshooter.get() + 0.0015;
    		}
    	}
    	return RobotMap.Lshooter.get();
    }
    public double speedChangeRight(){
    	
    	if( RobotMap.Rshooter.getEncVelocity() <= getLowerR(71)){
    		return RobotMap.Rshooter.get() + 0.025;
    	}
    	else if(RobotMap.Rshooter.getEncVelocity() >= getUpperR(79)){
    		return RobotMap.Rshooter.get() - 0.005;
    	}
    	else if(RobotMap.Rshooter.getEncVelocity() != getPrimeR(75)){
    		if(RobotMap.Rshooter.getEncVelocity() < getPrimeR(75)){
    			return RobotMap.Rshooter.get() + 0.0025;
    		}
    		else if(RobotMap.Rshooter.getEncVelocity() > getPrimeR(75)){
    			return RobotMap.Rshooter.get() - 0.0015;
    		}
    	}
    	return RobotMap.Rshooter.get();
    }
    public double getPrimeL(double _percent){
    	return (leftMAX * _percent) * 100;
    }
    public double getPrimeR(double _percent){
    	return (rightMAX * _percent) * 100;
    }
    public double getLowerL(double _percent){
    	return (leftMAX * _percent) * 100;
    }
    public double getLowerR(double _percent){
    	return (rightMAX * _percent) * 100;
    }
    public double getUpperL(double _percent){
    	return (leftMAX * _percent) * 100;
    }
    public double getUpperR(double _percent){
    	return (rightMAX * _percent) * 100;
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
  
  
  at 65%  +168.00 && -171.00
  at 100% +269.00 && -271.00
 
  
 */

