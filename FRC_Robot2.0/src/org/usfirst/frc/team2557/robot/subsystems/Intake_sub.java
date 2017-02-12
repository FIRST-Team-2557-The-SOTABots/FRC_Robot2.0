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
    public void fuelGate(){
    	if(RobotMap.fuelGate.get() == Value.kReverse){
			RobotMap.fuelGate.set(Value.kForward);
		}
		else if (RobotMap.fuelGate.get() ==Value.kForward){
			RobotMap.fuelGate.set(Value.kReverse);
		}
    }
    public void intakeActive(){
    	RobotMap.intake.set(.75);
    }
    public void intakeInactive(){
    	RobotMap.intake.set(0);
    }
}

