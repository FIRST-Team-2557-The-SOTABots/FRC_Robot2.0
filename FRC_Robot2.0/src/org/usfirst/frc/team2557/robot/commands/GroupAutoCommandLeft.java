package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

    public GroupAutoCommandLeft() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			  addSequential(new EncoderDriveCommand2(.5, 0));
			  addSequential(new GyroCommandRight());
			  addSequential(new EncoderDriveCommand3(.5, 0));
			  //place block
		  } else {
			  addSequential(new EncoderDriveCommand2(.5, 0));
			  //check for scale
		  }
                }
    }
}
