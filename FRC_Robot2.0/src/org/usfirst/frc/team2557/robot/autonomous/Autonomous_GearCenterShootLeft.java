package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenterShootLeft extends CommandGroup {

    public Autonomous_GearCenterShootLeft() {
    	addSequential(new EncoderDrive_cmd(62.24, 61.39, true, .75, .0026), 4);
//    	addSequential(new EncoderDrive_cmd(22.24, 21.39, true, .75, .0026), 4);
//    	addSequential(new Gear_autoCmd());
//    	addSequential(new GyroDrive_cmd(-92, -.75));
//    	addSequential(new EncoderDrive_cmd(10.8, 10.56, true, .75, .001));
    }
}
