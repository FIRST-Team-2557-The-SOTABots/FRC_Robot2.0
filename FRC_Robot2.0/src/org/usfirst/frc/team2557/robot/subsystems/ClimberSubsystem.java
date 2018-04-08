package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.climber.ClimbCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimbCommand());
    }
    
    public void climb(){
		double axis = OI.Joystick2.getRawAxis(5);
		
		RobotMap.ClimbLeft.set(-axis*0.8);
		RobotMap.ClimbRight.set(-axis*0.8);
		
		SmartDashboard.putNumber("This is Climbing", axis);
	}
}

