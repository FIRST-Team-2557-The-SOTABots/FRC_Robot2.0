package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderDriveCommand2 extends Command {
	
	private double speed;
	private double rotation;

    public EncoderDriveCommand2(double s, double r) {
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
    	SmartDashboard.getNumber("EncoderCountLeft", RobotMap.Left2.getSensorCollection().getQuadraturePosition()/10);
    	SmartDashboard.getNumber("EncoderCountRight", RobotMap.Right2.getSensorCollection().getQuadraturePosition()/10);
    	Robot.DriveSub1.DiffAutoDriveMethod(speed, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((-RobotMap.Left2.getSensorCollection().getQuadraturePosition()/10 > 6100) && (RobotMap.Right2.getSensorCollection().getQuadraturePosition()/10 > 6200)) {
//    		the "> 100" values are just placeholders for now, they're supposed to be however long 121.47 inches is. It is used after the switch to get to
//    		the place next to the scale. There will probably be a sensor to get the colour of the two things, so updates are expected.
    		RobotMap.DiffDrive.arcadeDrive(0, 0);
        	RobotMap.Left2.getSensorCollection().setQuadraturePosition(0, 1000);
        	RobotMap.Right2.getSensorCollection().setQuadraturePosition(0, 1000);
    		return true;
    	}
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
