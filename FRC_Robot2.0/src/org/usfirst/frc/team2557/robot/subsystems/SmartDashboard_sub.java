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

    public void encoders(){
		SmartDashboard.putNumber("Lshooter encoder velocity: ", RobotMap.Lshooter.getEncVelocity());
		SmartDashboard.putNumber("Rshooter encoder velocity: ", RobotMap.Rshooter.getEncVelocity());
		
		SmartDashboard.putNumber("Left encoder: ", (double) (RobotMap.FLdrive.getEncPosition()) / 1000);
		SmartDashboard.putNumber("Right encoder: ", (double) (-RobotMap.FRdrive.getEncPosition()) / 1000);
    }
//    public void vision(){
//    	SmartDashboard.putNumber("The height is: ", Robot.vision.findHeights());
//    	SmartDashboard.putNumber("The X is: ", Robot.vision.findCenterXs());
//    	SmartDashboard.putNumber("The Y is: ", Robot.vision.findCenterYs());
//    }
    public void distance(){
    	SmartDashboard.putNumber("Eulerrrrrrrr: ", RobotMap.euler.getDistance());
    }
    public void currentDraw(){
    	//Current Draw via Talons
    	SmartDashboard.putNumber("Front Left Drive is pulling current (talon): ", RobotMap.FLdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Front Right Drive is pulling current (talon): ", RobotMap.FRdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Back Left Drive is pulling current (talon): ", RobotMap.BLdrive.getOutputCurrent());
    	SmartDashboard.putNumber("Back Right Drive is pulling current (talon): ", RobotMap.BRdrive.getOutputCurrent());
    	
    	//Current Draw via PDP
    	SmartDashboard.putNumber("Front Left Drive is pulling current (pdp): ", RobotMap.pdp.getCurrent(13));
    	SmartDashboard.putNumber("Front Right Drive is pulling current (pdp): ", RobotMap.pdp.getCurrent(3));
    	SmartDashboard.putNumber("Back Left Drive is pulling current (pdp): ", RobotMap.pdp.getCurrent(15));
    	SmartDashboard.putNumber("Back Right Drive is pulling current (pdp): ", RobotMap.pdp.getCurrent(2));
    }
    public void accelAngle(){
//		SmartDashboard.putNumber("X Axis: ", RobotMap.navX.getRawAccelX() * _convert);
//		SmartDashboard.putNumber("Y Axis: ", RobotMap.navX.getRawAccelY() * _convert);
//		SmartDashboard.putNumber("Z Axis: ", RobotMap.navX.getRawAccelZ() * _convert);
//		SmartDashboard.putNumber("Left Servo: ", RobotMap.leftAgitator.getAngle());
//		SmartDashboard.putNumber("Right Servo: ", RobotMap.rightAgitator.getAngle());
//    	SmartDashboard.putNumber("Camera Angle", RobotMap.cameraServo.getAngle());
    	SmartDashboard.putNumber("Robot Angle", RobotMap.navX.getAngle());
    	
    }
}

