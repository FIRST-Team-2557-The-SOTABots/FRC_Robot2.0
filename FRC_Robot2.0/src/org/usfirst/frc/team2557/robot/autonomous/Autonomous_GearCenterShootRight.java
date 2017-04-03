package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenterShootRight extends CommandGroup {

    public Autonomous_GearCenterShootRight() {
    	addSequential(new EncoderDrive_cmd(22.24, 21.39, true, .75, .0027), 4);
    	addSequential(new Gear_autoCmd());
    	addSequential(new GyroDrive_cmd(96, .725));
    	addSequential(new EncoderDrive_cmd(10.8, 10.56, true, .75, .001));
    }
}
