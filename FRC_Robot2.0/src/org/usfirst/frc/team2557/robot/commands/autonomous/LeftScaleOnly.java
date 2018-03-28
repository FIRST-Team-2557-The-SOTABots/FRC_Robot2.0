package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleCrossover;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScaleOnly extends CommandGroup {

	public LeftScaleOnly() {
		addSequential(new ScaleConditionalCommand(new LeftScale(),new RightScaleCrossover(), false));
	}
}
