package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class LeftSwitch extends CommandGroup {

    public LeftSwitch() {
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addParallel(new LiftAutoCommand(13000));
    	addSequential(new MotionProfileCommand(RobotMap.switchForward));
    	addSequential(new WaitForChildren());
		addSequential(new TurnByAngleCommand(90));
		addSequential(new EncoderDistanceDriveCommand(-.6, 0, 1000)); // 3 == 1000
		addSequential(new IntakeAutoCommand(3, -0.2));
    }
}
