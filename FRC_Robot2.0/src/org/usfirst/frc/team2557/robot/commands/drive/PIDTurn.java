package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTurn extends Command {
	double angle;
	PIDController pid;
	boolean mec;

	public PIDTurn(double angle){
		this.setTimeout(2.0);
		this.angle = angle;
		pid = new PIDController(0.04, 0.00, 0.00, new PIDSource(){
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				return RobotMap.Gyro1.getAngle();
			}
		}, new PIDOutput(){
			@Override
			public void pidWrite(double output) {
				Robot.DriveSubsystem.DiffDrive(0, -output);
				SmartDashboard.putNumber("output for pid turn", -output);
			}
		}, 0.02);
		requires(Robot.DriveSubsystem);
		//		pid.setContinuous(true);
		pid.setOutputRange(-0.7, 0.7);
		pid.setAbsoluteTolerance(2.0);
	}

	protected void initialize(){
		RobotMap.Gyro1.reset();
		pid.reset();
		pid.setSetpoint(angle);
		pid.enable();
	}

	protected void execute(){
		if(RobotMap.DS1.get() == Value.kReverse){
			RobotMap.DS1.set(Value.kForward);
		}
		SmartDashboard.putNumber("pid gyro", RobotMap.Gyro1.getAngle());
		SmartDashboard.putNumber("pid turn error", pid.getError());
	}

	@Override
	protected boolean isFinished() {
		if(pid.onTarget() || this.isTimedOut()){
			System.out.format("error on turn: %6.3f\n", pid.getError());
			return true;
		}
		return false;
	}

	protected void end(){
		if(RobotMap.DS1.get() == Value.kForward){
			RobotMap.DS1.set(Value.kReverse);
		}
		Robot.DriveSubsystem.DiffDrive(0.0, 0.0);
		pid.disable();
	}

	protected void interrupted(){
		pid.disable();
		this.end();
	}
}
