package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class SwitchConditionalCommand extends ConditionalCommand {

	public SwitchConditionalCommand(Command trueCommand, Command falseCommand, boolean rightSwitch) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		super(trueCommand, falseCommand);
		x = rightSwitch;
	}

	boolean x;

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() > 0){
			if(x == true) {
				if(gameData.charAt(0) == 'R'){
					return true;
				}
			}
			if(x == false) {
				if(gameData.charAt(0) == 'L'){
					return true;
				}
			}
		}
		return false;
	}
}
