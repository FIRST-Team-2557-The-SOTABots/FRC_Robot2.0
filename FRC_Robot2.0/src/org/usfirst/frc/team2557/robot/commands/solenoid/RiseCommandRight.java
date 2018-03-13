package org.usfirst.frc.team2557.robot.commands.solenoid;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RiseCommandRight extends Command {
	boolean go;
	boolean dir;

    public RiseCommandRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	go = false;
    	dir = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.rightTrigger.get()){
			go = true;
			dir = !dir;
		}
    	
    	if(go && !dir){
    		RobotMap.a.set(true);
			RobotMap.b.set(false);
    	}else if(go && dir){
    		RobotMap.b.set(true);
			RobotMap.a.set(false);
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
