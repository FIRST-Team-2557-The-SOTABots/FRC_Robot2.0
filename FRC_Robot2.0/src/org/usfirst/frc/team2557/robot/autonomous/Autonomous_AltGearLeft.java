package org.usfirst.frc.team2557.robot.autonomous;

import org.usfirst.frc.team2557.robot.commands.MoveWithEncoders_cmd;
import org.usfirst.frc.team2557.robot.commands.TurnToAngle_cmd;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_AltGearLeft extends CommandGroup {
    
    public  Autonomous_AltGearLeft() {
    	addSequential(new MoveWithEncoders_cmd(0, 0.7, 3000));
    	addSequential(new TurnToAngle_cmd(0.5, 0, 45));
    	addSequential(new MoveWithEncoders_cmd(0, 0.7, 4000));
    	addSequential(new Gear_autoCmd());
    	
    	//the next couple are optional, and will get us past the baseline
    	
    	
    	addSequential(new MoveWithEncoders_cmd(0, -0.7, 500));
    	addSequential(new TurnToAngle_cmd(0.5, 0, -45));
    	addSequential(new MoveWithEncoders_cmd(0, 0.7, 2000));
    	
    	
    	
    	
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
