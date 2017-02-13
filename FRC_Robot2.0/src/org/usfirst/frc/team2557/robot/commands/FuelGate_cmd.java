package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelGate_cmd extends Command {

    public FuelGate_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.gemini){
    		if(Robot.oi.LB1.get()){
    			RobotMap.pistonUpDown.set(Value.kForward);
    		}
    		else{
    			RobotMap.pistonUpDown.set(Value.kReverse);
    		}
    	}
    	else if(RobotMap.gemini == false){
    		if(Robot.oi.LB2.get()){
    			RobotMap.pistonUpDown.set(Value.kForward);
    		}
    		else{
    			RobotMap.pistonUpDown.set(Value.kReverse);
    		}
    	}
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
