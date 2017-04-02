package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EncoderAutoLeft_cmdgrp extends CommandGroup {

    public EncoderAutoLeft_cmdgrp() {
    	
    	
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .75, .001));
    	addSequential(new GyroDrive_cmd(55, .75));
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75, .001));
    	addSequential(new Gear_autoCmd());
    	
    	addSequential(new GyroDrive_cmd(0, -.75));
    	addSequential(new EncoderDrive_cmd(27.25, 26.7, true, .75, .001));
    	addSequential(new GyroDrive_cmd(90, .75));
    	addSequential(new EncoderDrive_cmd(-20.54, -20.31 , false, -.75, .001));
    	addSequential(new TimedDrive(.5, false, 0));
    	addSequential(new EncoderDrive_cmd(20.54, 20.31 , true, .75, .001));
    	addSequential(new GyroDrive_cmd(10, -.75));
    	addSequential(new EncoderDrive_cmd(13, 13 , true, .75, .001));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
