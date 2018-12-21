package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class BackwardsEncoderDrive extends Command {
	private double speed;
	private double distance;

    public BackwardsEncoderDrive(double s, double r, double d) {
    	requires(Robot.DriveSubsystem);
    	speed = s;
    	distance = d;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.Gyro1.reset();
    	RobotMap.Left2.setPosition(0);
    	RobotMap.Right2.setPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSubsystem.DiffDrive(speed*0.8, RobotMap.Gyro1.getAngle()*0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((-RobotMap.Left2.getPosition() < distance) && (RobotMap.Right2.getPosition() < distance)) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DiffDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
