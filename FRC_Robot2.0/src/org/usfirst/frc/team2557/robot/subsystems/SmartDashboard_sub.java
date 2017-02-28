package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.SmartDashboard_cmd;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SmartDashboard_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double _convert = 9.80665 * 3.28084;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SmartDashboard_cmd());
    }

    public void dashboard(){
//		SmartDashboard.putNumber("Lshooter encoder velocity: ", RobotMap.Lshooter.getEncVelocity());
//		SmartDashboard.putNumber("Rshooter encoder velocity: ", RobotMap.Rshooter.getEncVelocity());
//		SmartDashboard.putNumber("Gear enc is: ", RobotMap.gearEnc.get());
		//low was 52, high -673
		SmartDashboard.putNumber("X Axis: ", RobotMap.navX.getRawAccelX() * _convert);
		SmartDashboard.putNumber("Y Axis: ", RobotMap.navX.getRawAccelY() * _convert);
		SmartDashboard.putNumber("Z Axis: ", RobotMap.navX.getRawAccelZ() * _convert);
		SmartDashboard.putNumber("Left Servo: ", RobotMap.leftAgitator.getAngle());
		SmartDashboard.putNumber("Right Servo: ", RobotMap.rightAgitator.getAngle());
    }
}

