package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCmd extends Command {
	
	double[] speed;
	double[] angle;
	double[] rotation;
	double[] rightEncoder;
	double[] leftEncoder;
	double[] gyro;
	Timer t;

    public DriveCmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSub1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.start();
    	speed = new double[20000];
    	angle = new double[20000];
    	rotation = new double[20000];
    	rightEncoder = new double[20000];
    	leftEncoder = new double[20000];
    	gyro = new double[20000];
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = OI.Joystick1.getRawAxis(0);
    	double y = OI.Joystick1.getRawAxis(1);
    	double power = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    	Robot.DriveSub1.recordDataDrive(power, OI.Joystick1.getDirectionDegrees(), OI.Joystick1.getRawAxis(4));
//    	t.get();
    	SmartDashboard.putNumber("the time", t.get());
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
