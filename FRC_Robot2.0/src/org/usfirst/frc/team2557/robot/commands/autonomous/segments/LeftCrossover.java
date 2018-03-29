package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.autonomous.ScaleConditional;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftCrossover extends CommandGroup {

    public LeftCrossover() {
    	addSequential(new ScaleConditional(new RightSwitch(), new RightCrossover(), true));
    }
}
