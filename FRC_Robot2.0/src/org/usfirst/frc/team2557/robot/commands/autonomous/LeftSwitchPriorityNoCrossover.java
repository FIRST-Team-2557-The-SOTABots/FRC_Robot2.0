package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitchCrossover;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchPriorityNoCrossover extends CommandGroup {

    public LeftSwitchPriorityNoCrossover() {
    	addSequential(new SwitchConditional(new LeftSwitch(), new ScaleConditional(new LeftScale(), new Forward(), false), false));
    	
    }
}
