package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Wings_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Wings_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void out() {
    	RobotMap.leftWing.set(90);
    	RobotMap.rightWing.set(90);
    }
    public void in() {
    	RobotMap.leftWing.set(0);
    	RobotMap.rightWing.set(0);
    }
}

