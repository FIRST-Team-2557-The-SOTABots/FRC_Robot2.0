package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitchCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSide_SwitchOnlyAutoCommand extends CommandGroup {

	public RightSide_SwitchOnlyAutoCommand() {
		addSequential(new SwitchConditionalCommand(new RightSwitch(),new LeftSwitchCrossover(), true));
	}
}