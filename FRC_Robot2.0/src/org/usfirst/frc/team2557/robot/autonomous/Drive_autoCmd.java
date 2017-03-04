package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_autoCmd extends Command {
	

	double _required, _speed, _upperThreshold, _lowerThreshold;
	boolean _rotate;
	//x is for how far in feet you want to travel
	// a is for the threshold above and below x
	//y is for how fast you want to drive
	// z is true means you are trying to turn, false means you want to drive straight
	
	Timer timer;
    public Drive_autoCmd(double x, double a, double y, boolean z) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_required = x;
    	_upperThreshold = x + a;
    	_lowerThreshold = x - a;
    	_speed = y;
    	_rotate = z;
    	
    
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_rotate){
    		RobotMap.robotDrive.arcadeDrive(0,_speed);
    	}
    	else if(_rotate == false){
    		RobotMap.robotDrive.arcadeDrive(_speed,0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(_rotate == false){
    		return Robot.accel.feetPerSecond2X() * timer.get() > _required;
    	}
    	else{
    		return RobotMap.navX.getAngle() < _upperThreshold && RobotMap.navX.getAngle() > _lowerThreshold;
    	}
        //return Robot.accel.feetPerSecond2Y() * timer.get() > _required;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
