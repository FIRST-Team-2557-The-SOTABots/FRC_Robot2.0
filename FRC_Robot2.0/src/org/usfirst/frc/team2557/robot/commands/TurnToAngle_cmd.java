package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle_cmd extends Command {

    public TurnToAngle_cmd(double x, double y, double z) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.navX.setAngle(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(RobotMap.navX.getAngle() < z){
    		RobotMap.robotDrive.arcadeDrive(x, y);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(RobotMap.navX.getAngle() >= z){
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
