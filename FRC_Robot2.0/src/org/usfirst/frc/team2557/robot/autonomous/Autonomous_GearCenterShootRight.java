 package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenterShootRight extends CommandGroup {

    public Autonomous_GearCenterShootRight() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset both encoders and gyro to zero
    	addSequential(new EncoderDrive_cmd(22.24, 21.39, true, .75), 4); //Drive forward
    	
    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	
    	addParallel(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.05, false, 0)); //Pause to give the encoders time to reset
    	
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85)); //Drive backwards away from the peg
    	addParallel(new GearToggle_autoCmd(true)); //Put the gear mech to the floor
    	
    	addSequential(new GyroDrive_cmd(96, .725)); //Turn to face the boiler
    	
    	addParallel(new Autonomous_Shooter(2, 1)); //Bring the flywheels up to speed
    	addSequential(new EncoderDrive_cmd(10.8, 10.56, true, .75)); //Drive towards boiler
    	
    	addSequential(new Autonomous_Shooter(3.5, 2)); //Fire the balls from the hopper
    	
    }
}
