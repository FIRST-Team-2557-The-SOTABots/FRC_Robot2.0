package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitchCrossover;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitchOnly extends CommandGroup {

	public LeftSwitchOnly() {
		addSequential(new SwitchConditional(new LeftSwitch(),new RightSwitchCrossover(), false));
	}
}
