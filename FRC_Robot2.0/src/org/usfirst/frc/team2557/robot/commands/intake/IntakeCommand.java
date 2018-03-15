package org.usfirst.frc.team2557.robot.commands.intake;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeCommand extends Command {
	
    public IntakeCommand() {
    	requires(Robot.IntakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.S1.set(false);
    	RobotMap.S2.set(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double axisRight = OI.Joystick2.getRawAxis(3);
		
		double axisLeft = OI.Joystick2.getRawAxis(2);
    	
		if(OI.IntakeIn.get()) {
			RobotMap.IntakeR.set(-.8);
			RobotMap.IntakeL.set(.8);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
			//			RobotMap.S2.set(false);
		}else if(axisLeft > 0.8){
			RobotMap.IntakeR.set(-.3);
			RobotMap.IntakeL.set(.3);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
		}else if(OI.IntakeOut.get()){
			RobotMap.IntakeR.set(.4);
			RobotMap.IntakeL.set(-.4);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
			//			RobotMap.S2.set(true);
		}else if(axisRight > 0.8){
			RobotMap.IntakeR.set(.15);
			RobotMap.IntakeL.set(-.15);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
		}else {
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
			RobotMap.S2.set(true);
			RobotMap.S1.set(false);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.IntakeR.set(0);
		RobotMap.IntakeL.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    this.end();
    }
}
