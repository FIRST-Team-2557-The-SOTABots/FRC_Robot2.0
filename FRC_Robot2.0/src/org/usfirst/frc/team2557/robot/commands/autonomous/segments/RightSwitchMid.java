package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.BackwardsEncoderDrive;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleSpeed;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightSwitchMid extends CommandGroup {

    public RightSwitchMid() {
    	addParallel(new LiftAutoInit(false));
		addSequential(new MotionProfileCommand(RobotMap.drive1));
		addSequential(new IntakeAutoCommand(0.5, -0.4));
		
		addSequential(new BackwardsEncoderDrive(1.0, 0, -2000.0));
		addParallel(new LiftAutoCommand(250));
		addSequential(new TurnByAngleMecanumCommand(-60));
//		addSequential(new WaitChildren());
		addParallel(new IntakeAutoCommand(3, 0.8));
		addSequential(new EncoderDistanceDriveCommand(-0.75, 0, 4500.0));
		
		addParallel(new LiftAutoCommand(13000));
		addSequential(new BackwardsEncoderDrive(1.0, 0, -7000.0));
		addSequential(new TurnByAngleMecanumCommand(33));
		addSequential(new WaitForChildren());
		
		addSequential(new EncoderDistanceDriveCommand(-1.0, 0, 3000.0));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
