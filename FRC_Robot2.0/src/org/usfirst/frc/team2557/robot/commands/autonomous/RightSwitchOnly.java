package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitchCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchOnly extends CommandGroup {

	public RightSwitchOnly() {
		addSequential(new SwitchConditional(new RightSwitch(),new LeftSwitchCrossover(), true));
	}
}