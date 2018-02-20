package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LiloAutoCommandGroup extends CommandGroup {

    public LiloAutoCommandGroup() {
    	addSequential(new LiftAutoCommand(100.0));
    	Timer t = new Timer();
    	t.start();
//    	while(t.get() != 0.5){
//    		
//    	}
    	addSequential(new LiftAutoCommand(6000.0));
    	
//    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
//    	if(gameData != null && gameData.length() > 0){
//			if(gameData.charAt(0) == 'L'){
//				// drive to left switch
//			}else{
//				// drive to right switch
//			}
//    	}
    	addSequential(new OuttakeAutoCommand());
    	
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
