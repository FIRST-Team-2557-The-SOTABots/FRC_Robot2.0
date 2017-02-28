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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Shooter_cmd());
    }
    
    public void shooting(){
   		if(Robot.oi.gamepad1.getRawAxis(3) > 0.1){
   	    	RobotMap.Lshooter.set(-.65);
   	    	RobotMap.Rshooter.set(.65);
   	    	RobotMap.copterAgitator.set(1);
   	    	RobotMap.agitator.set(-.8);
   		}
   		else if(Robot.oi.gamepad1.getRawAxis(2) > 0.1){
   			RobotMap.copterAgitator.set(-1);
			RobotMap.agitator.set(.8);
   		}
   		else{
   			RobotMap.copterAgitator.set(0);
   	    	RobotMap.Lshooter.set(0);
   	    	RobotMap.Rshooter.set(0);
   	    	RobotMap.agitator.set(0);
   		}
    	
    }
    public void moses_non(){ //non-toggle code
   		if(Robot.oi.a1.get()){
   			RobotMap.pistonUpDown.set(Value.kForward);
   			return;
   		}
   		else if(Robot.oi.x1.get()){
   			RobotMap.pistonUpDown.set(Value.kReverse);
   			return;
   		}
    }
    public void moses_toggle(){ //Toggle code
   		if(RobotMap.wall){
			RobotMap.pistonUpDown.set(Value.kForward);
			RobotMap.wall = false;
		}
		else if (RobotMap.wall == false){
			RobotMap.pistonUpDown.set(Value.kReverse);
			RobotMap.wall = true;
		}
    }
}

