package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoRightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoLeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSide_ScaleOnlyAutoCommand extends CommandGroup {

	public RightSide_ScaleOnlyAutoCommand() {
		
		addSequential(new SwitchConditionalCommand(new RightScale(),new LeftScaleNoRightScale(), true));
		
	}

}
