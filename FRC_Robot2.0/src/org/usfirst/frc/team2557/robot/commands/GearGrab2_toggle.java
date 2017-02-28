package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearGrab2_toggle extends Command {

    public GearGrab2_toggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.RB2.get()){
    		RobotMap.pass = false;
    		return;
    	}
    	else if(RobotMap.pass == false && RobotMap.gearSwitch.get()){
    		RobotMap.pass = true;
    		Timer.delay(.5);
    	}
    	else if(RobotMap.gearSwitch.get() && RobotMap.pass){ //switch to false on the comp botx
    		RobotMap.gearGrab.set(Value.kForward);
    		return;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
