package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchOrBaseline extends CommandGroup {

    public LeftSwitchOrBaseline() {
    	addSequential(new SwitchConditional(new LeftSwitch(), new Forward(), false));
    	
    }
}
