package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeft extends CommandGroup {

    public Autonomous_GearLeft() {
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
    	addSequential(new DistanceDrive_cmd(1.8, -.615), 6.5);
    	addSequential(new TimedDrive(.2, false, .85));
    	addSequential(new GyroDrive_cmd(60, .65));
    	addSequential(new DistanceDrive_cmd(1, -.615), 3.5);
//    	addSequential(new Gear_autoCmd());
    }
}
