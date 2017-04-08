package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearRightShoot extends CommandGroup {

    public Autonomous_GearRightShoot() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset gyro angle to zero and encoders to zero
    	addSequential(new EncoderDrive_cmd(22, 22.07 ,true, .8), 4); //Drive forward
    	
    	addSequential(new GyroDrive_cmd(-54, -.85)); //Turn left to face the gear
    	
    	/*
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .75), 2); //Drive onto the peg

    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	
    	addParallel(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.05, false, 0)); //Pause to give the encoders time to reset
    	
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85));// Drive backwards away from the peg
    	
    	addSequential(new GearToggle_autoCmd(true)); //Bring the gear mech up
    	
    	addParallel(new Autonomous_Shooter(2.25, 1)); //Bring the flywheels up to speed whle the robot turns
    	addSequential(new GyroDrive_cmd(-197, -.71)); //Turn to face the boiler
    	
    	addSequential(new Autonomous_Shooter(3.5, 2)); //Shoot all of the balls in the hopper
    	
    	*/
    	
//    	addSequential(new EncoderDrive_cmd(8.76, 8.58, true, .75, .001));
    }
}
