package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.autonomous.ScaleConditional;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightCrossover extends CommandGroup {

    public RightCrossover() {
    	addSequential(new ScaleConditional(new LeftSwitch(), new LeftCrossover(), false));
    }
}
