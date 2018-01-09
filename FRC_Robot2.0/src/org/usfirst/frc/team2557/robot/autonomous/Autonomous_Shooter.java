package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Autonomous_Shooter extends TimedCommand {
	
	
	private int _stage;
    public Autonomous_Shooter(double timeout, int stage) {
    	super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_stage = stage;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_stage == 0){
    		RobotMap.agitator.set(.4);
    		RobotMap.Lshooter.set(-.805);
    		RobotMap.Rshooter.set(.755);
    	}
    	else if (_stage == 1){
    		RobotMap.Lshooter.set(-.805);
    		RobotMap.Rshooter.set(.755);
    	}
    	else{
    		RobotMap.Lshooter.set(-.805);
    		RobotMap.Rshooter.set(.755);
    		RobotMap.intake.set(-.695);
    		RobotMap.agitator.set(-.4);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.Lshooter.set(0);
		RobotMap.Rshooter.set(0);
		RobotMap.intake.set(0);
		RobotMap.agitator.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
