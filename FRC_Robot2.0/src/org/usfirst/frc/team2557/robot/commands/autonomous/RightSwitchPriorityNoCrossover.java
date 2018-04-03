package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchPriorityNoCrossover extends CommandGroup { 
    public RightSwitchPriorityNoCrossover() {
    	addSequential(new SwitchConditional(new RightSwitch(), new ScaleConditional(new RightScale(), new RightEnd(), true), true));
    }
}