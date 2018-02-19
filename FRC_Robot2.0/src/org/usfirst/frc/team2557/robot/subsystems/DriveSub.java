package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.DriveCmd;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSub extends Subsystem{
	public void initDefaultCommand() {
//		setDefaultCommand(new DriveCmd());
	}
	
	public void mecDrive(double power, double directionDegrees, double rawAxis) {
		RobotMap.mecDrive.drivePolar(power, directionDegrees, rawAxis);
	}
}
