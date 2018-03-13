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
			  addSequential(new EncoderDriveCommand2(-.8, 0));
			  addParallel(new LiftAutoCommand(11000, .8));
			  addSequential(new GyroCommandRight());
			  addSequential(new EncoderDriveCommand3(-.8, 0));
			  addSequential(new IntakeAutoCommandAlt(.8));
			  
		  } 
		  else {
//			  addSequential(new EncoderDriveCommand2(.5, 0));
			  
//			  addSequential(new EncoderDriveCommand4(-.5, 0));
//			  addParallel(new LiftAutoCommand(.6));
//			  addSequential(new GyroCommandLeft());
//			  addSequential(new EncoderDriveCommand7(-.5, 0));
//			  addSequential(new GyroCommandRight());
//			  addSequential(new EncoderDriveCommand6(-.5, 0));

			  if(gameData.charAt(1) == 'L') {
				  addSequential(new EncoderDriveCommand8(-.8, 0));
				  addParallel(new LiftAutoCommand(11000, .8));
				  addSequential(new GyroCommandRight());
				  addSequential(new IntakeAutoCommandAlt(.8));
			  }
			  else {
				  addSequential(new EncoderDriveCommand9(-.8, 0));
				  addSequential(new GyroCommandRight());
				  addSequential(new EncoderDriveCommand5(-.8, 0));
				  
			  }
		  }
                }
    }

}
