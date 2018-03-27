package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeIncrementally extends Command {
	Timer t;
	double intaketime;
	double speed;
	double interval;
	int maxcount;
	int count;

	public IntakeIncrementally(double interval, double intaketime, double speed, int maxcount) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.IntakeSubsystem);
		t = new Timer();
		this.interval = interval;
		this.intaketime = intaketime;
		this.speed = speed;
		this.maxcount = maxcount;
		count = 0;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		t = new Timer();
		t.reset();
		t.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(t.get() >= interval + intaketime){
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
			t.reset();
			count++;
		}else if(t.get()>= interval){
			RobotMap.IntakeR.set(-speed);
			RobotMap.IntakeL.set(speed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(count >= maxcount){
			return true;
		}
		return false;
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
