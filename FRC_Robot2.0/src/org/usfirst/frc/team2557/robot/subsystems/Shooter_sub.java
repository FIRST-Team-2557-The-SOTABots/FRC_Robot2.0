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
   		if(Robot.oi.gamepad2.getRawAxis(3) > .1){
   	    	RobotMap.Lshooter.set(-.57);
   	    	RobotMap.Rshooter.set(.57);
   	    	RobotMap.copterAgitator.set(1);
   	    	RobotMap.agitator.set(-.65);
   		}
   		else if(Robot.oi.gamepad2.getRawAxis(2) > .1){
   			RobotMap.copterAgitator.set(-1);
			RobotMap.agitator.set(.8);
			Robot.agitator.leftHopper();
			Robot.agitator.rightHopper();
   		}
   		else{
   			RobotMap.copterAgitator.set(0);
   	    	RobotMap.Lshooter.set(0);
   	    	RobotMap.Rshooter.set(0);
   	    	RobotMap.agitator.set(0);
   		}
    	
    }
   
}

