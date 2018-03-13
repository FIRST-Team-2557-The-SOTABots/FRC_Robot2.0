package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GroupAutoCommandRight extends CommandGroup {

	public GroupAutoCommandRight() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() > 0){
			if(gameData.charAt(0) == 'R'){
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.25, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2500)); // 2 == 2800
				addParallel(new LiftAutoCommand(12000));
				addSequential(new TurnByAngleCommand(-90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500)); // 3 == 1000
				addSequential(new IntakeAutoCommand(1, -0.4));
			} else {
				if(gameData.charAt(1) == 'R') {
					addSequential(new LiftAutoCommand(2000));
					addSequential(new IntakeAutoCommand(0.25, 0.6));
					addParallel(new LiftAutoCommand(34000));
					addSequential(new EncoderDistanceDriveCommand(-.75, 0, 5750)); // 8 == 7600
					addSequential(new TurnByAngleCommand(-45));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 250));
					addSequential(new IntakeAutoCommand(1, -0.4));
				}else {
					addSequential(new LiftAutoCommand(2000));
					addSequential(new IntakeAutoCommand(0.25, 0.6));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 5200)); // 9 == 5200
					addSequential(new TurnByAngleCommand(-90));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 3500)); // 5 == 3500

				}
			}
		}
	}

}
