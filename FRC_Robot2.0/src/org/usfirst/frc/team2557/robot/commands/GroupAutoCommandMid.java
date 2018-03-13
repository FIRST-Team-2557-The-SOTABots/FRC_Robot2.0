package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroupAutoCommandMid extends CommandGroup {

	public GroupAutoCommandMid() {

		//    	addSequential(new Sensor());
		//    	addSequential(new MoveToSwitch());
		//    	addSequential(new EncoderDriveCommand1(.5, 0));
		//    	addSequential(new Block_placer());
		//    	addSequential(new SolenoidAutoCommand());
		//    	addSequential(new MecanumCommandThing());
		//    	addSequential(new EncoderDriveCommand2(.8, 0));
		//    	if(Sensor.get() == left colour){
		//    		addSequential(new GyroCommandRight());
		//    	}
		//    	if(Sensor.get() == right colour){
		//    		addSequential(new GyroCommandLeft());
		//    	}
		//    	addSequential(new Block_picker());

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData != null && gameData.length() > 0){
			if(gameData.charAt(0) == 'L')
			{
				addSequential(new EncoderDriveCommand4(-.8, 0));
				addParallel(new LiftAutoCommand(11000, .8));
				addSequential(new GyroCommandLeft());
				addSequential(new EncoderDriveCommand5(-.8, 0));
				addSequential(new GyroCommandRight());
				addSequential(new EncoderDriveCommand6(-.8, 0));
				addSequential(new IntakeAutoCommandAlt(.8));
			}
			else {
				addSequential(new EncoderDriveCommand1(-.8, 0));
				addSequential(new IntakeAutoCommandAlt(.8));
			}
		}

		//    	addSequential(new SolenoidAutoCommand());
		//    	addSequential(new TimedAutoDriveCommand(.5, 0, 5));
		//    	addSequential(new TimedAutoDriveCommand(-.5, 0, 1));
		//    	addSequential(new SolenoidAutoCommand());
		//    	addSequential(new TimedAutoMecanumDriveCommand(.5, 0, 0, 3));
		//    	addSequential(new SolenoidAutoCommand());
		//    	addSequential(new TimedAutoDriveCommand(-.5, 0, 1));
	}
}