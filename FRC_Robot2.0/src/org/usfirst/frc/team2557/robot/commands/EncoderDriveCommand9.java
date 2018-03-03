package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderDriveCommand9 extends Command {
	
	private double speed;
	private double rotation;

    public EncoderDriveCommand9(double s, double r) {
    	requires(Robot.DriveSub1);
    	speed = s;
    	rotation = r;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 1000);
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 1000);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("EncoderCountLeft", RobotMap.Left2.getSensorCollection().getQuadraturePosition()/10);
    	SmartDashboard.putNumber("EncoderCountRight", RobotMap.Right2.getSensorCollection().getQuadraturePosition()/10);
    	Robot.DriveSub1.AutoDriveMethod(speed, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((-RobotMap.Left2.getSensorCollection().getQuadraturePosition()/10 > 9571) && (RobotMap.Right2.getSensorCollection().getQuadraturePosition()/10 > 9671)) {
//    		the "> 100" values are just placeholders for now, they're supposed to be however long 11 and 2/3 feet is. It is used for getting to the switch,
//    		not the scale, which is going to use a different command. There will probably be a sensor to get the colour of the two things, so updates are
//    		expected.
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DiffDrive.arcadeDrive(0, 0);
    	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 1000);
    	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 1000);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
