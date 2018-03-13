package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnByAngle extends Command {
	double angle;

    public TurnByAngle(double angle) {
    	requires(Robot.DriveSubsystem);
    	
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.Gyro1.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SmartDashboard.getBoolean("ConfirmLeft", RobotMap.Confirm);
		SmartDashboard.putNumber("GyroAngleValue", RobotMap.Gyro1.getAngle());

		if(RobotMap.Gyro1.getAngle() > angle) {
			Robot.DriveSubsystem.DiffAutoDriveMethod(0, 1);
		}else if(RobotMap.Gyro1.getAngle() < angle){
			Robot.DriveSubsystem.DiffAutoDriveMethod(0, -1);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(RobotMap.Gyro1.getAngle()-angle) < 5){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSubsystem.DiffAutoDriveMethod(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
