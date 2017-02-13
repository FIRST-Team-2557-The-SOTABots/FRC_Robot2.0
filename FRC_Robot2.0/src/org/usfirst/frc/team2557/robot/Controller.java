package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controller {
	/*
	 * Using constants can improve readability and maintenance.
	 * Generally, they are public (anyone can access them), static (scope,
	 * only one in the class), and final (can't be changed).
	 * 
	 * Values of the buttons on the joystick.
	 */
	public static final int BUTTONA      = 1;
	public static final int BUTTONB      = 2;
	public static final int BUTTONX      = 3;
	public static final int BUTTONY      = 4;
	public static final int BUTTONLB     = 5;
	public static final int BUTTONRB     = 6;
	public static final int BUTTONSTART  = 7;
	public static final int BUTTONSELECT = 8;
	public static final int BUTTONLJ     = 9;
	public static final int BUTTONRJ     = 10;
	
	/*
	 * Used to set up an array holding all the buttons.
	 */
	public static final int MAXBUTTONS   = 10;
	
	/*
	 * Only the controller can change this, and there is only one accessible
	 * from all controller objects.
	 */
	private static int      currentJoystick = 0;
	
	/*
	 * Only the controller can change these, and there is one of each of
	 * these for each controller object.
	 */
	private Joystick        joystick;
	private JoystickButton  buttons[];

	/*
	 * Class constructor - called when created.
	 */
	public Controller() {
		// Create a joystick.
		joystick = new Joystick(currentJoystick);
		
		// Increment so each controller is unique.
		currentJoystick++;
		
		// Create the array of buttons.
		buttons = new JoystickButton[MAXBUTTONS];
		
		/*
		 * Works until the button constants change.
		 */
		for (int i = 0; i < MAXBUTTONS; i++) {
			// Create a joystick button for each button.
			buttons[i] = new JoystickButton(joystick, i+1);
		}
	}

	/*
	 * Get a JoystickButton object.
	 */
	public JoystickButton getButton(int button) {
		return buttons[button];
	}	
	
	public Joystick getJoystick() {
		return joystick;
	}
}
