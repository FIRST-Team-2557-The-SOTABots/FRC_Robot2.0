package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.IntakeIncrementally;
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
    	addSequential(new LiftAutoCommand(750));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		
		RobotMap.IntakeL.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.IntakeR.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
		
		addParallel(new LiftAutoCommand(5000)); // 37500
		addSequential(new MotionProfileTurnCommand(RobotMap.trajectory));
		
		addParallel(new IntakeAutoCommand(0.75, 0.6));
		addParallel(new LiftAutoCommand(0));
		addSequential(new WaitForChildren());
		
		addSequential(new LiftAutoCommand(37500));
		addSequential(new WaitForChildren());
		addSequential(new MotionProfileTurnCommand(RobotMap.trajectorySlow));
		
//		addSequential(new TurnByAngleCommand(10.0));
//		addSequential(new IntakeAutoCommand(3, -0.4));
		
		RobotMap.IntakeL.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    	RobotMap.IntakeR.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    }
}
