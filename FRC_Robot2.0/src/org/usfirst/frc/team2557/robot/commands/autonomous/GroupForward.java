package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

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
		addSequential(new TurnByAngleCommand(90));
		addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500)); // 3 == 1000
//		addSequential(new IntakeAutoCommand(1, -0.4));
	}
}

