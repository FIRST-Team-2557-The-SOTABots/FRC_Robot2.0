package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class GroupAutoCommandLeft extends CommandGroup {

	public GroupAutoCommandLeft() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		gameData = "RR";
		if(gameData.length() > 0){
			if(gameData.charAt(0) == 'L'){
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.75, 0.6));
				addParallel(new LiftAutoCommand(12000));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2500)); // 2 == 2800
				addSequential(new TurnByAngleCommand(90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500)); // 3 == 1000
				addSequential(new IntakeAutoCommand(3, -0.2));
			} else {
				if(gameData.charAt(1) == 'L') {
					addSequential(new LiftAutoCommand(2000));
					addSequential(new IntakeAutoCommand(0.75, 0.6));
					addParallel(new LiftAutoCommand(37500));
					addSequential(new EncoderDistanceDriveCommand(-.75, 0, 6200)); // 8 == 7600
					addSequential(new TurnByAngleCommand(45));
					addSequential(new WaitForChildren());
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 750));
					addSequential(new IntakeAutoCommand(3, -0.2));
				}else {
					addSequential(new LiftAutoCommand(2000));
					addSequential(new IntakeAutoCommand(0.75, 0.6));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 4200)); // 9 == 5200
					addSequential(new TurnByAngleCommand(90));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 4000)); // 5 == 3500
					addParallel(new LiftAutoCommand(37500));
					addSequential(new TurnByAngleCommand(-90));
					addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500));
					addSequential(new IntakeAutoCommand(3, -0.2));
				}
			}
		}
	}

}
