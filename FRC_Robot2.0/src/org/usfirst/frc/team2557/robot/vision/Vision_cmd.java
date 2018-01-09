package org.usfirst.frc.team2557.robot.vision;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Vision_cmd extends Command {

    public Vision_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.vision.findCenterXs(0);
    	Robot.vision.findCenterYs(0);
    	Robot.vision.findWidths(0);
    	Robot.vision.findHeights(0);
    	
//    	Robot.vision.findCenterXs(1);
//    	Robot.vision.findCenterYs(1);
//    	Robot.vision.findWidths(1);
//    	Robot.vision.findHeights(1);

//    	Robot.vision.interpretCamera();
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
