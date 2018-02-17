package CharlesSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSub extends Subsystem {

	AnalogInput Ultrasonic = new AnalogInput(0);
	int raw = Ultrasonic.getValue();
	double volts = Ultrasonic.getVoltage();
	int averageRaw = Ultrasonic.getAverageValue();
	double averageVolts = Ultrasonic.getAverageVoltage();
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

