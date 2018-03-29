package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.UselessForward;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UselessForwardSubsystem extends Subsystem {
	
	public void uselessForward(){
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward && OI.dy.get()){
			RobotMap.MecDrive.driveCartesian(0, -1, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse && OI.dy.get()){
			RobotMap.DiffDrive.arcadeDrive(-1, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward && OI.dx.get()){
			RobotMap.MecDrive.driveCartesian(0, -0.3, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse && OI.dx.get()){
			RobotMap.DiffDrive.arcadeDrive(-0.5, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward && OI.backButton.get()){
			RobotMap.MecDrive.driveCartesian(0, 1, 0);
		}else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse && OI.backButton.get()){
			RobotMap.DiffDrive.arcadeDrive(1, 0);
		}
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new UselessForward());
    }
}

