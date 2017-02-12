package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void fuelGate(){
	    if(RobotMap.PistonUpDown.get() == Value.kReverse){
			RobotMap.PistonUpDown.set(Value.kForward);
		}
		else if (RobotMap.PistonUpDown.get() ==Value.kForward){
			RobotMap.PistonUpDown.set(Value.kReverse);
		}
    }
}

