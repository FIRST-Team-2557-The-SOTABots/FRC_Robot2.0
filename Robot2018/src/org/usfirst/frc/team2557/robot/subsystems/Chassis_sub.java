package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Chassis_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis_sub extends Subsystem {
	public void mecdrive() {
		RobotMap.MecDrive.driveCartesian(-Robot.oi.gamepad1.getRawAxis(1), Robot.oi.gamepad1.getRawAxis(0), Robot.oi.gamepad1.getRawAxis(4));
	}
	public void autoDrive(double rotation, double speed) {
		RobotMap.robotDrive.arcadeDrive(rotation, speed);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double x = 1;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new Chassis_cmd());
    }
    public void arcadeDrive(){
    	if(RobotMap.drive){
	    	RobotMap.robotDrive.arcadeDrive(Robot.oi.gamepad1.getRawAxis(1) *x , Robot.oi.gamepad1.getRawAxis(0) *.8);
	    }
	    else if(RobotMap.drive == false){
	    	RobotMap.robotDrive.arcadeDrive(-Robot.oi.gamepad1.getRawAxis(1) *x, Robot.oi.gamepad1.getRawAxis(0) *.8);
	    }
    }
    public void butterflyDrive() {
    	if(RobotMap.shifter.get() == Value.kReverse) {
    		RobotMap.robotDrive.tankDrive(Robot.oi.gamepad1.getRawAxis(1)*x, Robot.oi.gamepad1.getRawAxis(5)*.8);
    	}
    	else if(RobotMap.shifter.get() == Value.kForward) {
    		RobotMap.MecDrive.driveCartesian(-Robot.oi.gamepad1.getRawAxis(0)*.8,Robot.oi.gamepad1.getRawAxis(1)*.8, Robot.oi.gamepad1.getRawAxis(4)*.8);
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
    public void distanceDrive(double _distance, double _power){
    //	if(RobotMap.euler.getDistance() < _distance){
   // 		RobotMap.robotDrive.arcadeDrive(_distance, -_power);
    	}
    //	else{
    //		RobotMap.robotDrive.arcadeDrive(0,0);
    //	}
  //  }
    
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

    private double _power, _turn2;
    public void encoderDrive(double speed){
    	_power = speed;
    	_turn2 = 0;
    	if(-RobotMap.FRdrive.getSensorCollection().getQuadratureVelocity() > RobotMap.FLdrive.getSensorCollection().getQuadratureVelocity()){
    	}
    	else if(-RobotMap.FRdrive.getSensorCollection().getQuadratureVelocity() < RobotMap.FLdrive.getSensorCollection().getQuadratureVelocity()){
    	}
    	else{
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
