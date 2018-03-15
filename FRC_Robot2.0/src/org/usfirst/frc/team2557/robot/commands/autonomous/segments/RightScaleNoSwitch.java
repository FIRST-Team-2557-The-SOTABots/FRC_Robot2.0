package org.usfirst.frc.team2557.robot.commands.autonomous.segments;

import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class RightScaleNoSwitch extends CommandGroup {

    public RightScaleNoSwitch() {
    	addSequential(new LiftAutoCommand(2000));
		addSequential(new IntakeAutoCommand(0.75, 0.6));
		addParallel(new LiftAutoCommand(38000));
		addSequential(new EncoderDistanceDriveCommand(-.75, 0, 20000)); // 8 == 7600
		addSequential(new TurnByAngleCommand(10));
		addSequential(new EncoderDistanceDriveCommand(-.75, 0, 50000));
//		addSequential(new TurnByAngleCommand(-90));
//		addSequential(new WaitForChildren());					
		addSequential(new TurnByAngleCommand(-65));
		addSequential(new WaitForChildren());
//		addSequential(new EncoderDistanceDriveCommand(-.8, 0, 750));
		addSequential(new IntakeAutoCommand(1, -0.4));
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
