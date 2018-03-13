package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MCP extends CommandGroup {

    public MCP() {
    	
    	double LidarData = 111;
    	
    	double VisionData = 222;
    	
    	String message1 = "";
    	
    	SmartDashboard.getString("Vision", message1);
    	
    	SmartDashboard.getNumber("LidarData", LidarData);
    	
    	SmartDashboard.getNumber("Message", VisionData);
    	
    	if(VisionData < 10){
    		Robot.DriveSub1.DiffAutoDriveMethod(.5, 0);
    	}
    	
    	
    	if(message1 == "center"){
    		Robot.DriveSub1.DiffAutoDriveMethod(0, 0);
    	}
    	else if(message1 == "left"){
    		Robot.DriveSub1.DiffAutoDriveMethod(0, -0.5);
    	}
    	else if(message1 == "right"){
    		Robot.DriveSub1.DiffAutoDriveMethod(0, 0.5);
    	}
    	else{
    		Robot.DriveSub1.DiffAutoDriveMethod(0, 0);
    	}
    	
    	
 
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
