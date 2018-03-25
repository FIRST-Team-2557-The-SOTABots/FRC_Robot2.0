package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitchMid;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitchMid;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidSwitchAutoCommand extends CommandGroup {

	public MidSwitchAutoCommand() {
		addSequential(new SwitchConditionalCommand(new RightSwitchMid(), new LeftSwitchMid(), true));
	}
}