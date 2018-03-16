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
	Trajectory left;
	Trajectory right;
	EncoderFollower rightFollower;
	EncoderFollower leftFollower;

    public MotionProfileCommand(Trajectory trajectory) {
    	t = new Timer();
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.DriveSubsystem);
    	
    	// Wheelbase Width = 2ft
        TankModifier modifier = new TankModifier(trajectory).modify(0.572);

        // Do something with the new Trajectories...
        left = modifier.getLeftTrajectory();
        right = modifier.getRightTrajectory();
        
        rightFollower = new EncoderFollower(right);
        leftFollower = new EncoderFollower(left);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.reset();
    	t.start();
    	rightFollower.reset();
    	leftFollower.reset();
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
    	// max velocity 8.65 ft/s and kv = 1/max
    	rightFollower.configurePIDVA(0.8, 0, 0, 1.0/8.65, 0);
    	leftFollower.configurePIDVA(0.8, 0, 0, 1.0/8.65, 0);
    	rightFollower.configureEncoder(0, 3413, 1.0/3.0);
    	leftFollower.configureEncoder(0, 3413, 1.0/3.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rightPower = rightFollower.calculate(RobotMap.Right2.getSensorCollection().getQuadraturePosition());
    	double leftPower = leftFollower.calculate(-RobotMap.Left2.getSensorCollection().getQuadraturePosition());
    	RobotMap.Right2.set(rightPower);
    	RobotMap.Right1.set(rightPower);
    	RobotMap.Left1.set(-leftPower);
    	RobotMap.Left2.set(-leftPower);
    	SmartDashboard.putNumber("timer motion profile", t.get());
    	t.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(rightFollower.isFinished() && leftFollower.isFinished()){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.Right2.set(0);
    	RobotMap.Right1.set(0);
    	RobotMap.Left1.set(0);
    	RobotMap.Left2.set(0);
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
