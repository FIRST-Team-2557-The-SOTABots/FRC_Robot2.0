package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.commands.DistanceDrive_cmd;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Main_auto extends CommandGroup {

    public Main_auto() {
    	
//    	addSequential(new TimedDrive(1.4,false,.75));
//    	addSequential(new TimedDrive(.5,true, .75));
//    	addParallel(new Autonomus_Shooter(.5));
//    	addSequential(new Auto_Shooter2(10));
    	
    	
    	addSequential(new DistanceDrive_cmd(150, .5));
    	
    	
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
