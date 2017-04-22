package org.usfirst.frc.team2557.robot.vision;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSwitcherSub extends Subsystem {
	public void switchCamera(){
		if(Robot.oi.a2.get() == true){
    		RobotMap.cameraMode = true;
    	}
    	else if(Robot.oi.a2.get() == false){
    		RobotMap.cameraMode = false;
    	}
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

