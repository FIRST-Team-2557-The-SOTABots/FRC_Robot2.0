package org.usfirst.frc.team2557.robot.commands.drive;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTurn extends Command {
	double angle;
	PIDController pid;
	
	public PIDTurn(double angle){
		this.angle = angle;
		pid = new PIDController(0.0175, 0.000, 0, new PIDSource(){
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
		});
		requires(Robot.DriveSubsystem);
//		pid.setContinuous(true);
		pid.setOutputRange(-1, 1);
		pid.setAbsoluteTolerance(1.0);
	}
	
	protected void initialize(){
		RobotMap.Gyro1.reset();
		pid.reset();
		pid.setSetpoint(angle);
	}
	
	protected void execute(){
		SmartDashboard.putNumber("pid gyro", RobotMap.Gyro1.getAngle());
		pid.enable();
		SmartDashboard.putNumber("pid turn error", pid.getError());
	}

	@Override
	protected boolean isFinished() {
		return pid.onTarget();
	}
	
	protected void end(){
		Robot.DriveSubsystem.DiffDrive(0.0, 0.0);
		pid.disable();
	}
	
	protected void interrupted(){
		this.end();
	}
}
