package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftHopper extends CommandGroup {

    public Autonomous_GearLeftHopper() {
    	addSequential(new ShiftToggle_autoCmd(true));
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .85));
    	addSequential(new GyroDrive_cmd(50, .85));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .85), 2.66);
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(0, -.7));
    	addSequential(new ShiftToggle_autoCmd(false));
    	addSequential(new EncoderDrive_cmd(27.25, 26.7, true, .75));
    	addSequential(new GyroDrive_cmd(90, .75));
    	addSequential(new EncoderDrive_cmd(-20.54, -20.31 , false, -.9), 1.25);
    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(20.54, 20.31 , true, .8));
    	addSequential(new GyroDrive_cmd(10, -.8));
    	addSequential(new EncoderDrive_cmd(13, 13 , true, .8));
    }
}
