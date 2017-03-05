package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Auto_Shooter2 extends TimedCommand {

    public Auto_Shooter2(double timeout) {
    	super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.Lshooter.set(-.675);
    	RobotMap.Rshooter.set(.675);
    	RobotMap.copterAgitator.set(1);
    	RobotMap.agitator.set(-.65);
    	RobotMap.intake.set(.65);
    }

    // Called once after isFinished returns true
    protected void end() {
	    RobotMap.Lshooter.set(0);
	    RobotMap.Rshooter.set(0);
		RobotMap.copterAgitator.set(0);
		RobotMap.agitator.set(0);
		RobotMap.intake.set(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
