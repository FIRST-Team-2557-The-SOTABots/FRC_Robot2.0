package CharlesCommands;

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
			  addSequential(new EncoderDriveCommand2(-.5, 0));
			//check for scale
		  } else {
			  addSequential(new EncoderDriveCommand2(-.5, 0));
			  addSequential(new GyroCommandLeft());
			  addSequential(new EncoderDriveCommand3(-.5, 0));
			//place block
		  }
                }
    }
}
