package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.Intake_cmd;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake_sub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Intake_cmd());
    }
    
    public void intake(){

//	    	if(Robot.oi.RB2.get() && (Robot.oi.gamepad2.getRawAxis(3) > 0.1 ) || Robot.oi.b2.get()){
//				RobotMap.copterAgitator.set(.5);
//				if((RobotMap.Rshooter.getEncVelocity() > Robot.psuedoShooter.getPrimeR(71) && RobotMap.Rshooter.getEncVelocity() < Robot.psuedoShooter.getPrimeR(79))
//   					|| (RobotMap.Lshooter.getEncVelocity() > Robot.psuedoShooter.getPrimeL(71)  && RobotMap.Lshooter.getEncVelocity() < Robot.psuedoShooter.getPrimeL(79)))
//				{
//					RobotMap.intake.set(-.6);
//					RobotMap.agitator.set(-.55);
//				}
//			}
    		if(Robot.oi.RB2.get() && RobotMap.Lshooter.getEncVelocity() > 3500){
    			RobotMap.intake.set(-.75);
    			RobotMap.agitator.set(-.55);
    			RobotMap.copterAgitator.set(.5);
    		}
    		else if(Robot.oi.LB2.get()){
    			RobotMap.intake.set(.6);
    			RobotMap.agitator.set(.55);
    			RobotMap.copterAgitator.set(-.5);
    		}
    		else{
    			RobotMap.intake.set(0);
    			RobotMap.agitator.set(0);
    			RobotMap.copterAgitator.set(0);
    		}
    		
   				
   				
   				
   			
    	
    }
    
    
}

