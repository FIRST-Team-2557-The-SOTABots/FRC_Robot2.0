package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftAutoInit extends CommandGroup {

	public LiftAutoInit(boolean scale) {
		addSequential(new LiftAutoCommand(1000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		if(scale){
			addParallel(new LiftAutoCommand(37500));
		}else{
			addParallel(new LiftAutoCommand(13000));
		}
	}
}
