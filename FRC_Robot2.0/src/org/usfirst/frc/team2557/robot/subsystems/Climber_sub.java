package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Climber_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Climber_cmd());
    }

    public void climb(){
	    	if((Robot.oi.LJ2.get() && Robot.oi.RJ2.get()) || (Robot.oi.LJ1.get() && Robot.oi.RJ1.get())){
	        	RobotMap.climber.set(1);
	    	}
	    	else if(Math.abs(Robot.oi.gamepad2.getRawAxis(1)) > 0.1){
	    		RobotMap.climber.set(Math.abs(Robot.oi.gamepad2.getRawAxis(1)));
	    	}
	    	else{
	        	RobotMap.climber.set(0);
	    	}
    }
}

