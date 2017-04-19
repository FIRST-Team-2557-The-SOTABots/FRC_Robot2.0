package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftToggle_autoCmd extends Command {

	private boolean _shift;
    public ShiftToggle_autoCmd(boolean shift) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_shift = shift;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_shift){
    		RobotMap.shifter.set(Value.kReverse);
    	}
    	else{
    		RobotMap.shifter.set(Value.kForward);
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
