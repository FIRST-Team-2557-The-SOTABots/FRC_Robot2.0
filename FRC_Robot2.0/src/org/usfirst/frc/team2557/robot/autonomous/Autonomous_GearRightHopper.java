package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearRightHopper extends CommandGroup {

    public Autonomous_GearRightHopper() {
    	addSequential(new EncoderDrive_cmd(22, 22.07 ,true, .8, .0003));
    	addSequential(new GyroDrive_cmd(-54, -.85));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75, -.00025), 2);
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(-5, .8));
    	addSequential(new ShiftToggle_autoCmd(false));
    	addSequential(new EncoderDrive_cmd(20.25, 19.7, true, .85, .001));
    	addSequential(new GyroDrive_cmd(-90, -.75));
    	addSequential(new EncoderDrive_cmd(-10.54, -10.31 , false, -.87, .001), 1.25);
    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(20.34, 20.11 , true, .9, .001));
    	addSequential(new GyroDrive_cmd(-25, .85));
    	addSequential(new EncoderDrive_cmd(5, 5 , true, .8, .001), 1);
    }
}
