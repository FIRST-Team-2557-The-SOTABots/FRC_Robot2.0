package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CombinedHumanErrorDriveCommand extends Command {

	public CombinedHumanErrorDriveCommand() {
		requires(Robot.DriveSub1);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//    	Robot.DriveSub1.CombinedHumandErrorDrive();
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward){
			Robot.DriveSub1.MecanumAutoDriveMethod(-OI.Joystick1.getRawAxis(0), OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}else{
			Robot.DriveSub1.DiffAutoDriveMethod(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
		
		if(OI.b1.get()){
			Robot.DriveSub1.MecanumAutoDriveMethod(0, 1, 0);
		}
		else if(OI.x1.get()){
			Robot.DriveSub1.MecanumAutoDriveMethod(0, -1, 0);
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
