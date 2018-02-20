package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class OuttakeAutoCommand extends Command {
	Timer t;

    public OuttakeAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.S1.set(false);
    	RobotMap.S2.set(true);
    	t.reset();
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.IntakeR.set(.4);
		RobotMap.IntakeL.set(-.4);
		RobotMap.S2.set(false);
		RobotMap.S1.set(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(t.get() >= 1.0){
    		RobotMap.S1.set(false);
        	RobotMap.S2.set(true);
    		return true;
    	}
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
