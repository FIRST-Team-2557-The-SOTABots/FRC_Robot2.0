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
		addParallel(new LiftAutoCommand(37500));
		addSequential(new MotionProfileCommand(RobotMap.scaleForwardRight));
		addSequential(new TurnByAngleCommand(7.5));
		addSequential(new MotionProfileCommand(RobotMap.scaleForwardRight));
		addSequential(new WaitForChildren());
		addSequential(new TurnByAngleCommand(100.0));
		addSequential(new MotionProfileCommand(RobotMap.scaleForwardRight2));
		addSequential(new IntakeAutoCommand(3, -0.4));
    	
//    	addSequential(new LiftAutoCommand(2000));
//		addSequential(new IntakeAutoCommand(0.75, 0.6));
//		addParallel(new LiftAutoCommand(38000));
//		addSequential(new EncoderDistanceDriveCommand(-.75, 0, 20000)); // 8 == 7600
//		addSequential(new TurnByAngleCommand(10));
//		addSequential(new EncoderDistanceDriveCommand(-.75, 0, 50000));
////		addSequential(new TurnByAngleCommand(-90));
////		addSequential(new WaitForChildren());					
//		addSequential(new TurnByAngleCommand(-65));
//		addSequential(new WaitForChildren());
////		addSequential(new EncoderDistanceDriveCommand(-.8, 0, 750));
//		addSequential(new IntakeAutoCommand(1, -0.4));
    }
}
