package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.BackwardsEncoderDrive;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightSwitchMid extends CommandGroup {

    public RightSwitchMid() {
    	addSequential(new LiftAutoCommand(1000));
		addSequential(new IntakeAutoCommand(0.75, 0.8));
    	addParallel(new LiftAutoCommand(13000));
		addSequential(new MotionProfileCommand(RobotMap.drive1));
		addSequential(new IntakeAutoCommand(1, -0.4));
		
		addParallel(new LiftAutoCommand(250));
		addSequential(new BackwardsEncoderDrive(1.0, 0, -2000.0));
		addSequential(new TurnByAngleCommand(-55));
		addParallel(new IntakeAutoCommand(2, 0.8));
		addSequential(new EncoderDistanceDriveCommand(-0.75, 0, 4000.0));
		
		addParallel(new LiftAutoCommand(13000));
		addSequential(new BackwardsEncoderDrive(1.0, 0, -4000.0));
		addSequential(new TurnByAngleCommand(55));
		addSequential(new WaitForChildren());
		
		addSequential(new EncoderDistanceDriveCommand(-1.0, 0, 2000.0));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
