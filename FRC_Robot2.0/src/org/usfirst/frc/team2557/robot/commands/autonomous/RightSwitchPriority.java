package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitchCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchPriority extends CommandGroup {

	public RightSwitchPriority() {
		addSequential(new SwitchConditional(new RightSwitch(), new ScaleConditional(new RightScale(), new LeftSwitchCrossover(), true), true));
	}
}