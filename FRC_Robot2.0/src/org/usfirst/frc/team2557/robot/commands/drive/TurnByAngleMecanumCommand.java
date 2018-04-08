package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class TurnByAngleMecanumCommand extends Command {
	double angle;

    public TurnByAngleMecanumCommand(double angle) {
    	requires(Robot.DriveSubsystem);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.DS1.set(Value.kForward);
    	RobotMap.Gyro1.reset();
    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(RobotMap.Gyro1.getAngle() > angle) {
			Robot.DriveSubsystem.MecanumDrive(0, 0, .6);
		}else if(RobotMap.Gyro1.getAngle() < angle){
			Robot.DriveSubsystem.MecanumDrive(0, 0, -.6);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(RobotMap.Gyro1.getAngle()-angle) < 2.0){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DS1.set(Value.kReverse);
    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	Robot.DriveSubsystem.DiffDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	this.end();
    }
}
