package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Autonomus_Shooter extends TimedCommand {
	
	

    public Autonomus_Shooter(double timeout) {
    	super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.Lshooter.set(-.675);
    	RobotMap.Rshooter.set(.675);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
