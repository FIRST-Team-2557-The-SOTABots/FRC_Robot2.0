package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearRightShoot extends CommandGroup {

    public Autonomous_GearRightShoot() {
    	addSequential(new EncoderDrive_cmd(22, 22.07 ,true, .8, .0003));
    	addSequential(new GyroDrive_cmd(-54, -.85));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75, -.00025), 2);
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(-197, -.71));
//    	addSequential(new EncoderDrive_cmd(8.76, 8.58, true, .75, .001));
    }
}
