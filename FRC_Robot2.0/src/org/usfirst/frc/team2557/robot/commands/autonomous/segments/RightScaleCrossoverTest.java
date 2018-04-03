package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileTurnCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class RightScaleCrossoverTest extends CommandGroup {

    public RightScaleCrossoverTest() {
    	addParallel(new LiftAutoInit(false));
		addSequential(new MotionProfileTurnCommand(RobotMap.trajectory));
		
		addParallel(new LiftAutoCommand(38000));
		addSequential(new TurnByAngleCommand(-100.0));
		addSequential(new WaitForChildren());
		
		addSequential(new MotionProfileCommand(RobotMap.drive14));
//		addSequential(new TurnByAngleCommand(-5.0));
		addSequential(new IntakeAutoCommand(3, -0.8));
    }
}
