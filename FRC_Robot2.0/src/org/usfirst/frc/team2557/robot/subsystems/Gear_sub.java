package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {	
    	}
    public void gearGrab(){
    	if(RobotMap.gearGrab.get()==Value.kReverse){
    		RobotMap.gearGrab.set(Value.kForward);
    	}
    	else if(RobotMap.gearGrab.get()==Value.kForward){
    		RobotMap.gearGrab.set(Value.kReverse);
    	}
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
