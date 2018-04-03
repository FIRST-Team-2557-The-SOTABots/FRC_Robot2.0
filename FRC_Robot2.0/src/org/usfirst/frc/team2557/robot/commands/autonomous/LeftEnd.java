package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LiftAutoInit;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftEnd extends CommandGroup {

    public LeftEnd() {
    	addParallel(new LiftAutoInit(false));
		addSequential(new MotionProfileCommand(RobotMap.drive10));
		addSequential(new TurnByAngleMecanumCommand(100));
//		addParallel(new LiftAutoCommand(37500));
		addSequential(new MotionProfileCommand(RobotMap.drive11));
    }
}
