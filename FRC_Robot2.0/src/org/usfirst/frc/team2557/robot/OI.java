/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;


import org.usfirst.frc.team2557.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team2557.robot.commands.solenoid.SolenoidCommand;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandLeft;
import org.usfirst.frc.team2557.robot.commands.wing.WingCommandRight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick Joystick1;
	public static JoystickButton ForwardButton;
	public static JoystickButton BackwardButton;
	
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
		ForwardButton = new JoystickButton(Joystick1, 6);
		BackwardButton = new JoystickButton(Joystick1, 5);
		
		ForwardButton.whenPressed(new SolenoidCommand());
		BackwardButton.whenPressed(new SolenoidCommand());
		
		Joystick2 = new Joystick(1);
		IntakeIn = new JoystickButton(Joystick2, 2);
		IntakeOut = new JoystickButton(Joystick2, 1);
		
		rightBumper = new JoystickButton(Joystick2, 5); 
		leftBumper = new JoystickButton(Joystick2, 6);
		rightTrigger = new JoystickButton(Joystick2, 8);
		leftTrigger = new JoystickButton(Joystick2, 7);
		outTakeFast = new JoystickButton(Joystick2, 10);
		
		IntakeIn.whileHeld(new IntakeCommand());
		IntakeOut.whileHeld(new IntakeCommand());
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
