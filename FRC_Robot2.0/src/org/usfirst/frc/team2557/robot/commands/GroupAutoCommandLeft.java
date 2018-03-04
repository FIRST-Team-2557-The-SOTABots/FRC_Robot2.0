package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

	public GroupAutoCommandLeft() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		gameData = "L";
		if(gameData != null && gameData.length() > 0){
			if(gameData.charAt(0) == 'L'){
				addSequential(new LiftAutoCommand(1000.0)); // drop intake
				addSequential(new EncoderDriveCommand2(-.5, 0)); // forward across baseline
				addSequential(new LiftAutoCommand(8000.0)); // lift up to switch
				addSequential(new GyroCommandRight()); // turn 90 degrees
				addSequential(new EncoderDriveCommand3(-.5, 0)); // forward to switch
				addSequential(new OuttakeAutoCommand()); // spit out cube
				addSequential(new EncoderDriveCommand3(.5, 0)); // back up
				// place block
			} else {
				//			  addSequential(new EncoderDriveCommand2(.5, 0));
				addSequential(new EncoderDriveCommand4(-.5, 0));
				addSequential(new GyroCommandLeft());
				addSequential(new EncoderDriveCommand7(-.5, 0));
				addSequential(new GyroCommandRight());
				addSequential(new EncoderDriveCommand6(-.5, 0));
				//check for scale
			}
		}
	}
}
