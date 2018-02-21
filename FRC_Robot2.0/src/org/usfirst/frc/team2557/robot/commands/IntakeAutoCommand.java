package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeAutoCommand extends Command {

    public IntakeAutoCommand() {
    	requires(Robot.LS);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		RobotMap.S1.set(true);
		RobotMap.S1.set(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.LS.IntakeAutoMethod();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(RobotMap.LiftConfirm == true) {
    	return true;	
    	}
    else {
    	return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
