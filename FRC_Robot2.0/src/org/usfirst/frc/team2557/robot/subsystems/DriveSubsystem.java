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

	public void DriveTurnRight(){
		if(RobotMap.Gyro1.getAngle() < 80) {
			RobotMap.DiffDrive.arcadeDrive(0, -.8);
			RobotMap.Confirm = false;
		}
		else if(RobotMap.Gyro1.getAngle() >= 80) {
			RobotMap.DiffDrive.arcadeDrive(0, 0);
			RobotMap.Confirm = true;
		}
	}

	public void DriveTurnLeft() {
		RobotMap.GyroAngle = RobotMap.Gyro1.getAngle();
		double Angle = RobotMap.GyroAngle;

		if(Angle > -80) {
			RobotMap.DiffDrive.arcadeDrive(0, .8);
			RobotMap.Confirm = false;
		}
		else if(Angle <= -80) {
			RobotMap.DiffDrive.arcadeDrive(0, 0);
			RobotMap.Confirm = true;
		}
	}

	public void HumanErrorTraction() {
		//  	if((OI.Joystick1.getRawAxis(1) - -OI.Joystick1.getRawAxis(4) > -.1) 
		//		|| (-OI.Joystick1.getRawAxis(4) - OI.Joystick1.getRawAxis(1) > -.1)
		//		|| (OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4) < .1) 
		//		|| (-OI.Joystick1.getRawAxis(4) + OI.Joystick1.getRawAxis(1) < .1)){  		
		//
		//		double AverageSpeed = (OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2;
		//
		// 		RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
		//  }

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

		//		if(/*(OI.Joystick1.getRawAxis(0) < .1 && -OI.Joystick1.getRawAxis(4) < .1) ||*/ OI.Joystick1.getRawAxis(1) > .1 && -OI.Joystick1.getRawAxis(4) > .1) {
		//			double AverageSpeed = (OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2;
		//			
		//			RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
		//			
		//		}
		//		else if(/*OI.Joystick1.getRawAxis(0) > -.1 && -OI.Joystick1.getRawAxis(4) > -.1 ||*/ OI.Joystick1.getRawAxis(1) < -.1 && -OI.Joystick1.getRawAxis(4) < -.1) {
		//			double AverageSpeed = (OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2;
		//			
		//			RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
		//		}
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
		//			if((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) > 0) &&
		//					((Math.abs(OI.Joystick1.getRawAxis(1)) - Math.abs(-OI.Joystick1.getRawAxis(4)) < -.5))
		//					|| (Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) > 0) &&
		//					((Math.abs(-OI.Joystick1.getRawAxis(4)) - Math.abs(OI.Joystick1.getRawAxis(1)) < -.5))){
		//				double AverageSpeed = ((OI.Joystick1.getRawAxis(1) + -OI.Joystick1.getRawAxis(4)) / 2) ;
		//				RobotMap.DiffDrive.arcadeDrive(AverageSpeed, AverageSpeed);
		//				SmartDashboard.putNumber("average speed", AverageSpeed);
		//			}
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
		//RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));

		RobotMap.GyroAngle = RobotMap.Gyro1.getAngle();

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




				//			if((Math.abs(OI.Joystick1.getDirectionDegrees())) > Math.abs(RobotMap.Gyro1.getAngle())){
				//			RobotMap.DiffDrive.arcadeDrive(-.8, .8);
				//			}
				//			else{
				//				RobotMap.DiffDrive.arcadeDrive(.8, -.8);
				//			}
				//		}

				//		if(OI.Joystick1.getDirectionDegrees() >= RobotMap.Gyro1.getAngle() + 5){
				//			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4) - 0.01);
				//			System.out.println("Here");
				//			SmartDashboard.putNumber("directionDegrees", OI.Joystick1.getDirectionDegrees());
				//		}
				//		else if(OI.Joystick1.getDirectionDegrees() <= RobotMap.Gyro1.getAngle() - 5) {
				//			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4) + 0.01);
				//		}
				//		else{
				//			RobotMap.DiffDrive.arcadeDrive(OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
				//			SmartDashboard.putNumber("directionDegreesStandard", OI.Joystick1.getDirectionDegrees());
				//		}

				//		
				//		if(Math.abs(RobotMap.Left2.get() + 5) > Math.abs(RobotMap.Right1.get() + 5) ){
				//			System.out.println("here");
				//			SmartDashboard.putNumber("encoderVelocityLeft", RobotMap.Left2.getSensorCollection().getQuadratureVelocity());
				//			RobotMap.Right1.set(RobotMap.Left2.get());
				//		}
				//		else if( ( Math.abs(RobotMap.Left2.get()) + 5 < Math.abs(RobotMap.Right1.get()) + 5) /*&& ( Math.abs(RobotMap.Left2.get()) > .1 && (Math.abs(RobotMap.Left2.get()) < .1)*/ ) {
				//			RobotMap.Left2.set(RobotMap.Right1.get());
				//			SmartDashboard.putNumber("encoderVelocityRight", RobotMap.Right1.getSensorCollection().getQuadratureVelocity());
				//			System.out.println("No. Here.");
				//		}
				//		
				//		if(Math.abs(RobotMap.Right1.get()) + 5 > Math.abs(RobotMap.Left2.get()) + 5){
				//			RobotMap.Left2.set(RobotMap.Right1.get());
				//			System.out.println("There");
				//		}
				//		else if( ( Math.abs(RobotMap.Right1.get()) + 5 < Math.abs(RobotMap.Left2.get()) + 5 ) /*&& ( Math.abs(RobotMap.Right1.get()) > .1 && (Math.abs(RobotMap.Right1.get()) < .1)*/  ){
				//			RobotMap.Right1.set(RobotMap.Left2.get());
				//			System.out.println("No. There.");
				//		}
				//		else {
				//		RobotMap.MecDrive.driveCartesian(OI.Joystick1.getRawAxis(0), OI.Joystick1.getRawAxis(1), -OI.Joystick1.getRawAxis(4));
				//		}
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
	//		double a = RobotMap.Left1.getBusVoltage();
	//		double b = RobotMap.Left2.getBusVoltage();
	//		double c = RobotMap.Right1.getBusVoltage();
	//		double d = RobotMap.Right2.getBusVoltage();

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

	//			double e = Math.abs(a);
	//			double f = Math.abs(b);
	//			double g = Math.abs(c);
	//			double h = Math.abs(d);		
	//		ArrayList<Double> VoltageValues = new ArrayList<Double>();
	//			if(OI.Joystick1.getRawAxis(0) > 0) {
	//				double v = Collections.max(VoltageValues);
	//				
	//				VoltageValues.add(e);
	//				VoltageValues.add(f);
	//				VoltageValues.add(g);
	//				VoltageValues.add(h);
	//				
	//				if(e < v) {
	//					RobotMap.Left1.set(RobotMap.Left1.get() - .01);
	//				}
	//				if(f < v) {
	//					RobotMap.Left2.set(RobotMap.Left2.get() + .01);
	//				}
	//				if(g < v) {
	//					RobotMap.Right1.set(RobotMap.Right1.get() - .01);
	//				}
	//				if(h < v) {
	//					RobotMap.Right2.set(RobotMap.Right2.get() + .01);
	//				}
	//				SmartDashboard.putNumber("VoltageL1", RobotMap.Left1.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageL2", RobotMap.Left2.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageR1", RobotMap.Right1.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageR2", RobotMap.Right2.getBusVoltage());
	//			}
	//			else if(OI.Joystick1.getRawAxis(0) < 0) {
	//				double v = Collections.max(VoltageValues);
	//				
	//				VoltageValues.add(e);
	//				VoltageValues.add(f);
	//				VoltageValues.add(g);
	//				VoltageValues.add(h);
	//				
	//				if(e < v) {
	//					RobotMap.Left1.set(RobotMap.Left1.get() + .01);
	//				}
	//				if(f < v) {
	//					RobotMap.Left2.set(RobotMap.Left2.get() - .01);
	//				}
	//				if(g < v) {
	//					RobotMap.Right1.set(RobotMap.Right1.get() + .01);
	//				}
	//				if(h < v) {
	//					RobotMap.Right2.set(RobotMap.Right2.get() - .01);
	//				}
	//				SmartDashboard.putNumber("VoltageL1", RobotMap.Left1.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageL2", RobotMap.Left2.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageR1", RobotMap.Right1.getBusVoltage());
	//				SmartDashboard.putNumber("VoltageR2", RobotMap.Right2.getBusVoltage());
	//			}		
	//		VoltageValues.add(a);
	//		VoltageValues.add(b);
	//		VoltageValues.add(c);
	//		VoltageValues.add(d);
	//		
	//		double v = Collections.max(VoltageValues);
	//		
	//		if(a < v) {
	//			RobotMap.Left1.set(RobotMap.Left1.get() + .01);
	//		}
	//		if(b < v) {
	//			RobotMap.Left2.set(RobotMap.Left2.get() + .01);
	//		}
	//		if(c < v) {
	//			RobotMap.Right1.set(RobotMap.Right1.get() + .01);
	//		}
	//		if(b < v) {
	//			RobotMap.Right2.set(RobotMap.Right2.get() + .01);
	//		}
	//	}
	//		
	//	
	//	double a = RobotMap.Left1.getSensorCollection().getQuadratureVelocity();
	//	double b = RobotMap.Left2.getSensorCollection().getQuadratureVelocity();
	//	double c = RobotMap.Right1.getSensorCollection().getQuadratureVelocity();
	//	double d = RobotMap.Right2.getSensorCollection().getQuadratureVelocity();
	//	public void EncoderRegualtionMethod() {
	//	
	//		
	//		ArrayList<Double> EncoderArray = new ArrayList<Double>();
	//		if(a != (1 &-1)) {
	//		EncoderArray.add(a);
	//		}
	//		else if(b != (1 & -1)) {
	//		EncoderArray.add(b);
	//		}
	//		else if(c != (1 & -1)) {
	//		EncoderArray.add(c);
	//		}
	//		else if(d != (1 & -1)) {
	//			EncoderArray.add(d);
	//		}
	//		double e = Collections.max(EncoderArray);
	//		
	//		if(RobotMap.Left1.get() != e) {
	//			RobotMap.Left1.set(e);
	//		}
	//		if(RobotMap.Left2.get() != e){
	//			RobotMap.Left2.set(e);
	//		}
	//		if(RobotMap.Right1.get() != e){
	//			RobotMap.Right1.set(e);
	//		}
	//		if(RobotMap.Right2.get() != e){
	//			RobotMap.Right2.set(e);
	//		}
	////		else if(EncoderArray(1) == (1 & -1)) {
	////			double e = EncoderArray(1);
	////		}
	////		else if(EncoderArray(2) == (1 & -1)) {
	////			double e = EncoderArray(2);
	////		}
	////		else if(EncoderArray(3) == (1 & -1)) {
	////			double e = EncoderArray(3);
	////		}
	//		else {
	//			EncoderRegualtionMethod();
	//		}
	//		
	//	}
	//	
	//    private int EncoderArray(int i) {
	//		// TODO Auto-generated method stub
	//		return 0;
	//	}


	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

