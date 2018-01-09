package org.usfirst.frc.team2557.robot;


import org.usfirst.frc.team2557.robot.commands.GearGrab_toggle;
import org.usfirst.frc.team2557.robot.commands.Shift_toggle;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


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
		gamepad1 = new Joystick(0);
		gamepad2 = new Joystick(1);
		
		a1 = new JoystickButton(gamepad1, 1);
		b1 = new JoystickButton(gamepad1, 2);
		x1 = new JoystickButton(gamepad1, 3);
		y1 = new JoystickButton(gamepad1, 4);
		LB1 = new JoystickButton(gamepad1,5);
		RB1 = new JoystickButton(gamepad1, 6);
		start1 = new JoystickButton(gamepad1, 7);
		select1 = new JoystickButton(gamepad1, 8);
		LJ1 = new JoystickButton(gamepad1, 9);
		RJ1 = new JoystickButton(gamepad1, 10);

		a2 = new JoystickButton(gamepad2, 1);
		b2 = new JoystickButton(gamepad2, 2);
		x2 = new JoystickButton(gamepad2, 3);
		y2 = new JoystickButton(gamepad2, 4);
		LB2 = new JoystickButton(gamepad2, 5);
		RB2 = new JoystickButton(gamepad2, 6);
		start2 = new JoystickButton(gamepad2, 7);
		select2 = new JoystickButton(gamepad2, 8);
		LJ2 = new JoystickButton(gamepad2, 9);
		RJ2 = new JoystickButton(gamepad2, 10);
		
//		RB2.whenPressed(new GearGrab_toggle());
		//RB1.whenPressed(new Shift_toggle());

	}
	
	
}
