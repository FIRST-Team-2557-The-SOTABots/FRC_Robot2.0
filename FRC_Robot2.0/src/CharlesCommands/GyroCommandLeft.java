package CharlesCommands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroCommandLeft extends Command {

    public GyroCommandLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSub1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.Gyro1.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	SmartDashboard.putNumber("GyroAngleValue", RobotMap.GyroAngle);
    	Robot.DriveSub1.DriveTurnLeft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
			if(RobotMap.Confirm == true){
				return true;
			}
	else{
		return false;
	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
