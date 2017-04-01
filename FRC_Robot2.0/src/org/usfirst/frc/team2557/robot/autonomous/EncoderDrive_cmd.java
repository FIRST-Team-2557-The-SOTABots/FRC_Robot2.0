package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDrive_cmd extends Command {
	private double _xx, _yy, _encGoal;
    public EncoderDrive_cmd(double x, double y, double encGoal) {
    	_xx = x;
    	_yy = y;
    	_encGoal = encGoal;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(RobotMap.FLdrive.getEncPosition() < _encGoal && RobotMap.BRdrive.getEncPosition() < _encGoal);
    	RobotMap.robotDrive.arcadeDrive(_xx, _yy);
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
