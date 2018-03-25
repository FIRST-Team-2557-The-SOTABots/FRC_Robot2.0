package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.TeleDriveCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	public void MecanumDrive(double yspeed, double xspeed, double zrotation) {
		RobotMap.MecDrive.driveCartesian(yspeed, xspeed, zrotation);
	}

	public void DiffDrive(double speed, double rotation) {
		RobotMap.DiffDrive.arcadeDrive(speed, rotation);
	}

	public void TeleDriveMethod() {
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
			MecanumDrive(-OI.Joystick1.getRawAxis(0)*0.9, OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
		else {
			DiffDrive(OI.Joystick1.getRawAxis(1)*0.9, -OI.Joystick1.getRawAxis(4)*0.9);
		}
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleDriveCommand());
	}
}

