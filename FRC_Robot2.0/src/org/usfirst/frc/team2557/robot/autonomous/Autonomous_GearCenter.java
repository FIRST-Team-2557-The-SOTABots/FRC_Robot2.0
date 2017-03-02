package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenter extends CommandGroup {

    public Autonomous_GearCenter() {
        
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
        // arm.o
    	addSequential(new GearGrab_autoCmd(true)); 				//Close the claw
    	addParallel(new Gear_autoCmd(-510, 10, 1)); 			//Lift gear to desired height
    	addSequential(new Drive_autoCmd(9.2, .1, .75, false)); 	//Drive forward
    	addSequential(new GearGrab_autoCmd(false)); 			//Open claw
    	addParallel(new Gear_autoCmd(-100, 10, -1)); 			//Bring claw down
    	addSequential(new Drive_autoCmd(-3, .1, -.75, false)); 	//Back away
    	
    	/*
    	 * The Drive_autoCmd() does the same thing as the AutonomousTurn_cmd(). Granted AutonomousTurn_cmd is more straightforward
    	 * */
    	addSequential(new AutonomousTurn_Cmd(90));                //TURNNNNNNN?
    	addSequential(new Drive_autoCmd(2.4, .1, .75, false));  //Again?? Drive??
    	addSequential(new AutonomousTurn_Cmd(0));           //Turn?????????????????? 
    	addSequential(new Drive_autoCmd(3.7, .1, .75, false)); //More driving :)
        
    	
    }
}
