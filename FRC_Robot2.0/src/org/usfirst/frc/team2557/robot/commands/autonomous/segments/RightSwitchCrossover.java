package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightSwitchCrossover extends CommandGroup {

    public RightSwitchCrossover() {
    	addParallel(new LiftAutoInit(false));
		addSequential(new MotionProfileCommand(RobotMap.drive10));
		addSequential(new TurnByAngleMecanumCommand(90));
		addParallel(new LiftAutoCommand(16000));
		addSequential(new MotionProfileCommand(RobotMap.drive11));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleMecanumCommand(90.0));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
