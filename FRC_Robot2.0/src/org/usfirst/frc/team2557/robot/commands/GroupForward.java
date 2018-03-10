package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupForward extends CommandGroup {

	public GroupForward() {
		//		  addSequential(new EncoderDriveCommand1(0, 0));
		//    	  addSequential(new GyroCommandLeft());
		//		  addSequential(new GyroCommandRight());

		//		  addSequential(new EncoderDriveCommand4(-.5, 0));
		//		  addSequential(new GyroCommandRight());
		//		  addSequential(new EncoderDriveCommand7(-.5, 0));
		//		  addSequential(new GyroCommandLeft());
		//		  addSequential(new EncoderDriveCommand6(-.5, 0));

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData != null && gameData.length() > 0){
			if(gameData.charAt(0) == 'L'){
				addSequential(new EncoderDriveCommand2(.5, 0));
				addSequential(new GyroCommandRight());
				addSequential(new EncoderDriveCommand3(.5, 0));
				//place block
			} else {
				//			  addSequential(new EncoderDriveCommand2(.5, 0));
				if(gameData.charAt(1) == 'L') {
					//go to switch
					addSequential(new GyroCommandRight());
					//place cube
				}else {
					addSequential(new EncoderDriveCommand1(0, 0));
				}

				//			  addSequential(new EncoderDriveCommand4(-.5, 0));
				//			  addSequential(new GyroCommandLeft());
				//			  addSequential(new EncoderDriveCommand7(-.5, 0));
				//			  addSequential(new GyroCommandRight());
				//			  addSequential(new EncoderDriveCommand6(-.5, 0));
				//			  //check for scale
			}
		}
		addSequential(new EncoderDriveCommand1(0, 0));
		//		  addSequential(new GyroCommandLeft());
		//		  addSequential(new EncoderDriveCommand3(-.5, 0));

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		//      addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
