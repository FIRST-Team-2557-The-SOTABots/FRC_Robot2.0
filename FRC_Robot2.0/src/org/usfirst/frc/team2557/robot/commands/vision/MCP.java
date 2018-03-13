package org.usfirst.frc.team2557.robot.commands.vision;

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
    		Robot.DriveSubsystem.DiffAutoDriveMethod(.5, 0);
    	}
    	
    	
    	if(message1 == "center"){
    		Robot.DriveSubsystem.DiffAutoDriveMethod(0, 0);
    	}
    	else if(message1 == "left"){
    		Robot.DriveSubsystem.DiffAutoDriveMethod(0, -0.5);
    	}
    	else if(message1 == "right"){
    		Robot.DriveSubsystem.DiffAutoDriveMethod(0, 0.5);
    	}
    	else{
    		Robot.DriveSubsystem.DiffAutoDriveMethod(0, 0);
    	}
    }
}
