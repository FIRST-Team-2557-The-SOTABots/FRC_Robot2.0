package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleMecanumCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftSwitch extends CommandGroup {

    public LeftSwitch() {
    	addParallel(new LiftAutoInit(false));
    	addSequential(new MotionProfileCommand(RobotMap.drive6));
    	addSequential(new WaitForChildren());
    	addParallel(new IntakeAutoCommand(1, 0.2));
		addSequential(new TurnByAngleMecanumCommand(90));
		addSequential(new EncoderDistanceDriveCommand(-1, 0, 3500));
		addSequential(new IntakeAutoCommand(3, -0.8));
    }
}
