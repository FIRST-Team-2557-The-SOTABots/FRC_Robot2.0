package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class MotionProfileTurnCommand extends Command {
	Timer t;
	EncoderFollower followerRight;
	EncoderFollower followerLeft;

	public MotionProfileTurnCommand(Trajectory trajectory) {
		t = new Timer();
		// Use requires() here to declare subsystem dependencies
		requires(Robot.DriveSubsystem);

		// Wheelbase Width = 2ft
		// Do something with the new Trajectories...
		TankModifier modifier = new TankModifier(trajectory).modify(1.875);
//
		this.followerLeft = new EncoderFollower(modifier.getLeftTrajectory());
		this.followerRight = new EncoderFollower(modifier.getRightTrajectory());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
//		followerRight = new EncoderFollower();
//		followerLeft = new EncoderFollower();
		RobotMap.Gyro1.reset();
		t.reset();
		t.start();
		followerLeft.reset();
		followerRight.reset();
		RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
		// max velocity 8.65 ft/s ? and kv = 1/max
		followerLeft.configurePIDVA(1.0, 0, 0, 1.0/8.5, 0);
		followerLeft.configureEncoder(0, 3413, 1.0/3.0);
		followerRight.configurePIDVA(1.0, 0, 0, 1.0/8.5, 0);
		followerRight.configureEncoder(0, 3413, 1.0/3.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double l = followerLeft.calculate(-RobotMap.Left2.getSensorCollection().getQuadraturePosition());
		double r = followerRight.calculate(RobotMap.Right2.getSensorCollection().getQuadraturePosition());

		double gyro_heading = RobotMap.Gyro1.getAngle();   // Assuming the gyro is giving a value in degrees
		double desired_heading = Pathfinder.r2d(followerLeft.getHeading());  // Should also be in degrees

		double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
		double turn = 0.8 * (-1.0/80.0) * angleDifference * 8.0;

		RobotMap.Left1.set(-(l + turn));
		RobotMap.Left2.set(-(l + turn));
		RobotMap.Right1.set(r - turn);
		RobotMap.Right2.set(r - turn);

		//    	Robot.DriveSubsystem.DiffDrive(-powerLeft, RobotMap.Gyro1.getAngle()*0.1);
		SmartDashboard.putNumber("timer motion profile", t.get());
		t.reset();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(followerLeft.isFinished() && followerRight.isFinished()){
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.DriveSubsystem.DiffDrive(0,0);
		RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
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