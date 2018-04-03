package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {

    public LeftScale() {
    	addParallel(new LiftAutoInit(true));
		addSequential(new MotionProfileCommand(RobotMap.drive8));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleMecanumCommand(50));
		addSequential(new MotionProfileCommand(RobotMap.drive9));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
