package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.autonomous.ScaleConditionalCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftCrossover extends CommandGroup {

    public LeftCrossover() {
    	addSequential(new ScaleConditionalCommand(new RightSwitch(), new RightCrossover(), true));
    }
}
