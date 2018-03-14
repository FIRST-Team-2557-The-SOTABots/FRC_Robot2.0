package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
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
				addSequential(new IntakeAutoCommand(075, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 3000));
				addParallel(new LiftAutoCommand(12000));
				addSequential(new TurnByAngleCommand(-90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 3000));
				addSequential(new TurnByAngleCommand(90));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 500));
				addSequential(new IntakeAutoCommand(3, -0.2));
			}else {
				addSequential(new LiftAutoCommand(2000));
				addSequential(new IntakeAutoCommand(0.75, 0.6));
				addSequential(new EncoderDistanceDriveCommand(-.8, 0, 2300));
				addSequential(new IntakeAutoCommand(3, -0.4));
			}
		}
	}
}