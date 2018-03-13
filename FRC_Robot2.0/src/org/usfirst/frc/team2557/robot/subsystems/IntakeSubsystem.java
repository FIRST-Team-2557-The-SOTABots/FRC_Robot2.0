package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	AnalogInput Ultrasonic = new AnalogInput(0);
	int raw = Ultrasonic.getValue();
	double volts = Ultrasonic.getVoltage();
	int averageRaw = Ultrasonic.getAverageValue();
	double averageVolts = Ultrasonic.getAverageVoltage();
	
	public void IntakeWithAxis(){
    	double axis;
    	axis = OI.Joystick2.getRawAxis(5);
		SmartDashboard.putNumber("IntakingCommandWithAxis!", axis);
		
		RobotMap.IntakeR.set(axis);
		RobotMap.IntakeL.set(-axis);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

