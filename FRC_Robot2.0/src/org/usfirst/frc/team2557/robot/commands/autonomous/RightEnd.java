package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightEnd extends CommandGroup {

    public RightEnd() {
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addSequential(new MotionProfileCommand(RobotMap.pastSwitch));
		addSequential(new TurnByAngleCommand(-90));
//		addParallel(new LiftAutoCommand(37500));
		addSequential(new MotionProfileCommand(RobotMap.crossoverSwitch));
    }
}
