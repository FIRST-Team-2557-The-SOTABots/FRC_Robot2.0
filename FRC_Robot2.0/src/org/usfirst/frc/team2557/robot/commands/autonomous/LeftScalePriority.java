package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleCrossover;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScalePriority extends CommandGroup {

	public LeftScalePriority() {
		addSequential(new ScaleConditional(new LeftScale(), new SwitchConditional(new LeftSwitch(), new RightScaleCrossover(), false), false));
	}

}
