package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Chassis_cmd;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double x = .75;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Chassis_cmd());
    }
    public void arcadeDrive(){
    	if(RobotMap.gemini){
        	RobotMap.robotDrive.arcadeDrive(Robot.oi.gamepad2.getRawAxis(1) *x, Robot.oi.gamepad2.getRawAxis(0) *x);
    	} else if(RobotMap.gemini == false){
        	RobotMap.robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *x);
    	}
    }
    public void tankDrive(){
    	if(RobotMap.gemini){
        	RobotMap.robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(0) *x, Robot.oi.gamepad1.getRawAxis(5) *x);
    	} else if(RobotMap.gemini == false){
        	RobotMap.robotDrive.tankDrive(-Robot.oi.gamepad1.getRawAxis(0) *x, Robot.oi.gamepad1.getRawAxis(5) *x);
    	}
    }
    public void shift_toggle(){
    	if(RobotMap.gemini){ //While gear forward is active
	    	if(Robot.oi.y1.get() && RobotMap.shifter.get() == Value.kReverse){
				RobotMap.shifter.set(Value.kForward);
				return;
			}
			else if (Robot.oi.y1.get() && RobotMap.shifter.get() ==Value.kForward){
				RobotMap.shifter.set(Value.kReverse);
				return;
			}
    	}
    	else if(RobotMap.gemini == false){ //While fuel forward is active
    		if(Robot.oi.y2.get() && RobotMap.shifter.get() == Value.kReverse){
    			RobotMap.shifter.set(Value.kForward);
    			return;
    		}
    		else if (Robot.oi.y2.get() && RobotMap.shifter.get() ==Value.kForward){
    			RobotMap.shifter.set(Value.kReverse);
    			return;
    		}
    	}
    }
    public void shift_non(){
    	if(RobotMap.gemini){ //While gear forward is active
	    	if(Robot.oi.y2.get()){// && RobotMap.shifter.get() == Value.kReverse){
				RobotMap.shifter.set(Value.kForward);
				return;
			}
			else if (Robot.oi.b2.get()){// && RobotMap.shifter.get() ==Value.kForward){
				RobotMap.shifter.set(Value.kReverse);
				return;
			}
    	}
    	else if(RobotMap.gemini == false){ //While fuel forward is active
    		if(Robot.oi.y1.get()){// && RobotMap.shifter.get() == Value.kReverse){
    			RobotMap.shifter.set(Value.kForward);
    			return;
    		}
    		else if (Robot.oi.b1.get()){// && RobotMap.shifter.get() ==Value.kForward){
    			RobotMap.shifter.set(Value.kReverse);
    			return;
    		}
    	}
    }
    
}

