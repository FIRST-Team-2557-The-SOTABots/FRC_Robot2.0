package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistanceDrive_cmd extends Command {
	
	public double _distance, _power;
    public DistanceDrive_cmd(double distance, double power){
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_distance = distance;
    	_power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.euler.reset();
//    	RobotMap.navX.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	RobotMap.robotDrive.arcadeDrive(_power, 0);
    	Robot.chassis.driveStraight(_power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.euler.getDistance() > _distance;
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
