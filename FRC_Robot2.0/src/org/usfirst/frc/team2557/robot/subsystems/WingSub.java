package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WingSub extends Subsystem {

	public void Wings() {
		if(OI.WingL.get() == true && OI.WingR.get() == true) {
			RobotMap.LeftWing.set(1);
			RobotMap.RightWing.set(1);
			SmartDashboard.putBoolean("Mothman activated", true);
		}
		else {
			SmartDashboard.putBoolean("Mothman inactive", true);
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

