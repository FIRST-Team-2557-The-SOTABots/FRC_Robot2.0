package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2557.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	{//// CREATING BUTTONS
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
	public Joystick gamepad1;
	public Joystick gamepad2;
	
	public JoystickButton a1;
	public JoystickButton b1;
	public JoystickButton x1;
	public JoystickButton y1;
	public JoystickButton LB1;
	public JoystickButton RB1;
	public JoystickButton start1;
	public JoystickButton select1;
	public JoystickButton LJ1;
	public JoystickButton RJ1;
	
	public JoystickButton a2;
	public JoystickButton b2;
	public JoystickButton x2;
	public JoystickButton y2;
	public JoystickButton LB2;
	public JoystickButton RB2;
	public JoystickButton start2;
	public JoystickButton select2;
	public JoystickButton LJ2;
	public JoystickButton RJ2;
	
	public void init(){
		gamepad1 = new Joystick(1);
		gamepad2 = new Joystick(2);
	}
	
	
}
