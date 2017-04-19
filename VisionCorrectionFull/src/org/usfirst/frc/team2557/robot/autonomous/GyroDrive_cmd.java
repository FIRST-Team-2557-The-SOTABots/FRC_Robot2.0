package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroDrive_cmd extends Command {

	public double _turn, _angle;
    public GyroDrive_cmd(double angle, double turn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_angle = angle;
    	_turn = turn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	RobotMap.navX.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.robotDrive.arcadeDrive(0,_turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.navX.getAngle() >_angle - 5 && RobotMap.navX.getAngle() < _angle + 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0,0);
//    	RobotMap.euler.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
