package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BrakingCommand extends Command {

	boolean brake;

	public BrakingCommand(boolean brake) {
		this.brake = brake;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putBoolean("brake", brake);
		
//		if(brake) {
//			RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//			RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//			RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//			RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
//		}else {
//			RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//			RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//			RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//			RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
//		RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
//		RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
//		RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
	}
}
