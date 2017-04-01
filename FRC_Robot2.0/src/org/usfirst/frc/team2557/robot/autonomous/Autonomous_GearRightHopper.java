package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearRightHopper extends CommandGroup {

    public Autonomous_GearRightHopper() {
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .75));
    	addSequential(new GyroDrive_cmd(-55, -.75));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75));
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(0, .75));
    	addSequential(new EncoderDrive_cmd(27.25, 26.7, true, .75));
    	addSequential(new GyroDrive_cmd(-90, -.75));
    	addSequential(new EncoderDrive_cmd(-20.54, -20.31 , false, -.75));
    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(20.54, 20.31 , true, .75));
    	addSequential(new GyroDrive_cmd(-10, .75));
    	addSequential(new EncoderDrive_cmd(13, 13 , true, .75));
    }
}
