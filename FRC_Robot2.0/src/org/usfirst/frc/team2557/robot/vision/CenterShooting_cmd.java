package org.usfirst.frc.team2557.robot.vision;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterShooting_cmd extends Command {

    public CenterShooting_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.vision.findCenterXs2(0) > 197){
    		RobotMap.robotDrive.arcadeDrive(0,-.75);
    		RobotMap._shootBool = false;
    	}
    	else if(Robot.vision.findCenterXs2(0) < 201){
    		RobotMap.robotDrive.arcadeDrive(0,.75);
    		RobotMap._shootBool = false;
    	}
    	else{
    		RobotMap.robotDrive.arcadeDrive(0,0);
    		RobotMap._shootBool = true;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap._shootBool;
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

