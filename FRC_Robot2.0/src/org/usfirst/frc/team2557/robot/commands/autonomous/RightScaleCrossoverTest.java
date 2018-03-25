package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileTurnCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class RightScaleCrossoverTest extends CommandGroup {

    public RightScaleCrossoverTest() {
    	addSequential(new LiftAutoCommand(750));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
//		addParallel(new LiftAutoCommand(7500));
		addParallel(new LiftAutoCommand(37500));
//		addParallel(new IntakeAutoCommand(10, 0.7));
		addSequential(new MotionProfileTurnCommand(RobotMap.trajectory));
//		addParallel(new IntakeAutoCommand(0.25, 0.4));
//		addSequential(new MotionProfileCommand(RobotMap.drive12));
		addSequential(new WaitForChildren());
//		addSequential(new TurnByAngleCommand(-90.0));
//		addSequential(new MotionProfileCommand(RobotMap.drive13));
//		addSequential(new TurnByAngleCommand(10.0));
//		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
