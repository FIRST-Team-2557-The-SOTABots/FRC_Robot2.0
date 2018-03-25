package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.autonomous.ScaleConditionalCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightCrossover extends CommandGroup {

    public RightCrossover() {
    	addSequential(new ScaleConditionalCommand(new LeftSwitch(), new LeftCrossover(), false));
    }
}
