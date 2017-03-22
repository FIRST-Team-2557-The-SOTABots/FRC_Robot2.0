package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.SmartDashboard_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

    public void shooter(){
		SmartDashboard.putNumber("Lshooter encoder velocity: ", RobotMap.Lshooter.getEncVelocity());
		SmartDashboard.putNumber("Rshooter encoder velocity: ", RobotMap.Rshooter.getEncVelocity());
    }
    public void vision(){
    	SmartDashboard.putNumber("The height is: ", Robot.vision.findHeights());
    	SmartDashboard.putNumber("The X is: ", Robot.vision.findCenterXs());
    	SmartDashboard.putNumber("The Y is: ", Robot.vision.findCenterYs());
    }
    public void distance(){
    	SmartDashboard.putNumber("Eulerrrrrrrr: ", RobotMap.euler.getDistance());
    }
    public void currentDraw(){
    	SmartDashboard.putNumber("Front Left Drive is pulling current: ", RobotMap.FLdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Front Right Drive is pulling current: ", RobotMap.FRdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Back Left Drive is pulling current: ", RobotMap.BLdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Back Right Drive is pulling current: ", RobotMap.BRdrive.getOutputCurrent());
    }
    public void accelAngle(){
		SmartDashboard.putNumber("X Axis: ", RobotMap.navX.getRawAccelX() * _convert);
		SmartDashboard.putNumber("Y Axis: ", RobotMap.navX.getRawAccelY() * _convert);
		SmartDashboard.putNumber("Z Axis: ", RobotMap.navX.getRawAccelZ() * _convert);
		SmartDashboard.putNumber("Left Servo: ", RobotMap.leftAgitator.getAngle());
		SmartDashboard.putNumber("Right Servo: ", RobotMap.rightAgitator.getAngle());
    	SmartDashboard.putNumber("Camera Angle", RobotMap.cameraServo.getAngle());
    }
}

