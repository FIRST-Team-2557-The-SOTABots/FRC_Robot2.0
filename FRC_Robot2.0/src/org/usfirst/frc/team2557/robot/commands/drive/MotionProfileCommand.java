package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class MotionProfileCommand extends Command {
	Timer t;
	Trajectory trajectory;
	EncoderFollower follower;

    public MotionProfileCommand(Trajectory trajectory) {
    	t = new Timer();
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.DriveSubsystem);
    	
    	// Wheelbase Width = 2ft
        // Do something with the new Trajectories...
        this.trajectory = trajectory;
        
        follower = new EncoderFollower(trajectory);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.Gyro1.reset();
    	t.reset();
    	t.start();
    	follower.reset();
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
    	// max velocity 8.65 ft/s ? and kv = 1/max
    	follower.configurePIDVA(0.075, 0, 0.001, 1.0/8.5, 0.001);
    	follower.configureEncoder(0, 3413, 1.0/3.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double power = follower.calculate(RobotMap.Right2.getSensorCollection().getQuadraturePosition());
    	Robot.DriveSubsystem.DiffDrive(-power, RobotMap.Gyro1.getAngle()*0.1);
    	SmartDashboard.putNumber("timer motion profile", t.get());
    	t.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(follower.isFinished()){
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
    	this.end();
    }
}
