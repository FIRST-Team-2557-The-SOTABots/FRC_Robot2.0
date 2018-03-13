package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupForward extends CommandGroup {

	public GroupForward() {
		addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.25, 0.6));
		addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2500)); // 2 == 2800
//		addParallel(new LiftAutoCommand(12000));
		addSequential(new TurnByAngle(90));
		addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500)); // 3 == 1000
//		addSequential(new IntakeAutoCommand(1, -0.4));
	}
}

