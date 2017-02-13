package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shooter_cmd extends Command {

    public Shooter_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.gemini){
    		if(Robot.oi.gamepad1.getRawAxis(3) > 0.1){
    			Robot.shooter.shootingActive();
    		}
    		else{
    			Robot.shooter.shootingInactive();
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.gamepad2.getRawAxis(3) > 0.1){
    			Robot.shooter.shootingActive();
    		}
    		else{
    			Robot.shooter.shootingInactive();
    		}
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
