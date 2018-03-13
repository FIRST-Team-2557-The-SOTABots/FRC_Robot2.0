package org.usfirst.frc.team2557.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;
import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	public void MecanumAutoDriveMethod(double yspeed, double xspeed, double zrotation) {
		RobotMap.MecDrive.driveCartesian(yspeed, xspeed, zrotation);
	}

	public void DiffAutoDriveMethod(double speed, double rotation) {
		RobotMap.DiffDrive.arcadeDrive(speed, rotation);
	}

	public void HumanErrorTraction() {
		if((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) > 0) &&
				((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) < -.5))
				|| (Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) > 0) &&
				((Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) < -.5))){
			double AverageSpeed = ((OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2);

			RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
		}
		else {
			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
	}

	public void HumanErrorMecanumMethod() {
		if(OI.Joystick1.getRawAxis(0) > .8 || OI.Joystick1.getRawAxis(0) < -.8) {
			RobotMap.MecDrive.driveCartesian(OI.Joystick1.getRawAxis(0), 0, 0);
		}
		else if(OI.Joystick1.getRawAxis(1) > .8 || OI.Joystick1.getRawAxis(1) < -.8) {
			RobotMap.MecDrive.driveCartesian(0, OI.Joystick1.getRawAxis(1), 0);
		}
		else if(-OI.Joystick1.getRawAxis(4) > .8 || -OI.Joystick1.getRawAxis(4) < -.8) {
			RobotMap.MecDrive.driveCartesian(0, 0, -OI.Joystick1.getRawAxis(4));
		}
		else {
			RobotMap.MecDrive.driveCartesian(-OI.Joystick1.getRawAxis(0), OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
	}

	public void CombinedHumandErrorDrive() {
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
			if( (OI.Joystick1.getRawAxis(0) > .8 || OI.Joystick1.getRawAxis(0) < -.8) && ( Math.abs(-OI.Joystick1.getRawAxis(4)) >.5) /*&& ( (Math.abs(OI.Joystick1.getRawAxis(1)) != 1) || (Math.abs(OI.Joystick1.getRawAxis(0)) != 1) ) */ ){
				RobotMap.MecDrive.driveCartesian(-OI.Joystick1.getRawAxis(0), 0, 0);
			}

			else if( (OI.Joystick1.getRawAxis(1) > .8 || OI.Joystick1.getRawAxis(1) < -.8) && ( Math.abs(-OI.Joystick1.getRawAxis(4)) >.5) /*&& ( (Math.abs(OI.Joystick1.getRawAxis(1)) != 1) || (Math.abs(OI.Joystick1.getRawAxis(0)) != 1) )*/ ){
				RobotMap.MecDrive.driveCartesian(0, -OI.Joystick1.getRawAxis(1), 0);
			}
			else if( (-OI.Joystick1.getRawAxis(4) > .8 || -OI.Joystick1.getRawAxis(4) < -.8 ) && ( Math.abs(OI.Joystick1.getRawAxis(0)) >.5) && ( Math.abs(OI.Joystick1.getRawAxis(1)) >.5)/* && ( (Math.abs(OI.Joystick1.getRawAxis(1)) != 1) || (Math.abs(OI.Joystick1.getRawAxis(0)) != 1) )*/ ){
				RobotMap.MecDrive.driveCartesian(0, 0, -OI.Joystick1.getRawAxis(4));
			}
			else {
				RobotMap.MecDrive.driveCartesian(OI.Joystick1.getRawAxis(0), -OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
			}
		}

		else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse) {

			if( (OI.Joystick1.getRawAxis(0) > .8 || OI.Joystick1.getRawAxis(0) < -.8) && ( Math.abs(-OI.Joystick1.getRawAxis(4)) >.5) /*&& ( (Math.abs(OI.Joystick1.getRawAxis(1)) != 1) || (Math.abs(OI.Joystick1.getRawAxis(0)) != 1) ) */ ){
				RobotMap.MecDrive.driveCartesian(-OI.Joystick1.getRawAxis(0), 0, 0);
			}
			else if( (-OI.Joystick1.getRawAxis(4) > .8 || -OI.Joystick1.getRawAxis(4) < -.8 ) && ( Math.abs(OI.Joystick1.getRawAxis(0)) >.5) && ( Math.abs(OI.Joystick1.getRawAxis(1)) >.5)/* && ( (Math.abs(OI.Joystick1.getRawAxis(1)) != 1) || (Math.abs(OI.Joystick1.getRawAxis(0)) != 1) )*/ ){
				RobotMap.MecDrive.driveCartesian(0, 0, -OI.Joystick1.getRawAxis(4));
			}

		}
		else {
			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
	}

	public void TeleDriveMethod() {

		//		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse) {
		//			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		//		}
		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
			RobotMap.MecDrive.driveCartesian(-OI.Joystick1.getRawAxis(0), OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
		else {
			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
		}
	}

	public void CorrectStrafe(){
		if( ((OI.Joystick1.getDirectionDegrees() >= RobotMap.Gyro1.getAngle() + 10) )/* && ( (OI.Joystick1.getDirectionDegrees() != 0 + .1) && (OI.Joystick1.getDirectionDegrees() != 0 - .1) ) */
				||  ((OI.Joystick1.getDirectionDegrees() <= RobotMap.Gyro1.getAngle() - 10) )/* && ( (OI.Joystick1.getDirectionDegrees() != 0 + .1) && (OI.Joystick1.getDirectionDegrees() != 0 - .1) )*/ ){

			if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
				if( ((OI.Joystick1.getRawAxis(1) < -.5 ) && (-OI.Joystick1.getRawAxis(4) > .5)) && ( (Math.abs(OI.Joystick1.getRawAxis(1)) < .9) && (Math.abs(-OI.Joystick1.getRawAxis(4)) < .9)) &&
						(	((RobotMap.Gyro1.getAngle() >= 95 ) && (RobotMap.Gyro1.getAngle() <= 85)) || ((RobotMap.Gyro1.getAngle() <= -95) || (RobotMap.Gyro1.getAngle() >= -85)) || ((RobotMap.Gyro1.getAngle()
								<= 175) && (RobotMap.Gyro1.getAngle() >= -175)) || ((RobotMap.Gyro1.getAngle() <= -5) && RobotMap.Gyro1.getAngle() >= 5) ) ){
					RobotMap.DiffDrive.arcadeDrive(-.8, .8);
				}
				else if( ((-OI.Joystick1.getRawAxis(4) < -.5 ) && (OI.Joystick1.getRawAxis(1) > .5)) && ( (Math.abs(OI.Joystick1.getRawAxis(1)) < .9) || (Math.abs(-OI.Joystick1.getRawAxis(4)) < .9)) &&
						(	((RobotMap.Gyro1.getAngle() >= 95 ) && (RobotMap.Gyro1.getAngle() <= 85)) || ((RobotMap.Gyro1.getAngle() <= -95) || (RobotMap.Gyro1.getAngle() >= -85)) || ((RobotMap.Gyro1.getAngle()
								<= 175) && (RobotMap.Gyro1.getAngle() >= -175)) || ((RobotMap.Gyro1.getAngle() <= -5) && RobotMap.Gyro1.getAngle() >= 5) ) ){
					RobotMap.DiffDrive.arcadeDrive(.8, -.8);
				}
				else if( (Math.abs(OI.Joystick1.getRawAxis(1)) > .9 ) || (Math.abs(-OI.Joystick1.getRawAxis(4)) > .9 ) ) {

					if((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) > 0) &&
							((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) < -.5))
							|| (Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) > 0) &&
							((Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) < -.5))){
						double AverageSpeed = ((OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2) ;
						RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
					}
					else {
						RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
					}	
				}
			}
		}
		else {
			if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {

				if(OI.Joystick1.getRawAxis(0) > .8 || OI.Joystick1.getRawAxis(0) < -.8) {
					RobotMap.MecDrive.driveCartesian(-OI.Joystick1.getRawAxis(0), 0, 0);
				}
				else if(OI.Joystick1.getRawAxis(1) > .8 || OI.Joystick1.getRawAxis(1) < -.8) {
					RobotMap.MecDrive.driveCartesian(0, OI.Joystick1.getRawAxis(1), 0);
				}
				else if(-OI.Joystick1.getRawAxis(4) > .8 || -OI.Joystick1.getRawAxis(4) < -.8) {
					RobotMap.MecDrive.driveCartesian(0, 0, -OI.Joystick1.getRawAxis(4));
				}
				else {
					RobotMap.MecDrive.driveCartesian(OI.Joystick1.getRawAxis(0), OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
				}
			}

			else if(RobotMap.DS1.get() == DoubleSolenoid.Value.kReverse) {

				if((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) > 0) &&
						((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) < -.5))
						|| (Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) > 0) &&
						((Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) < -.5))){
					double AverageSpeed = ((OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2) ;
					RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
				}
				else {
					RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
				}
			}
		}

	}

	double e1 = RobotMap.Left2.getSensorCollection().getQuadratureVelocity();
	double e2 = RobotMap.Right2.getSensorCollection().getQuadratureVelocity();

	public void MecanumStrafeControl() {

		if(RobotMap.DS1.get() == DoubleSolenoid.Value.kForward) {
			ArrayList<Double> MecanumVelocity = new ArrayList<Double>();
			double ea1 = Math.abs(e1);
			double ea2 = Math.abs(e2);

			if(ea1 != 1) {
				MecanumVelocity.add(ea1);
			}
			if(ea2 != 1) {
				MecanumVelocity.add(ea2);
			}

			double MV = Collections.max(MecanumVelocity);

			if(ea1 + (ea2/100) < MV) {
				RobotMap.Left2.set(MV);
			}

			if(ea2 + (ea1/100) < MV) {
				RobotMap.Right2.set(MV);
			}

			RobotMap.Left1.set(e2);
			RobotMap.Right1.set(e1);

		}
	}

	public void Control() {

		ArrayList<Double> EncoderVelocity = new ArrayList<Double>();
		double ea1 = Math.abs(e1);
		double ea2 = Math.abs(e2);

		if(Math.abs(RobotMap.Left1.get()) - .05 != Math.abs(RobotMap.Right1.get() -.05)) {

			if((OI.Joystick1.getRawAxis(1) > .8) || (OI.Joystick1.getRawAxis(1) < -.8)) {
				if(ea1 != 1) {
					EncoderVelocity.add(ea1);
				}
				if(ea2 != 1) {
					EncoderVelocity.add(ea2);
				}

				double emax = Collections.max(EncoderVelocity);

				if(ea1 + (ea2/100) < emax) {
					RobotMap.Left2.set(emax);
				}
				else {
					RobotMap.Left2.set(e1);
				}
				if(ea2 + (ea1/100) < emax) {
					RobotMap.Right2.set(emax);
				}
				else {
					RobotMap.Right2.set(e2);
				}

				RobotMap.Left1.set(emax);
				RobotMap.Right1.set(emax);
			}
			else {
				RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1) , -OI.Joystick1.getRawAxis(4));
			}
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

