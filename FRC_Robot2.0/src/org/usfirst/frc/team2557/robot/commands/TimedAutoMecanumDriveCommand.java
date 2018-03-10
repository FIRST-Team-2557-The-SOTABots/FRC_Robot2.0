package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TimedAutoMecanumDriveCommand extends Command {

	private double yspeed;
	private double xspeed;
	private double zrotation;
	private Timer timer;
	private double time;
	
    public TimedAutoMecanumDriveCommand(double ys, double xs, double zr, double t) {
    	requires(Robot.DriveSub1);
    	
    	timer = new Timer();

    	yspeed = ys;
    	xspeed = xs;
    	zrotation = zr;
    	time = t;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Time passed", timer.get());
    	Robot.DriveSub1.MecanumAutoDriveMethod(yspeed, xspeed, zrotation);
//    	Robot.MDriveSub.EncoderRegualtionMethod();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get() >= time) {
    		return true;
    	}
    	else{
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
