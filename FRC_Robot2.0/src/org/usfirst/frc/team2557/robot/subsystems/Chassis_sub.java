package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Chassis_cmd;
import org.usfirst.frc.team2557.robot.math.EulerDistanceEstimator;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double x = 1;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new Chassis_cmd());
    }
    public void arcadeDrive(){
	    if(RobotMap.drive){
	    	RobotMap.robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *x);
	    }
	    else if(RobotMap.drive == false){
	    	RobotMap.robotDrive.arcadeDrive(Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *.8);
	    }
    }
    public void shift_toggle(){
    		if(RobotMap.shift){
    			RobotMap.shifter.set(Value.kForward);
    			RobotMap.shift = false;
    		}
    		else if (RobotMap.shift == false){
    			RobotMap.shifter.set(Value.kReverse);
    			RobotMap.shift = true;
    		}
    	
    }
    public void gemini(){
    	if(Robot.oi.gamepad2.getPOV() == 0){
    		RobotMap._gemini = true;
    		return;
    	}
    	else if(Robot.oi.gamepad2.getPOV() == 180){
    		RobotMap._gemini = false;
    		return;
    	}
    	
    	if(Robot.oi.gamepad1.getPOV() == 0){
    		RobotMap.drive = true;
    		return;
    	}
    	else if(Robot.oi.gamepad1.getPOV() == 180){
    		RobotMap.drive = false;
    		return;
    	}
    }
    
    public void distanceDrive(){
    	if(RobotMap.euler.getDistance() < 150){
    		RobotMap.robotDrive.arcadeDrive(-.5,0);
    	}
    	else{
    		RobotMap.robotDrive.arcadeDrive(0,0);
    	}
    }
    
    
}

