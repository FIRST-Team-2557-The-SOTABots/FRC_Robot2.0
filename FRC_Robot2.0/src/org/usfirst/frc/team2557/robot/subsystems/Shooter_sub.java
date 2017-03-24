package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Shooter_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	PsuedoShooter_sub psuedo = new PsuedoShooter_sub();
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Shooter_cmd());
    }
    
    public void shooting(){
   		if(Robot.oi.gamepad2.getRawAxis(3) > .1){
   	    	RobotMap.Lshooter.set(-.75); //-.675 at 3ft making shots like a boss, -.69 to -.715 at 4ft
   	    	RobotMap.Rshooter.set(.75); //.675 at 3ft making shots like a boss, .69 to -.715 at 4ft
//   	    	RobotMap.copterAgitator.set(1);
//   	    	RobotMap.agitator.set(-.6);
   		}
   		else if(Robot.oi.b2.get()){
   			psuedo.set();
//   			RobotMap.copterAgitator.set(1);
   		}
   		else if(Robot.oi.gamepad2.getRawAxis(2) > .1){
//   			RobotMap.copterAgitator.set(-1);
//			RobotMap.agitator.set(.8);
//			Robot.agitator.leftHopper();
//			Robot.agitator.rightHopper();
   		}
   		else{
//   			RobotMap.copterAgitator.set(0);
   	    	RobotMap.Lshooter.set(0);
   	    	RobotMap.Rshooter.set(0);
//   	    	RobotMap.agitator.set(0);
   		}
    	
    }
    public void visionShooting(){
   		if(Robot.oi.gamepad2.getRawAxis(3) > .1 && RobotMap.shootReq){
   	    	RobotMap.Lshooter.set(-RobotMap.visionShooterSpeed);
   	    	RobotMap.Rshooter.set(RobotMap.visionShooterSpeed);
   	    	RobotMap.copterAgitator.set(1);
   	    	RobotMap.agitator.set(-.65);
   		}
   		else if(Robot.oi.a2.get() && RobotMap.shootReq){
   			psuedo.set();
   			RobotMap.copterAgitator.set(1);
   	    	RobotMap.agitator.set(-.65);
   		}
   		else if(Robot.oi.gamepad2.getRawAxis(2) > .1 && RobotMap.shootReq){
   			RobotMap.copterAgitator.set(-1);
			RobotMap.agitator.set(.8);
			Robot.agitator.leftHopper();
			Robot.agitator.rightHopper();
   		}
   		else{
   			RobotMap.copterAgitator.set(0);
   	    	RobotMap.Lshooter.set(0);
   	    	RobotMap.Rshooter.set(0);
   	    	RobotMap.agitator.set(0);
   		}
    }
   
}

