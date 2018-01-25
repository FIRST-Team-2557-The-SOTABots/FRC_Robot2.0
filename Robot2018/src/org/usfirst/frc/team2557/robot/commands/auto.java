package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class auto extends CommandGroup {

    public auto() {
    	addSequential(new auto_cmd(1, -0.3, false)); // robot drives forward three seconds
    //	addSequential(new auto_cmd(0.25,0,false)); //robot pauses for 0.25 seconds
    //	addSequential(new auto_cmd(1,0.8,false)); // robot drives forward for one second
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
