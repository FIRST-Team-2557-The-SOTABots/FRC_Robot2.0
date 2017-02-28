package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearGrab_autoCmd extends Command {

	boolean _claw;
    public GearGrab_autoCmd(boolean x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_claw = x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_claw){
    		RobotMap.gearGrab.set(Value.kForward);
    	}
    	else if(_claw == false){
    		RobotMap.gearGrab.set(Value.kReverse);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
