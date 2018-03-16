package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoRightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScalePriorityAutoCommand extends CommandGroup {

	public RightScalePriorityAutoCommand() {
		
		addSequential(new ScaleConditionalCommand(new RightScaleNoSwitch(), new SwitchConditionalCommand(new RightSwitch(), new LeftScaleNoRightScale(), true), true));
	}

}
