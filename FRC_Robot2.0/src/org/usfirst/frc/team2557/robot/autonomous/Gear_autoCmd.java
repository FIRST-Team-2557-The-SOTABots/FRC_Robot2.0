package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.commands.GearGrab_toggle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Gear_autoCmd extends CommandGroup {

    public Gear_autoCmd() {
    	addParallel(new GearToggle_autoCmd(false));
    	addParallel(new TimedGear(2, .75));
//    	addParallel(new GearToggle_autoCmd(false));
//    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85));
//    	addParallel(new GearToggle_autoCmd(true));
    }
}
