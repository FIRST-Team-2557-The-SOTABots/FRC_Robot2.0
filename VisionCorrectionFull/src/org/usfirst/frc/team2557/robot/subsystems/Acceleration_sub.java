package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Acceleration_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Units for the X-axis of Acceleration
    public double metersPerSecond2X(){
    	return RobotMap.navX.getRawAccelX() * 9.80665; //Converts G-force into meters pr second squared
    }
    public double feetPerSecond2X(){
    	return RobotMap.navX.getRawAccelX() * 9.80665 * 3.28084; //Converts G-force into feet per second squared
    }
    public double distanceX(){
    	return (feetPerSecond2X() /*time*/)/2;
    	//return (metersPerSecond2X() /*time*/)/2;
    }
    
    //Units for the Y-axis of acceleration
    public double metersPerSecond2Y(){
    	return RobotMap.navX.getRawAccelX() * 9.80665; //Converts G-force into meters pr second squared
    }
    public double feetPerSecond2Y(){
    	return RobotMap.navX.getRawAccelX() * 9.80665 * 3.28084; //Converts G-force into feet per second squared
    }
    public double distanceY(){
    	return (feetPerSecond2Y() /*time*/)/2;
    	//return (metersPerSecond2Y() /*time*/)/2;
    }
    
    
    public void AutonomousTurn(){
    	RobotMap.CAngle = RobotMap.navX.getAngle();
    	
    	

    }
    
}

