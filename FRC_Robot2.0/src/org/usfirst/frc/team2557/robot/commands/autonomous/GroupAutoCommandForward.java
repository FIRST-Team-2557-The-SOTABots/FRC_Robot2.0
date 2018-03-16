package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.MotionProfileCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GroupAutoCommandForward extends CommandGroup {

    public GroupAutoCommandForward() {
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
    	addParallel(new LiftAutoCommand(13000));
    	addSequential(new WaitCommand(5));
		addSequential(new MotionProfileCommand(RobotMap.switchForwardMid));
    }
}
