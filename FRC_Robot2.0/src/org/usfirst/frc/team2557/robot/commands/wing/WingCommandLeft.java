package org.usfirst.frc.team2557.robot.commands.wing;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**r
 *
 */
public class WingCommandLeft extends Command {
	boolean done;

	public WingCommandLeft() {
//		requires(Robot.WingSubsystem);
		done = false;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
//		SmartDashboard.putBoolean("done wings left", done);
		if(OI.leftBumper.get()){
				RobotMap.leftWing.setPosition(0.5);
				done = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
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