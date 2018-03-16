package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoRightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScalePriorityAutoCommand extends CommandGroup {

	public RightScalePriorityAutoCommand() {
		
		addSequential(new ScaleConditionalCommand(new RightScale(), new SwitchConditionalCommand(new RightSwitch(), new LeftScaleNoRightScale(), true), true));
	}

}
