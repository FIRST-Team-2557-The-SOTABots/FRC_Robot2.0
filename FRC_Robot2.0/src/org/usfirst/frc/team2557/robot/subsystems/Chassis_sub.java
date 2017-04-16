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
	    	RobotMap.robotDrive.arcadeDrive(Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *.8);
	    }
	    else if(RobotMap.drive == false){
	    	RobotMap.robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *.8);
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
    	
    	if(Robot.oi.a1.get()){
    		RobotMap.drive = true;
    		return;
    	}
    	else if(Robot.oi.b1.get()){
    		RobotMap.drive = false;
    		return;
    	}
    }
    
    public void distanceDrive(double _distance, double _power){
    	if(RobotMap.euler.getDistance() < _distance){
    		RobotMap.robotDrive.arcadeDrive(_distance, -_power);
    	}
    	else{
    		RobotMap.robotDrive.arcadeDrive(0,0);
    	}
    }
    
    private double gyroOffset = 0;
    public void resetDriveStraight(){
    	gyroOffset = RobotMap.navX.getAngle();
    }
    public void driveStraight(double speed){
    	RobotMap.robotDrive.arcadeDrive(speed, -(RobotMap.navX.getAngle() - gyroOffset) * 0.2);
    }
    public double getDriveStraightAngle() {
    	return RobotMap.navX.getAngle() - gyroOffset;
    }

    private double _power, _turn1, _turn2;
    public void encoderDrive(double speed){
    	_power = speed;
    	_turn1 = 0;
    	_turn2 = 0;
    	if(-RobotMap.FRdrive.getEncVelocity() > RobotMap.FLdrive.getEncVelocity()){
    		_turn1 += .0002;
    	}
    	else if(-RobotMap.FRdrive.getEncVelocity() < RobotMap.FLdrive.getEncVelocity()){
    		_turn1 -= .0002;
    	}
    	else{
    		_turn1 += 0;
    	}
    	
    	if(RobotMap.navX.getAngle() > 1){
    		_turn2 += .00075;
    	}
    	else if(RobotMap.navX.getAngle() < -1){
    		_turn2 -= .00075;
    		
    	}
    	else{
    		_turn2 += 0;

    	}
    	RobotMap.robotDrive.arcadeDrive(_power, _turn2); // _turn1 + _turn2);
    	
    }
}

