package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SensorReset_autoCmd extends Command {
	
	private int _reset;
    public SensorReset_autoCmd(int reset) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_reset = reset;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(_reset){
    	case 1:
    		RobotMap.navX.reset();
    	case 2:
    		RobotMap.FLdrive.setEncPosition(0);
    		RobotMap.FRdrive.setEncPosition(0);
    	case 3:
    		RobotMap.navX.reset();
    		RobotMap.FLdrive.setEncPosition(0);
    		RobotMap.FRdrive.setEncPosition(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
