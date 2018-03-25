package org.usfirst.frc.team2557.robot.commands.intake;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {
	
    public IntakeCommand() {
    	requires(Robot.IntakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.S1.set(false);
    	RobotMap.S2.set(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.IntakeSubsystem.IntakeWithButtons();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.IntakeR.set(0);
		RobotMap.IntakeL.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    this.end();
    }
}