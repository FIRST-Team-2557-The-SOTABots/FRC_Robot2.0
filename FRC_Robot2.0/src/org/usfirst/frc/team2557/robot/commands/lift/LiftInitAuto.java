package org.usfirst.frc.team2557.robot.commands.lift;

import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftInitAuto extends CommandGroup {

    public LiftInitAuto() {
    	
    	addSequential(new LiftAutoCommand(1000));
		addSequential(new IntakeAutoCommand(0.75, 0.9));
		addSequential(new LiftAutoCommand(37500));
    	
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
