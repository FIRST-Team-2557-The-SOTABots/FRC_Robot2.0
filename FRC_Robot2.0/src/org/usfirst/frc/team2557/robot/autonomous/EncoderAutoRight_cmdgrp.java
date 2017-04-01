package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EncoderAutoRight_cmdgrp extends CommandGroup {

    public EncoderAutoRight_cmdgrp() {
    	addSequential(new EncoderDrive_cmd(0, .75, 200));
    	addSequential(new GyroDrive_cmd(84, .75));
    	addSequential(new EncoderDrive_cmd(0, .75, 1200));
    	addSequential(new GyroDrive_cmd(-151, .75));
    	addSequential(new EncoderDrive_cmd(0, .75, 700));
    	addSequential(new Gear_autoCmd());
    	
    	
    	
    	addSequential(new EncoderDrive_cmd(0, -.75, 200));
    	addSequential(new GyroDrive_cmd(180, .75));
    	addSequential(new EncoderDrive_cmd(0, .75, 700));
    	addSequential(new GyroDrive_cmd(61, .75));
    	addSequential(new EncoderDrive_cmd(0, .75, 400));
    	addSequential(new GyroDrive_cmd(-144, .75));
    	addSequential(new Auto_Shooter2(4));
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
