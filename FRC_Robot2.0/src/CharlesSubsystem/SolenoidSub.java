package CharlesSubsystem;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSub extends Subsystem {
	
	
	public void SolenoidMethod1() {
		
		if (OI.ForwardButton.get()){
		RobotMap.DS1.set(Value.kForward);
		RobotMap.Position = true;
		}
		else if(OI.BackwardButton.get()) {
			RobotMap.DS1.set(Value.kReverse);
			RobotMap.Position = false;

		}
		
	}
	
	public void SolenoidAuto() {
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

