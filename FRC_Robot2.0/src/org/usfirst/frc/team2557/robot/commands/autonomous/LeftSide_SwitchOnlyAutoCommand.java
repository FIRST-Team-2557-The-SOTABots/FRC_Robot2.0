package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitchNoSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSide_SwitchOnlyAutoCommand extends CommandGroup {

	public LeftSide_SwitchOnlyAutoCommand() {
		
		addSequential(new SwitchConditionalCommand(new LeftSwitch(),new RightSwitchNoSwitch(), false));
		
	}

}
