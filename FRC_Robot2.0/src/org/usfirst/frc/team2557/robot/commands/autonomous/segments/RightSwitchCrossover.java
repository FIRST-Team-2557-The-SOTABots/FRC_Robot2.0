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
public class RightSwitchCrossover extends CommandGroup {

    public RightSwitchCrossover() {
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addSequential(new MotionProfileCommand(RobotMap.pastSwitch));
		addSequential(new TurnByAngleCommand(90));
		addParallel(new LiftAutoCommand(13000));
		addSequential(new MotionProfileCommand(RobotMap.pastSwitch));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleCommand(90.0));
		addSequential(new MotionProfileCommand(RobotMap.crossover2feet));
		addSequential(new TurnByAngleCommand(90.0));
		addSequential(new MotionProfileCommand(RobotMap.scaleForward2));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
