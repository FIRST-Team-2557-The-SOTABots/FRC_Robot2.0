package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleCrossover;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchPriorityAutoCommand extends CommandGroup {

	public LeftSwitchPriorityAutoCommand() {
		
		addSequential(new SwitchConditionalCommand(new LeftSwitch(), new ScaleConditionalCommand(new LeftScale(), new RightScaleCrossover(), false), false));
		
	}

}
