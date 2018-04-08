package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchOrBaseline extends CommandGroup {

    public RightSwitchOrBaseline() {
    	addSequential(new SwitchConditional(new RightSwitch(), new Forward(), true));
    	   
    }
}
