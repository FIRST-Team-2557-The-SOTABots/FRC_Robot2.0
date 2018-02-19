package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
public class OI {
	public static Joystick gamepad1;
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
	}
}
