package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Agitator_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Agitator_cmd());
    }
    public void passive(){
    	RobotMap.agitator.set(.8);
    }
}

