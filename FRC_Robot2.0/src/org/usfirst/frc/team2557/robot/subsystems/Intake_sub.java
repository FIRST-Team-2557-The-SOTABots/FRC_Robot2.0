package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Intake_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Intake_cmd());
    }
    
    public void intake(){

    		if(Robot.oi.RB2.get()){
    			RobotMap.intake.set(-.4);
    		}
    		else if(Robot.oi.LB2.get()){
    			RobotMap.intake.set(.6);
    		}
    		else{
    			RobotMap.intake.set(0);
    		}
    	
    }
    
    
}

