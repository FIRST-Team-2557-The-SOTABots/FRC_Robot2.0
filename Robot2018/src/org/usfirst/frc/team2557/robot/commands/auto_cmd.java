package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class auto_cmd extends Command {
	Timer Time;
	boolean turn;
	double speed;
	double Timeout;

	public auto_cmd(double timeout, double s, boolean turn) {
		//	super(timeout);
		turn = true;
		speed = s;
		Time = new Timer();
		Timeout = timeout;


	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Time", Timeout);
		if(turn) {
			RobotMap.robotDrive.arcadeDrive(0, speed);

		}
		else if(turn == false) {
			RobotMap.robotDrive.arcadeDrive(speed, 0);
		}
		

	}

	// Make this return true when this Command no longer needs to run execute()
	// Called once after isFinished returns true
	protected void end() {
		RobotMap.robotDrive.arcadeDrive(0, 0);
	}

	protected boolean isFinished() {
		if(Time.get() >= Timeout) {
			return true;
		} 
		else {
			return false;
		}
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
