package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftAutoCommand extends Command {

	double height;
	double speed;
	
    public LiftAutoCommand(double encPos, double speed) {
    	requires(Robot.LS);
    	height = encPos;
    	this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.LiftMotor.getSensorCollection().setQuadraturePosition(0, 1000);
    	SmartDashboard.putBoolean("Here", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() > height) {
    			Robot.LS.LiftAuto(speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition() <= height) {
    		return true;
    	}
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
