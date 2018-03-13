package org.usfirst.frc.team2557.robot.commands.drive;

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
		requires(Robot.DriveSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//    	Robot.DriveSub1.CombinedHumandErrorDrive();

		double upL = -OI.Joystick1.getRawAxis(0);
		double sideL = OI.Joystick1.getRawAxis(1);
		double sideR = -OI.Joystick1.getRawAxis(4);
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward){
			RobotMap.MecDrive.driveCartesian(upL, sideL, sideR);
		}else{
			RobotMap.DiffDrive.arcadeDrive(sideL, sideR);
			//			Robot.DriveSub1.DiffAutoDriveMethod(-OI.Joystick1.getRawAxis(0), -OI.Joystick1.getRawAxis(4));
		}
		
		
//		double powerAmount = 0.2;
//		
//		if((upL < powerAmount && sideL < powerAmount && sideR < powerAmount) && (upL > -powerAmount && sideL > -powerAmount && sideR > -powerAmount)){
//			int amps = 0;
//			RobotMap.Right1.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Right2.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Left1.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Left2.configContinuousCurrentLimit(amps, timeout);
////		}
//		}else{
//			int amps = 40;
//			RobotMap.Right1.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Right2.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Left1.configContinuousCurrentLimit(amps, timeout);
//			RobotMap.Left2.configContinuousCurrentLimit(amps, timeout);
//		}
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
