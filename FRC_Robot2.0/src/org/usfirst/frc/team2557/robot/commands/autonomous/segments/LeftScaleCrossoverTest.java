package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

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
public class LeftScaleCrossoverTest extends CommandGroup {

    public LeftScaleCrossoverTest() {
    	addSequential(new LiftAutoCommand(1000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		
		RobotMap.IntakeL.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.IntakeR.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
		
		addParallel(new LiftAutoCommand(7500)); // 37500
		addSequential(new MotionProfileTurnCommand(RobotMap.trajectory2));
		
//		addParallel(new IntakeAutoCommand(0.75, 0.6));
//		addParallel(new LiftAutoCommand(0));
//		addSequential(new WaitForChildren());
		
		addParallel(new LiftAutoCommand(38000));
		addSequential(new TurnByAngleCommand(-100.0));
		addSequential(new WaitForChildren());
		
//		addSequential(new MotionProfileTurnCommand(RobotMap.trajectoryShort));
		
		addSequential(new MotionProfileCommand(RobotMap.drive14));
//		addSequential(new TurnByAngleCommand(-5.0));
		addSequential(new IntakeAutoCommand(3, -0.4));
    }
}
