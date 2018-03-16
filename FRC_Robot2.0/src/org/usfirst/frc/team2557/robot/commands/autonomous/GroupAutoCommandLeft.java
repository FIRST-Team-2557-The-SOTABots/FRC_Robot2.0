package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

	public GroupAutoCommandLeft() {
		
		addSequential(new SwitchConditionalCommand(new LeftSwitch(), new ScaleConditionalCommand(new LeftScaleNoSwitch(), new RightScaleNoLeftScale(), false), false));
		
	}

}
