/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;


import org.usfirst.frc.team2557.robot.commands.drive.BrakingCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team2557.robot.commands.solenoid.RiseCommandLeft;
import org.usfirst.frc.team2557.robot.commands.solenoid.RiseCommandRight;
import org.usfirst.frc.team2557.robot.commands.solenoid.SolenoidCommand;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandLeft;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandRight;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick Joystick1;
	public static JoystickButton MecButton;
	public static JoystickButton CoulsonButton;
	public static JoystickButton forwardButton;
	public static JoystickButton backwardButton;
	
	public static JoystickButton da;
	public static JoystickButton db;
	public static JoystickButton dx;
	public static JoystickButton dy;
	
	public static JoystickButton startButton;
	public static JoystickButton backButton;
	
	public static Joystick Joystick2;
	public static JoystickButton IntakeIn;
	public static JoystickButton IntakeOut;
	public static JoystickButton rightBumper;
	public static JoystickButton leftBumper;
	public static JoystickButton rightTrigger;
	public static JoystickButton leftTrigger;
	public static JoystickButton outTakeFast;
	
	public void OIInit() {
		Joystick1 = new Joystick(0);
		MecButton = new JoystickButton(Joystick1, 6);
		CoulsonButton = new JoystickButton(Joystick1, 5);
		
		startButton = new JoystickButton(Joystick1, 8);
		startButton.whenPressed(new BrakingCommand(true));
		startButton.whenReleased(new BrakingCommand(false));
		
		backButton = new JoystickButton(Joystick1, 7);
		
		
		MecButton.whenPressed(new SolenoidCommand());
		CoulsonButton.whenPressed(new SolenoidCommand());
		
		Joystick2 = new Joystick(1);
		IntakeIn = new JoystickButton(Joystick2, 2);
		IntakeOut = new JoystickButton(Joystick2, 1);
		
		rightBumper = new JoystickButton(Joystick2, 5); 
		leftBumper = new JoystickButton(Joystick2, 6);
		rightTrigger = new JoystickButton(Joystick2, 8);
		leftTrigger = new JoystickButton(Joystick2, 7);
		outTakeFast = new JoystickButton(Joystick2, 10);
		
		da = new JoystickButton(Joystick1, 1);
		db = new JoystickButton(Joystick1, 2);
		dx = new JoystickButton(Joystick1, 3);
		dy = new JoystickButton(Joystick1, 4);
		
		forwardButton = new JoystickButton(Joystick2, 8);
		backwardButton = new JoystickButton(Joystick2, 7);
		forwardButton.whenPressed(new RiseCommandRight());
		backwardButton.whenPressed(new RiseCommandLeft());
		
		IntakeIn.whileHeld(new IntakeCommand());
		IntakeOut.whileHeld(new IntakeCommand());
	}
}