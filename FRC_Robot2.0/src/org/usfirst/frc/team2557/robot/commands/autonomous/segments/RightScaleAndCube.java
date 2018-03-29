package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileTurnCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftScaleInitAuto;
import org.usfirst.frc.team2557.robot.commands.solenoid.SolenoidAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class RightScaleAndCube extends CommandGroup {

    public RightScaleAndCube() {
    	addParallel(new LiftScaleInitAuto());
		addSequential(new MotionProfileCommand(RobotMap.drive8));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleMecanumCommand(-35.0));
		addSequential(new EncoderDistanceDriveCommand(.8, 0, -3000));

//		addSequential(new MotionProfileCommand(RobotMap.drive9));
		
    	addSequential(new IntakeAutoCommand(.5, -0.8));
		
    	addSequential(new TurnByAngleMecanumCommand(-100.0));
		addSequential(new LiftAutoCommand(250));
//		addSequential(new WaitForChildren());
		addParallel(new IntakeAutoCommand(1, 0.9));
		addSequential(new MotionProfileCommand(RobotMap.drive15));
		addSequential(new WaitCommand(0.25));
		addSequential(new LiftAutoCommand(2000));
		addParallel(new LiftAutoCommand(37500));
		addSequential(new TurnByAngleMecanumCommand(125.0));
		addSequential(new WaitForChildren());
		addSequential(new MotionProfileCommand(RobotMap.drive16));
//		addSequential(new EncoderDistanceDriveCommand(0.8, 0, 4.0));
		addSequential(new IntakeAutoCommand(1, -0.8));
    }
}