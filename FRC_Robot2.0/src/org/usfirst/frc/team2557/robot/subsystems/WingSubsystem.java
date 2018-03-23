package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WingSubsystem extends Subsystem {

	public void Wings() {
		if(OI.leftBumper.get() == true && OI.rightBumper.get() == true) {
			RobotMap.LeftWing.set(1);
			RobotMap.RightWing.set(1);
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new WingCommand());
    }
}
