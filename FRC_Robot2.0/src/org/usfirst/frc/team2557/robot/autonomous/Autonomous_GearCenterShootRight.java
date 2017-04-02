package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenterShootRight extends CommandGroup {

    public Autonomous_GearCenterShootRight() {
    	addSequential(new EncoderDrive_cmd(22.24, 21.39, true, .75, .001));
    	addSequential(new Gear_autoCmd());
    	addSequential(new GyroDrive_cmd(105, .75));
    	addSequential(new EncoderDrive_cmd(17.8, 17.56, true, .75, .001));
    }
}
