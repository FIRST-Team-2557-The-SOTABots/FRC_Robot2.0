package org.usfirst.frc.team2557.robot.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCmd extends Command {
	Timer t;
	int index = 0;

	public DriveCmd() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveSub);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.yspeed = new double[2000];
		RobotMap.xspeed = new double[2000];
		RobotMap.rotation = new double[2000];
		RobotMap.rightEncoder = new double[2000];
		RobotMap.leftEncoder = new double[2000];
		RobotMap.gyroReadings = new double[2000];
		RobotMap.time = new double[2000];
		t = new Timer();
		t.reset();
		t.start();
		//		timerA = t.get();
		//		timerB = t.get();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//    	double x = OI.gamepad1.getRawAxis(0);
		//    	double y = OI.gamepad1.getRawAxis(1);
		//    	double power = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		//    	Robot.driveSub.mecDrive(power, OI.gamepad1.getDirectionDegrees(), OI.gamepad1.getRawAxis(4));
		double timeA = t.get();
		SmartDashboard.putNumber("Timer", timeA);
		double y = OI.gamepad1.getRawAxis(0);
		double x = OI.gamepad1.getRawAxis(1);
		double r = OI.gamepad1.getRawAxis(4);
		RobotMap.mecDrive.driveCartesian(y, x, r);
		SmartDashboard.putNumber("index of data collection", index);
		if(index < 2000){
			RobotMap.time[index] = timeA; 
			RobotMap.yspeed[index] = y;
			SmartDashboard.putNumber("yspeed", RobotMap.yspeed[index]);
			RobotMap.xspeed[index] = x;
			SmartDashboard.putNumber("xspeed", RobotMap.xspeed[index]);
			RobotMap.rotation[index] = r;
			SmartDashboard.putNumber("rotation", RobotMap.rotation[index]);
			RobotMap.rightEncoder[index] = RobotMap.right2.getSensorCollection().getQuadraturePosition();
			SmartDashboard.putNumber("rightEncoder", RobotMap.rightEncoder[index]);
			RobotMap.leftEncoder[index] = RobotMap.left2.getSensorCollection().getQuadraturePosition();
			SmartDashboard.putNumber("leftEncoder", RobotMap.leftEncoder[index]);
			RobotMap.gyroReadings[index] = RobotMap.gyro.getAngle();
			SmartDashboard.putNumber("gyro", RobotMap.gyroReadings[index]);	
			index++;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(index >= 2000){
			RobotMap.mecDrive.driveCartesian(0, 0, 0);
			SmartDashboard.putNumberArray("yspeed array", RobotMap.yspeed);
			SmartDashboard.putNumberArray("xspeed array", RobotMap.xspeed);
			SmartDashboard.putNumberArray("rotation array", RobotMap.rotation);
			SmartDashboard.putNumberArray("rightEncoder array", RobotMap.rightEncoder);
			SmartDashboard.putNumberArray("leftEncoder array", RobotMap.leftEncoder);
			SmartDashboard.putNumberArray("gyro array", RobotMap.gyroReadings);
			SmartDashboard.putNumberArray("time array", RobotMap.time);

			PrintWriter writer;
			try {
				writer = new PrintWriter("pathdata.txt", "UTF-8");
				List<String> lines = Arrays.asList("yspeed" + ", " + RobotMap.yspeed.toString(), "xspeed" + ", " + RobotMap.xspeed.toString(), "rotation" + ", " + RobotMap.rotation.toString(), "rightEncoder" + ", " + RobotMap.rightEncoder.toString(), "leftEncoder" + ", " + RobotMap.leftEncoder.toString(), "gyro" +", " + RobotMap.gyroReadings.toString());
				for(int i = 0; i < lines.size(); i++){
					writer.println(lines.get(i));
				}
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
