package org.usfirst.frc.team2557.robot.commands.solenoid;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidAutoCommand extends Command {

    public SolenoidAutoCommand() {
    	requires(Robot.SolSub);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	RobotMap.DS1.set(Value.kReverse);
    }
    
    boolean Change = false;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
    		RobotMap.DS1.set(DoubleSolenoid.Value.kReverse);
    		Change = true;
    	}
    	else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse) {
    		RobotMap.DS1.set(DoubleSolenoid.Value.kForward);
    		Change = true;
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Change == true) {
        	return true;
        }
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
