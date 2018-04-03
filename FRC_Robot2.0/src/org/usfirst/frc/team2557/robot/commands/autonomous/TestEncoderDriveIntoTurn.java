package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LiftAutoInit;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommandNoStop;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class TestEncoderDriveIntoTurn extends CommandGroup {

	public TestEncoderDriveIntoTurn() {
		//		addParallel(new LiftAutoInit(true));
		addSequential(new EncoderDistanceDriveCommandNoStop(-1, 52500));
		addSequential(new TurnByAngleMecanumCommand(-40));
		//		addSequential(new WaitForChildren());
		addSequential(new IntakeAutoCommand(.5, -0.8));
		//		addParallel(new LiftAutoCommand(250));
		addSequential(new TurnByAngleMecanumCommand(-100.0));
		//		addSequential(new WaitForChildren());
//		addParallel(new IntakeAutoCommand(2.5, 0.9));
		addSequential(new EncoderDistanceDriveCommand(-1, 0, 5000));
		addSequential(new IntakeAutoCommand(2, 0.9));
		//		addSequential(new EncoderDistanceDriveCommand(0,0,0));
		addSequential(new WaitCommand(3));
		//		addParallel(new LiftAutoCommand(37500));
		addSequential(new TurnByAngleMecanumCommand(150.0));
		//		addSequential(new WaitForChildren());
		addSequential(new EncoderDistanceDriveCommand(-1, 0, 3000));
		addSequential(new IntakeAutoCommand(1, -0.8));
	}
}
