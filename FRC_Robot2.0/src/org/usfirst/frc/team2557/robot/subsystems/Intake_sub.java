package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void pistonUpDown(){
    	if(RobotMap.pistonUpDown.get() == Value.kReverse){
			RobotMap.pistonUpDown.set(Value.kForward);
		}
		else if (RobotMap.pistonUpDown.get() ==Value.kForward){
			RobotMap.pistonUpDown.set(Value.kReverse);
		}
    }
    public void intakeActive(){
    	RobotMap.intake.set(.75);
    }
    public void intakeInactive(){
    	RobotMap.intake.set(0);
    }
}

