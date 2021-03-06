package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.BackwardsEncoderDrive;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeTimedCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightScale extends CommandGroup {
	
    public RightScale() {
    	addParallel(new LiftAutoInit(true));
		addSequential(new MotionProfileCommand(RobotMap.drive8));
		addSequential(new WaitForChildren());
		addParallel(new IntakeAutoCommand(1, 0.2));
		addSequential(new TurnByAngleMecanumCommand(-50));
//		addSequential(new MotionProfileCommand(RobotMap.drive9));
		addSequential(new WaitCommand(1));
		addSequential(new EncoderDistanceDriveCommand(-1, 0, 1250));
		addSequential(new IntakeAutoCommand(.5, -0.3));
		addSequential(new BackwardsEncoderDrive(1, 0, 3000));

//		addParallel(new LiftAutoCommand(250));
//		addSequential(new TurnByAngleMecanumCommand(-70.0));
//		addSequential(new WaitForChildren());
//		addParallel(new IntakeTimedCommand(2.5, 0.6));
//		addSequential(new EncoderDistanceDriveCommand(-1, 0, 8000));
////		addSequential(new IntakeAutoCommand(2, 0.9));
//		addSequential(new WaitCommand(2));
//		addParallel(new LiftAutoCommand(37500));
//		addSequential(new TurnByAngleMecanumCommand(110.0));
//		addSequential(new WaitForChildren());
//		addSequential(new EncoderDistanceDriveCommand(-1, 0, 4000));
//		addSequential(new IntakeAutoCommand(1, -0.3));
    }
}
