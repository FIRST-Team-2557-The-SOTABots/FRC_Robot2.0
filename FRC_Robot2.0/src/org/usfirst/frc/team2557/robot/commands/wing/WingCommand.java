package org.usfirst.frc.team2557.robot.commands.wing;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**r
 *
 */
public class WingCommand extends Command {

	public WingCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(OI.rightBumper.get() == true){
			RobotMap.rightWing.setAngle(-90.0);
		}
//		if(OI.leftBumper.get() == true){
//			RobotMap.leftWing.setAngle(90.0);
//		}
//		if(OI.rightWingPiston.get() == true){
//			RobotMap.a.set(true);
//			RobotMap.b.set(true);
//		}
//		}else{
//			RobotMap.a.set(false);
//			RobotMap.b.set(false);
//		}
//		if(OI.leftWingPiston.get() == true){
//			RobotMap.c.set(true);
//			RobotMap.d.set(true);
//		}
//		}else{
//			RobotMap.c.set(false);
//			RobotMap.d.set(false);
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(RobotMap.rightWing.getAngle() == -90.0){
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
