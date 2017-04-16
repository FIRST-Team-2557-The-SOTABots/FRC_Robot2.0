package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearRightHopper extends CommandGroup {

    public Autonomous_GearRightHopper() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset gyro angle to zero and encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Pause to allow encoders to reset
    	addSequential(new EncoderDrive_cmd(22.7, 22.67 ,true, .85)); //Drive forward
    	
    	addSequential(new GyroDrive_cmd(-54, -.85)); //Turn to face the peg
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Pause to allow encoders to reset
    	addSequential(new TimedVision(3)); //Run the vision gear code
    	
    	
    	
    	
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Pause to allow encoders to reset
    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85));// Drive backwards away from the peg
    	addSequential(new GearToggle_autoCmd(true)); //Put the gear mech to the top
    	
    	
    	
    	
    	
    	/*
    	addSequential(new GyroDrive_cmd(-1, .8)); //Turn to face forward again
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Pause to allow encoders to reset
    	addSequential(new ShiftToggle_autoCmd(false)); //Shift into high gear
    	addSequential(new EncoderDrive_cmd(20.25, 19.7, true, .85)); //Drive forward to line up perpendicular to hopper
    	
    	addSequential(new GyroDrive_cmd(-90, -.75)); //Turn right to face away from the hopper
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.15, false, 0)); //Pause to allow encoders to reset
    	addSequential(new EncoderDrive_cmd(-10.54, -10.31 , false, -.87), 1.25); //Back into the hopper
    	
    	addSequential(new TimedDrive(.3, false, 0)); //Allow time to slow down
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Allow time to reset the encoders
    	addSequential(new EncoderDrive_cmd(20.34, 20.11 , true, .9)); //Drive away from hopper

    	addSequential(new GyroDrive_cmd(5, .85)); //Turn right to face the general direction of the loading station
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.2, false, 0)); //Pause to allow time for the encoders to reset
    	addSequential(new EncoderDrive_cmd(5, 5 , true, .8), 1); //Drive a short distance in the direction of the loding station
*/
    }
}
