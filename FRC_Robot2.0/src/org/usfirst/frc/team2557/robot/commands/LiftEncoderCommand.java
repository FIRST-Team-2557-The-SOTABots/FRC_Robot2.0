package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftEncoderCommand extends Command {

    public LiftEncoderCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.LiftMotor.getSensorCollection().setQuadraturePosition(0, 1000);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("EncoderCountLift", RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition()/10);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(-RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition()/10 > 729);
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
