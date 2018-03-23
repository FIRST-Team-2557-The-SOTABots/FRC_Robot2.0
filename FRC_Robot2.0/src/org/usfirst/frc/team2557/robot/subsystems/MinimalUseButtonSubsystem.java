package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MinimalUseButtonCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MinimalUseButtonSubsystem extends Subsystem {

	public void minimalUseButtons(){
		double triggerRight = OI.Joystick1.getRawAxis(2);
		double triggerLeft = OI.Joystick1.getRawAxis(3);
		SmartDashboard.putNumber("Right!", triggerRight);
		SmartDashboard.putNumber("Left!", triggerLeft);

		if(triggerRight > 0.8){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(1, 0, 0);
		}else if(triggerLeft > 0.8){
			RobotMap.DS1.set(Value.kForward);
			RobotMap.MecDrive.driveCartesian(-1, 0, 0);
		}
		else{
			RobotMap.DS1.set(Value.kReverse);	
		}
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MinimalUseButtonCommand());
	}
}

