package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngle;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroupAutoCommandMid extends CommandGroup {

	public GroupAutoCommandMid() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData != null && gameData.length() > 0){
			if(gameData.charAt(0) == 'L'){
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.25, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 3000));
				addParallel(new LiftAutoCommand(12000));
				addSequential(new TurnByAngle(-90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 3000));
				addSequential(new TurnByAngle(90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500));
				addSequential(new IntakeAutoCommand(1, -0.4));
			}else {
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.25, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2300));
				addSequential(new IntakeAutoCommand(1, -0.4));
			}
		}
	}
}