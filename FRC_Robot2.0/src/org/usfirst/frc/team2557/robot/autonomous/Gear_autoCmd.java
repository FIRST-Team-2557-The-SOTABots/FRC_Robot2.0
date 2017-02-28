package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Gear_autoCmd extends Command {

	double _speed, _position, _upperThreshold, _lowerThreshold;
    public Gear_autoCmd(double x, double a, double y) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_position = x;
    	_upperThreshold = x + a;
    	_lowerThreshold = x - a;
    	_speed = y;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.gearMotor.set(_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return RobotMap.gearEnc.get() < _upperThreshold && RobotMap.gearEnc.get() > _lowerThreshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.gearMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
