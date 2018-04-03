package org.usfirst.frc.team2557.robot.commands.climber;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {

    public ClimbCommand() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.ClimberSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.rightBumper.get()){
    		Robot.ClimberSubsystem.climb(0.8);
    	}else if(OI.leftBumper.get()){
    		Robot.ClimberSubsystem.climb(-0.8);
    	}else{
    		Robot.ClimberSubsystem.climb(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ClimberSubsystem.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
