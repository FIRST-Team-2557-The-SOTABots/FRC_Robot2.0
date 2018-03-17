package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleCrossover;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSide_ScaleOnlyAutoCommand extends CommandGroup {

	public LeftSide_ScaleOnlyAutoCommand() {
		addSequential(new SwitchConditionalCommand(new LeftScale(),new RightScaleCrossover(), false));
	}
}
