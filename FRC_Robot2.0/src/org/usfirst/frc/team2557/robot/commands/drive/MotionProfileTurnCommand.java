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

public class MotionProfileTurnCommand extends Command {
	Timer t;
	EncoderFollower right;
	EncoderFollower left;

    public MotionProfileTurnCommand(Trajectory trajectory) {
    	t = new Timer();
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.DriveSubsystem);
    	
    	// Wheelbase Width = 2ft
        //22" == 1.875'
        TankModifier modifier = new TankModifier(trajectory).modify(1.875);

        // Do something with the new Trajectories...
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.reset();
    	t.start();
    	right.reset();
    	left.reset();
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 10);
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 10);
    	// max velocity 8.65 ft/s and kv = 1/max, ki not used by pathfinder
    	right.configurePIDVA(0.8, 0, 0, 1.0/8.5, 0);
    	left.configurePIDVA(0.8, 0, 0, 1.0/8.5, 0);
    	right.configureEncoder(0, 3413, 1.0/3.0);
    	left.configureEncoder(0, 3413, 1.0/3.0);
    	
    	// talon docs: /* Displaying the two neutral mode options that both the Talon and Victor have */
    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// -l because left encoder inverse
    	double l = -left.calculate(RobotMap.Left2.getSensorCollection().getQuadraturePosition());
    	double r = right.calculate(RobotMap.Right2.getSensorCollection().getQuadraturePosition());

    	double gyro_heading = RobotMap.Gyro1.getAngle();    // Assuming the gyro is giving a value in degrees
    	double desired_heading = Pathfinder.r2d(left.getHeading());  // In degrees, wheels are parallel so only left

    	double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    	double turn = 0.8 * (-1.0/80.0) * angleDifference; // multiplier for turning?

    	RobotMap.Right2.set(r - turn);
    	RobotMap.Right1.set(r - turn);
    	RobotMap.Left1.set(l + turn);
    	RobotMap.Left2.set(l + turn);
    	
    	SmartDashboard.putNumber("timer motion profile", t.get());
    	t.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(right.isFinished() && left.isFinished()){
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
    	
    	RobotMap.Right1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Right2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left1.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.Left2.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    	this.cancel();
    }
}