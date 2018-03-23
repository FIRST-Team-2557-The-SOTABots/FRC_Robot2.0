package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftSwitchMid extends CommandGroup {

    public LeftSwitchMid() { 
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addSequential(new MotionProfileCommand(RobotMap.drive3));
		addSequential(new TurnByAngleCommand(-90));
		addSequential(new MotionProfileCommand(RobotMap.drive4));
		addParallel(new LiftAutoCommand(13000));
		addSequential(new TurnByAngleCommand(90));
		addSequential(new WaitForChildren());
		addSequential(new MotionProfileCommand(RobotMap.drive5));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
