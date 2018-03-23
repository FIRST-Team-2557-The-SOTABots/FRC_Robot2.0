package org.usfirst.frc.team2557.robot.commands.solenoid;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidAutoCommand extends Command {
	boolean change = false;

    public SolenoidAutoCommand() {
    	requires(Robot.SolenoidSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	RobotMap.DS1.set(Value.kReverse);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
    		RobotMap.DS1.set(DoubleSolenoid.Value.kReverse);
    		change = true;
    	}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse) {
    		RobotMap.DS1.set(DoubleSolenoid.Value.kForward);
    		change = true;
    	}
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(change == true) {
        	return true;
        }else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.cancel();
    }
}
