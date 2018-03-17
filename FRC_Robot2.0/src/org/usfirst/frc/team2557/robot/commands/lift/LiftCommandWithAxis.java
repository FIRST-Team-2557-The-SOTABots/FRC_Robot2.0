package org.usfirst.frc.team2557.robot.commands.lift;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommandWithAxis extends Command {

    public LiftCommandWithAxis() {
    	requires(Robot.LiftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	double value;
//    	if(RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition()<=100 && RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition()>37500){
    		Robot.LiftSubsystem.LiftWithAxis();
//    	}
//    	value = OI.Joystick2.getY();
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
