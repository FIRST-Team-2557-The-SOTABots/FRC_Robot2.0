package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchPriorityAutoCommand extends CommandGroup {

	public RightSwitchPriorityAutoCommand() {
		addSequential(new SwitchConditionalCommand(new RightSwitch(), new ScaleConditionalCommand(new RightScale(), new LeftScaleCrossover(), true), true));
	}
}