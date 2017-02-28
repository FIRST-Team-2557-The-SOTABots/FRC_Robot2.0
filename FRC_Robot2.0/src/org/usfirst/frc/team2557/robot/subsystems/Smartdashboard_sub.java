package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Smartdashboard_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void dashboard(){
//		SmartDashboard.putNumber("Lshooter encoder velocity: ", RobotMap.Lshooter.getEncVelocity());
//		SmartDashboard.putNumber("Rshooter encoder velocity: ", RobotMap.Rshooter.getEncVelocity());
//		SmartDashboard.putNumber("Gear enc is: ", RobotMap.gearEnc.get());
		//low was 52, high -673
		SmartDashboard.putNumber("X Axis: ", RobotMap.accelerometer.getRawAccelX());
		SmartDashboard.putNumber("Y Axis: ", RobotMap.accelerometer.getRawAccelY());
		SmartDashboard.putNumber("Z Axis: ", RobotMap.accelerometer.getRawAccelZ());
		SmartDashboard.putNumber("Left Servo: ", RobotMap.leftAgitator.getAngle());
		SmartDashboard.putNumber("Right Servo: ", RobotMap.rightAgitator.getAngle());
    }
}

