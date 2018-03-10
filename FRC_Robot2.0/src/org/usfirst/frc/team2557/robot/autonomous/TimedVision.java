package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedVision extends TimedCommand {

    public TimedVision(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.vision.averageInterpretation(2, 0, 0, 221, 0, .02) == false){
			if(Robot.vision.findCenterXs(0) < 221){
				RobotMap.robotDrive.arcadeDrive(-.8,-.5);
			}
			else if(Robot.vision.findCenterXs(0) > 221){
				RobotMap.robotDrive.arcadeDrive(-.8,.5);
			}
			else{
				RobotMap.robotDrive.arcadeDrive(0,0);
			}
		}
		else{
			RobotMap.robotDrive.arcadeDrive(-.8,0);
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