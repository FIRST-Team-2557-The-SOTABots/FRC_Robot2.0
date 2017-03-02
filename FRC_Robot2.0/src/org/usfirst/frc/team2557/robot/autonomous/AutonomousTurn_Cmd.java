package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousTurn_Cmd extends Command {
	double ChanceTR;
	
    public AutonomousTurn_Cmd(double x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	ChanceTR = x;
    }
    


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(RobotMap.CAngle > 90){
    		RobotMap.robotDrive.arcadeDrive(ChanceTR, 0);
    	}
    		
    	
    	
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
