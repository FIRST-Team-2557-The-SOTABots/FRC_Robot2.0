package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.BackwardsEncoderDrive;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileTurnCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftSwitchMid extends CommandGroup {

    public LeftSwitchMid() { 
//    	addSequential(new MotionProfileTurnCommand(RobotMap.drive18));
    	
    	addParallel(new LiftAutoCommand(1000));
    	addParallel(new IntakeAutoCommand(0.75, 0.6));
		addSequential(new MotionProfileCommand(RobotMap.drive3));
		addSequential(new TurnByAngleMecanumCommand(-90));
		addParallel(new IntakeAutoCommand(1, 0.2));
		addSequential(new MotionProfileCommand(RobotMap.drive4));
		addSequential(new TurnByAngleMecanumCommand(65));
		addSequential(new LiftAutoCommand(13000));
//		addSequential(new WaitForChildren());
		addSequential(new MotionProfileCommand(RobotMap.drive5));
		addSequential(new IntakeAutoCommand(0.5, -0.4));
		
		addParallel(new LiftAutoCommand(250));
		addSequential(new BackwardsEncoderDrive(1.0, 0, -2000.0));
		addSequential(new TurnByAngleMecanumCommand(60));
		addParallel(new IntakeAutoCommand(2, 0.8));
		addSequential(new EncoderDistanceDriveCommand(-1.0, 0, 4000.0));
		
		addParallel(new LiftAutoCommand(13000));
		addSequential(new BackwardsEncoderDrive(1.0, 0, -7000.0));
		addSequential(new TurnByAngleMecanumCommand(-43));
		addSequential(new WaitForChildren());
		addSequential(new EncoderDistanceDriveCommand(-1.0, 0, 2000.0));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
