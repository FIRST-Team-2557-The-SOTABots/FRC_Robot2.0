package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LiftAutoCommand extends Command {
	double height;

	public LiftAutoCommand(double encPos) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.LS);
		height = encPos;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		while(-RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() < height){
			Robot.LS.liftInAuto(1.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(-RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() >= height){
			Robot.LS.liftInAuto(0);
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