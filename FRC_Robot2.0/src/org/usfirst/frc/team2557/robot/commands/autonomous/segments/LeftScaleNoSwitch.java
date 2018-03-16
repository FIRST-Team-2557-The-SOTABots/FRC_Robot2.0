package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class LeftScaleNoSwitch extends CommandGroup {

    public LeftScaleNoSwitch() {
		addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addParallel(new LiftAutoCommand(37500));
		addSequential(new MotionProfileCommand(RobotMap.scaleForward));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleCommand(45));
		addSequential(new MotionProfileCommand(RobotMap.scaleForward2));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
