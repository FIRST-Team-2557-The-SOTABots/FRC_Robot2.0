package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

	public GroupAutoCommandLeft() {
		//		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		//		gameData = "L";
		//		if(gameData != null && gameData.length() > 0){
		//			if(gameData.charAt(0) == 'L'){
		//				addSequential(new LiftAutoCommand(17000.0)); // drop intake
		//				addSequential(new EncoderDriveCommand2(-.5, 0)); // forward across baseline 3800
		addSequential(new LiftAutoCommand(2000.0));
		addSequential(new IntakeAutoCommand(1));
		addSequential(new WaitCommand(5));
		addSequential(new LiftAutoCommand(25000.0)); // lift up to switch
		addSequential(new WaitCommand(5));
		addSequential(new LiftAutoCommand(10000.0)); // lift up to switch
		//				addSequential(new GyroCommandRight()); // turn 90 degrees
		//				addSequential(new EncoderDriveCommand3(-.5, 0)); // forward to switch 500
		//				addSequential(new OuttakeAutoCommand()); // spit out cube
		//				addSequential(new EncoderDriveCommand3(.5, 0)); // back up 
		//				// place block
		//			} else if(gameData.charAt(1) == 'L'){
		//				addSequential(new LiftAutoCommand(17000.0)); // drop intake
		//				addSequential(new EncoderDriveCommand7(-.5, 0)); // go 7000
		//				addSequential(new GyroCommandRight());
		//				addSequential(new EncoderDriveCommand3(-.5, 0)); // forward to scale 500
		//				addSequential(new LiftAutoCommand(-18000.0)); // lift up to scale
		//				addSequential(new OuttakeAutoCommand()); // spit out cube
		//				addSequential(new EncoderDriveCommand3(.5, 0)); // back up
		//			}else {
		//				//			  addSequential(new EncoderDriveCommand2(.5, 0));
		//				addSequential(new EncoderDriveCommand4(-.5, 0)); // forward 5000
		//				addSequential(new GyroCommandRight());
		//				addSequential(new EncoderDriveCommand7(-.5, 0)); // go 7000
		//				addSequential(new GyroCommandRight());
		//				addSequential(new EncoderDriveCommand3(-.5, 0)); // forward to switch 500
		//				//check for scale
		//			}
		//		}
		
		
//		String gameData = DriverStation.getInstance().getGameSpecificMessage();
//		gameData = "L";
//		if(gameData != null && gameData.length() > 0){
//			if(gameData.charAt(0) == 'L'){
//				addSequential(new LiftAutoCommand(1000.0)); // drop intake
//				addSequential(new EncoderDriveCommand2(-.5, 0)); // forward across baseline
//				addSequential(new LiftAutoCommand(8000.0)); // lift up to switch
//				addSequential(new GyroCommandRight()); // turn 90 degrees
//				addSequential(new EncoderDriveCommand3(-.5, 0)); // forward to switch
//				addSequential(new OuttakeAutoCommand()); // spit out cube
//				addSequential(new EncoderDriveCommand3(.5, 0)); // back up
//				// place block
//			} else {
//				//			  addSequential(new EncoderDriveCommand2(.5, 0));
//				addSequential(new EncoderDriveCommand4(-.5, 0));
//				addSequential(new GyroCommandLeft());
//				addSequential(new EncoderDriveCommand7(-.5, 0));
//				addSequential(new GyroCommandRight());
//				addSequential(new EncoderDriveCommand6(-.5, 0));
//				//check for scale
//			}
//		}
	}
}