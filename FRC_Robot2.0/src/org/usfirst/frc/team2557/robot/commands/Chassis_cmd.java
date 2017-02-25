package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Controller;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Chassis_cmd extends Command {


	
	
    public Chassis_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONSTART)
    			&& Robot.oi.getGamepad(0).getButtonEnabled(Controller.BUTTONSELECT)){
    		RobotMap.gemini = false;
    	} else if(Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONSTART)
    			&& Robot.oi.getGamepad(1).getButtonEnabled(Controller.BUTTONSELECT)){
    		RobotMap.gemini = true;
    	}
    	Robot.chassis.arcadeDrive();
    	Robot.chassis.shift_non();
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
