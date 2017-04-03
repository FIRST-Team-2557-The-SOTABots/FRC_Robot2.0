package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftShoot extends CommandGroup {

    public Autonomous_GearLeftShoot() {
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .85));
    	addSequential(new GyroDrive_cmd(51, .85));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .85), 2);
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(197, .71));
//    	addSequential(new EncoderDrive_cmd(8.76, 8.58, true, .75, .001));
    }
}
