package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearCenterShootLeft extends CommandGroup {

    public Autonomous_GearCenterShootLeft() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset both encoders and gyro to zero
    	addSequential(new TimedDrive(.25, false, 0)); //Allow time for the sensors to reset
    	addSequential(new EncoderDrive_cmd(22.24, 21.39, true, .85), 4); //Drive forward
    	
    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	
    	addParallel(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.05, false, 0)); //Pause to give the encoders time to reset
    	
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85)); //Drive backwards away from the peg
    	addParallel(new GearToggle_autoCmd(true)); //Bring the gear mech to the floor
    	
    	
    	
    	
//    	addSequential(new GyroDrive_cmd(-92, -.75)); //Turn to face the boiler
//    	
//    	addParallel(new Autonomous_Shooter(2, 1)); //Bring the flywheels up to speed as the robot drives to the boiler
//    	addSequential(new EncoderDrive_cmd(10.8, 10.56, true, .75)); //Drive to the boiler
//    	
//    	addSequential(new Autonomous_Shooter(3.5, 2)); //Fire the balls out of the hopper
//    	
    	
    	
    }
}
