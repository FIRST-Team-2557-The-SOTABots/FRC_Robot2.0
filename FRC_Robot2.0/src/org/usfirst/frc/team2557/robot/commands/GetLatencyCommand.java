package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GetLatencyCommand extends Command {

    public GetLatencyCommand() {
    	SmartDashboard.putString("gotToClass", "Class!");
    	//requires(Robot.getLatency);
    	SmartDashboard.putString("GotPastRequires", "Requires!");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Got to init", "Init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.getLatency.getDriverStation();
    	Robot.getLatency.logMemory();
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
