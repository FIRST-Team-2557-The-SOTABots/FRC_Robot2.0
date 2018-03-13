package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftAutoCommand extends Command {
	PIDController pidcontroller;
	double target;

	public LiftAutoCommand(double target) {
		requires(Robot.LS);
		pidcontroller = new PIDController(0.001, 0.00005, 0.001, new PIDSource(){

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				return -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition();
			}
			
		}, new PIDOutput(){

			@Override
			public void pidWrite(double output) {
				Robot.LS.liftInAuto(output*0.5);
			}
			
		});
		this.target = target;
		
		pidcontroller.setOutputRange(-1, 1);
		pidcontroller.setAbsoluteTolerance(500);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		pidcontroller.reset();
		pidcontroller.setSetpoint(target);
	}
	
	protected void execute(){
		SmartDashboard.putNumber("LiftCommandAuto encoder position", -RobotMap.LiftMotor.getSensorCollection().getQuadraturePosition());
		pidcontroller.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return pidcontroller.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.LS.liftInAuto(0);
		pidcontroller.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}