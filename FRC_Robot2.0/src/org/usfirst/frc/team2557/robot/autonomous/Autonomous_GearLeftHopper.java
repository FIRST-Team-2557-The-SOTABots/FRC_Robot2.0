package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftHopper extends CommandGroup {

    public Autonomous_GearLeftHopper() {
//    	addSequential(new ShiftToggle_autoCmd(true));
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .85, .001));
    	addSequential(new GyroDrive_cmd(51, .85));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .85, .0015), 2);
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(5, -.8));
    	addSequential(new ShiftToggle_autoCmd(false));
    	addSequential(new EncoderDrive_cmd(26.25, 25.7, true, .85, .001));
    	addSequential(new GyroDrive_cmd(90, .775));
    	addSequential(new EncoderDrive_cmd(-20.54, -20.31 , false, -.9, .001), 1.25);
    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(20.34, 20.11 , true, .9, .001));
    	addSequential(new GyroDrive_cmd(10, -.85));
    	addSequential(new EncoderDrive_cmd(13, 13 , true, .8, .001));
    }
}
