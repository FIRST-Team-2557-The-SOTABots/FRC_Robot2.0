package org.usfirst.frc.team2557.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_GearLeftShoot extends CommandGroup {

    public Autonomous_GearLeftShoot() {
    	addSequential(new SensorReset_autoCmd(3)); //Reset gyro angle to zero and encoders to zero
    	addSequential(new TimedDrive(.15, false, 0)); //Pause to allow for encoders to reset
    	addSequential(new EncoderDrive_cmd(23.7, 23.67 ,true, .85)); //Drive forward
    	
    	addSequential(new GyroDrive_cmd(54, .85)); //Turn to the gear peg
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.15, false, 0)); //Pause to allow for encoders to reset
    	//addSequential(new EncoderDrive_cmd(13.49, 13.37 ,true, .85), 2); //Drive onto the gear peg
    	addSequential(new TimedVision(3));//A new, better way to drive onto the gear peg using vision.
    	
    	addSequential(new GearToggle_autoCmd(false)); //Put the gear mech to the floor
    	
    	addSequential(new SensorReset_autoCmd(2)); //Reset the encoders to zero
    	addSequential(new TimedDrive(.15, false, 0)); //Pause to give the encoders time to reset
    	
    	addParallel(new TimedGear(2, .75)); //Run gear wheels
    	addSequential(new EncoderDrive_cmd(-13, -13 ,false, -.85)); //Drive backwards away from the peg
    	
    	addSequential(new GearToggle_autoCmd(true)); //Bring the gear mech up
    	
    	addParallel(new Autonomous_Shooter(2.25, 1)); //Bring the flywheels up to speed
    	addSequential(new GyroDrive_cmd(191, .79)); //Turn the robot to face the boiler
    	
    	addSequential(new Autonomous_Shooter(3.5, 2)); //Actuate the other shooting pieces
    	
//    	addSequential(new EncoderDrive_cmd(8.76, 8.58, true, .75, .001));
    }
}
