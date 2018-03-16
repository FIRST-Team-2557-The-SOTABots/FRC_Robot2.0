package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchPriorityAutoCommand extends CommandGroup {

	public LeftSwitchPriorityAutoCommand() {
		
		addSequential(new SwitchConditionalCommand(new LeftSwitch(), new ScaleConditionalCommand(new LeftScale(), new RightScaleNoLeftScale(), false), false));
		
	}

}
