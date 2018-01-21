package org.usfirst.frc.team2557.robot.commands;

import static org.usfirst.frc.team2557.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;

public class tractionTest extends Command {
	
	public void TractionDrive() {
		requires(chassis);
	}

	protected void defaultDrive() {
		chassis.retractFront();
		chassis.retractRear();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}