package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class WingCommandLeft extends Command {
	boolean done;

	public WingCommandLeft() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
//		SmartDashboard.putNumber("got to", 2);
		done = false;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
//		SmartDashboard.putNumber("got to", 3);
//		if(OI.rightBumper.get() == true){
//			RobotMap.rightWing.setAngle(-90.0);
//		}
		if(OI.leftBumper.get()){
//			RobotMap.leftWing.setAngle(90.0);
			RobotMap.leftWing.setPosition(0.5);
			done = true;
//			SmartDashboard.putNumber("got to 2", 4);
		}
//		if(OI.rightWingPiston.get() == true){
//			RobotMap.a.set(true);
//			RobotMap.b.set(true);
//		}
//		}else{
//			RobotMap.a.set(false);
//			RobotMap.b.set(false);
//		}
		
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
//		if(RobotMap.leftWing.getAngle() == 90.0){
//			return true;
//		}
		if(done){
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