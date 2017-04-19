package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedDrive extends TimedCommand {

	boolean _turn;
	double _speed;
    public TimedDrive(double timeout, boolean turn, double speed) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        _turn = turn;
        _speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_turn){
    		RobotMap.robotDrive.arcadeDrive(0,_speed);
    	}
    	else if(_turn == false){
    		RobotMap.robotDrive.arcadeDrive(_speed, 0);
    	}
    }

    // Called once after timeout
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
