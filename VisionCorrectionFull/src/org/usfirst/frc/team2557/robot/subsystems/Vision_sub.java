package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision_sub extends Subsystem {
public void initTables(){
	NetworkTable table;
	table = NetworkTable.getTable("GRIP/myContoursReport");



double[] defaultValue = new double[0];
while(true){
	double[] areas = table.getNumberArray("area", defaultValue);
	SmartDashboard.putString("areas", "areas: ");
	for(double area: areas){
		SmartDashboard.putNumber("area", area);
	}
}
}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

