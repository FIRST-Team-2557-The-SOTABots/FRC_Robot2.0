package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDrive_cmd extends Command {
	private double _encGoalLeft, _encGoalRight, _power;
	private boolean _forward;
    public EncoderDrive_cmd(double encGoalLeft, double encGoalRight, boolean forward, double power) {
    	_power = power;
    	_encGoalLeft = encGoalLeft;
    	_encGoalRight = encGoalRight;
    	_forward = forward;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.FLdrive.setEncPosition(0);
    	RobotMap.BRdrive.setEncPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_forward){
    		while(RobotMap.FLdrive.getEncPosition() <= _encGoalLeft && -RobotMap.BRdrive.getEncPosition() <= _encGoalRight);
    		Robot.chassis.driveStraight(-_power);
    	}
    	if(_forward == false){
    		while(RobotMap.FLdrive.getEncPosition() >= _encGoalLeft && -RobotMap.BRdrive.getEncPosition() >= _encGoalRight);
    		Robot.chassis.driveStraight(-_power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveStraight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
