package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScalePriorityAutoCommand extends CommandGroup {

	public LeftScalePriorityAutoCommand() {
		
		addSequential(new ScaleConditionalCommand(new LeftScale(), new SwitchConditionalCommand(new LeftSwitch(), new RightScaleNoLeftScale(), false), false));
	}

}
