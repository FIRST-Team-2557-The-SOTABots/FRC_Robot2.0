package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftShoot extends CommandGroup {

    public Autonomous_GearLeftShoot() {
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .75, .001));
    	addSequential(new GyroDrive_cmd(55, .75));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75, .001));
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(216, .75));
    	addSequential(new EncoderDrive_cmd(8.76, 8.58, true, .75, .001));
    }
}
