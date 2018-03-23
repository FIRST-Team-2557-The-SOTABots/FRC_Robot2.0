package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends Subsystem {
	
//	int raw = Ultrasonic.getValue();
//	double volts = Ultrasonic.getVoltage();
//	int averageRaw = Ultrasonic.getAverageValue();
//	double averageVolts = Ultrasonic.getAverageVoltage();
	
	
	public void IntakeWithButtons(){
		double axisRight = OI.Joystick2.getRawAxis(3);		
		double axisLeft = OI.Joystick2.getRawAxis(2);
		
		SmartDashboard.putNumber("TriggerLeft", axisLeft);
		SmartDashboard.putNumber("TriggerRight", axisRight);
    	
		if(OI.IntakeIn.get()) {
			RobotMap.IntakeR.set(-.8);
			RobotMap.IntakeL.set(.8);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
			//			RobotMap.S2.set(false);
		}else if(axisLeft > 0.8){
			RobotMap.IntakeR.set(-.3);
			RobotMap.IntakeL.set(.3);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
		}else if(OI.IntakeOut.get()){
			RobotMap.IntakeR.set(.4);
			RobotMap.IntakeL.set(-.4);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
			//			RobotMap.S2.set(true);
		}else if(axisRight > 0.8){
			RobotMap.IntakeR.set(.15);
			RobotMap.IntakeL.set(-.15);
			RobotMap.S2.set(false);
			RobotMap.S1.set(true);
		}else {
			RobotMap.IntakeR.set(0);
			RobotMap.IntakeL.set(0);
			RobotMap.S2.set(true);
			RobotMap.S1.set(false);
		}
	}
	
	public void IntakeWithAxis(){
    	double axis = OI.Joystick2.getRawAxis(5);
    	
		double axisRight2 = OI.Joystick2.getRawAxis(3);		
		double axisLeft2 = OI.Joystick2.getRawAxis(2);
		
		SmartDashboard.putNumber("TriggerLeft2", axisLeft2);
		SmartDashboard.putNumber("TriggerRight2", axisRight2);
		RobotMap.IntakeR.set(axis);
		RobotMap.IntakeL.set(-axis);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeCommand());
    }
}

