package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupAutoCommandRight extends CommandGroup {

    public GroupAutoCommandRight() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
//			  addSequential(new EncoderDriveCommand4(-.5, 0));
//			  addSequential(new GyroCommandRight());
//			  addSequential(new EncoderDriveCommand7(-.5, 0));
//			  addSequential(new GyroCommandLeft());
//			  addSequential(new EncoderDriveCommand6(-.5, 0));
			  
			if(gameData.charAt(1) == 'L') {
				  addSequential(new EncoderDriveCommand8(.6, 0));
				  addParallel(new LiftAutoCommand(.6));
				  addSequential(new GyroCommandLeft());
				  addSequential(new IntakeAutoCommand());
			}
		  } else {
			  addSequential(new EncoderDriveCommand2(-.5, 0));
			  addSequential(new GyroCommandLeft());
			  addSequential(new EncoderDriveCommand3(-.5, 0));
			  addSequential(new IntakeAutoCommand());
		  }
                }
    }
}
