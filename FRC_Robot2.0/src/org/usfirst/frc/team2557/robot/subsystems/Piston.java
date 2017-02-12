package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Piston extends Subsystem {
	public void PistonControl(){

		if(RobotMap.PistonUpdown.get() == Value.kReverse){
			RobotMap.PistonUpdown.set(Value.kForward);
		}
		else if (RobotMap.PistonUpdown.get() ==Value.kForward){
			RobotMap.PistonUpdown.set(Value.kReverse);
		}
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}