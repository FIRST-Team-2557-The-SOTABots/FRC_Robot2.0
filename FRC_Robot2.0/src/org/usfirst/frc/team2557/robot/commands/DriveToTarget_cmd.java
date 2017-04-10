package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.vision.VisionArray_sub;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTarget_cmd extends Command {

    public DriveToTarget_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.oi.y1.get()){
    	while(VisionArray_sub.areas[0] < 160){
    	RobotMap.robotDrive.arcadeDrive(0, 1);
    	}
    	while(VisionArray_sub.areas[0] > 170){
    		RobotMap.robotDrive.arcadeDrive(0, -.5);
    	}
    	while(VisionArray_sub.widths[0] < 35){
    		RobotMap.robotDrive.arcadeDrive(.5, 0);
    	}
    	while(VisionArray_sub.widths[0] > 45){
    		RobotMap.robotDrive.arcadeDrive(-.5, 0);
    	}
    	if(VisionArray_sub.widths[0] >= 35 && VisionArray_sub.widths[0] <= 45 && VisionArray_sub.areas[0] >= 160 && VisionArray_sub.areas[0] <= 170){
    		RobotMap.robotDrive.arcadeDrive(0, 0);
    	}
    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
