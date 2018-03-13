package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

	public GroupAutoCommandLeft() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		gameData = "RL";
		if(gameData.length() > 0)
		{
			if(gameData.charAt(0) == 'L')
			{
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.25, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2500)); // 2 == 2800
				
				addParallel(new LiftAutoCommand(12000));
				addSequential(new GyroCommandRight());
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500)); // 3 == 1000
				addSequential(new IntakeAutoCommand(1, -0.4));
				

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
					addSequential(new LiftAutoCommand(2000));
					addSequential(new IntakeAutoCommand(0.25, 0.6));
//					addSequential(new LiftAutoCommand(34000));
					addParallel(new LiftAutoCommand(34000));
					addSequential(new EncoderDistanceDriveCommand(-.75, 0, 5750)); // 8 == 7600
//					addParallel(new LiftAutoCommand(34000));
					addSequential(new TurnByAngle(45));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 250));
					addSequential(new IntakeAutoCommand(1, -0.4));
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
