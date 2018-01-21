package org.usfirst.frc.team2557.robot.commands;

import static org.usfirst.frc.team2557.robot.Robot.*;

import javax.swing.AbstractButton;

import org.usfirst.frc.team2557.robot.subsystems.Chassis_sub;

public class omniTest extends AbstractButton {
	
	public void OmniDrive() {
		requires(chassis);
	}

	private void requires(Chassis_sub chassis) {
		// TODO Auto-generated method stub
		
	}

	protected void defaultDrive() {
		chassis.deployFront();
		chassis.deployRear();
	}
}
