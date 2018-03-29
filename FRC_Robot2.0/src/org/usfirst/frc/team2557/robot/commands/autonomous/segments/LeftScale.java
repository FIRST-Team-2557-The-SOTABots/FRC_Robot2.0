package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {

    public LeftScale() {
		addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.9));
		addParallel(new LiftAutoCommand(37500));
		addSequential(new MotionProfileCommand(RobotMap.drive8));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleCommand(45));
		addSequential(new MotionProfileCommand(RobotMap.drive9));
		addSequential(new IntakeAutoCommand(3, -0.8));
    }
}
