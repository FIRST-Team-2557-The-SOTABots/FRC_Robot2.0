package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftHopper extends CommandGroup {

    public Autonomous_GearLeftHopper() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset gyro angle to zero and encoders to zero
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .85)); //Drive forward
    	
    	addSequential(new GyroDrive_cmd(54, .85)); //Turn to the gear peg
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.25, false, 0)); //Pause to allow time for encoders to reset
    	//addSequential(new EncoderDrive_cmd(15.49, 15.37 ,true, .85), 2);//Drive onto the gear peg
    	addSequential(new TimedVision(3));//A new, better way to drive onto the gear peg using vision.

    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	
    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85));// Drive backwards away from the peg
    	/*
    	addSequential(new GyroDrive_cmd(5, -.8)); //Turn to face forward again
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new ShiftToggle_autoCmd(false)); //Shift into high gear
    	addSequential(new EncoderDrive_cmd(24.25, 23.7, true, .8)); //Drive forward
    	
    	addSequential(new GyroDrive_cmd(90, .775)); //Turn to face directly away from the hopper
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new EncoderDrive_cmd(-20.54, -20.31 , false, -.85), 1.25); //Drive backwards into the hopper
    	addSequential(new TimedDrive(.5, false, 0)); //Pause to cruise into hopper
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new EncoderDrive_cmd(20.34, 20.11 , true, .9));//Drive away from falling balls
    	
    	addSequential(new GyroDrive_cmd(10, -.85)); //Turn to face forward again

    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new EncoderDrive_cmd(13, 13 , true, .8)); //Drive away from our side and set up for teleop
    	*/
    }
}
