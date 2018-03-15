package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.autonomous.segments.LeftScaleNoRightScale;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightScaleNoSwitch;
import org.usfirst.frc.team2557.robot.commands.autonomous.segments.RightSwitch;
import org.usfirst.frc.team2557.robot.commands.drive.EncoderDistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.drive.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeAutoCommand;
import org.usfirst.frc.team2557.robot.commands.lift.LiftAutoCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class GroupAutoCommandRight extends CommandGroup {

	public GroupAutoCommandRight() {
		
		addSequential(new SwitchConditionalCommand(new RightSwitch(), new ScaleConditionalCommand(new RightScaleNoSwitch(), new LeftScaleNoRightScale(), true), true));
		
	}

}
