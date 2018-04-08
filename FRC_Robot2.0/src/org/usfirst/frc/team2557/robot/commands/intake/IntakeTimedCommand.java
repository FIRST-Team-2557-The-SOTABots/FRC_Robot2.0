package org.usfirst.frc.team2557.robot.commands.intake;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class IntakeTimedCommand extends TimedCommand {
	double speed;

	public IntakeTimedCommand(double time, double speed) {
		super(time);
		requires(Robot.IntakeSubsystem);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		RobotMap.IntakeR.set(-speed);
		RobotMap.IntakeL.set(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {   
		return isTimedOut();
	}

	// Called once after isFinished returns true
	public void end() {
		RobotMap.IntakeR.set(0);
		RobotMap.IntakeL.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
