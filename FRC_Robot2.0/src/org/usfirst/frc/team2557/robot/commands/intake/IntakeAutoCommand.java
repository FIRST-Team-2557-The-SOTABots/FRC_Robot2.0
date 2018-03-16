package org.usfirst.frc.team2557.robot.commands.intake;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeAutoCommand extends Command {
	Timer t;
	double time;
	double speed;

    public IntakeAutoCommand(double time, double speed) {
    	requires(Robot.IntakeSubsystem);
    	
    	this.time = time;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	RobotMap.S1.set(false);
//    	RobotMap.S2.set(true);
    	t = new Timer();
    	t.reset();
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.IntakeR.set(-speed);
		RobotMap.IntakeL.set(speed);
//		RobotMap.S2.set(false);
//		RobotMap.S1.set(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(t.get() >= time){
//    		RobotMap.S1.set(false);
//        	RobotMap.S2.set(true);
    		return true;
    	}
    else {
    	return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.IntakeR.set(0);
		RobotMap.IntakeL.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
