package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleCrossover;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightScaleOnly extends CommandGroup {

	public RightScaleOnly() {
		addSequential(new ScaleConditionalCommand(new RightScale(),new LeftScaleCrossover(), true));
	}
}