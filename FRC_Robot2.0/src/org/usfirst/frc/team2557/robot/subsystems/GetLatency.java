package org.usfirst.frc.team2557.robot.subsystems;

import org.icmp4j.IcmpPingUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.*;

import org.icmp4j.IcmpPingRequest;
import org.icmp4j.IcmpPingResponse;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GetLatency extends Subsystem {
	private static String messageBuffer;
	public static final int maxBufferLength = 500;
	/*public static String Mem;
	private final File memoryLog = new File("memorylog.csv");*/
	Charset utf8 = StandardCharsets.UTF_8;
	//List<String> lines;

	public void logMessage(String message) {
		if(messageBuffer == null){
			messageBuffer = new String();
		}
		messageBuffer += message + "/r/n";
		System.out.println("messageBufferLength: " + messageBuffer.length());
		
		if(messageBuffer.length() > maxBufferLength || DriverStation.getInstance().getMatchTime() < 5){
		FileWriter logFile;
		//PrintWriter logWriter;
		
		try {
			String CompetitionName = DriverStation.getInstance().getEventName();
			int matchNumberInt = DriverStation.getInstance().getMatchNumber();
			
			String matchNumber = Integer.toString(matchNumberInt);
			
			String superString = "/C/" + CompetitionName + matchNumber;
			//FileWriter logFile;
			logFile = new FileWriter(superString, true);
			//logWriter = new PrintWriter(logFile);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
			return;
		}
		try {
			logFile.write(message + "\r\n");
			logFile.flush();
			logFile.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		messageBuffer = new String();

		//logWriter.println(message);
		System.out.println(message);
	}
	}
	
	public void logMemory(){
		logMessage("test1");
		logMessage("test2");
		logMessage("testA");
		logMessage("testB");
		
		logMessage(System.currentTimeMillis() + "," +(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


//		Mem = System.currentTimeMillis() + "," +(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		//Files.write(Paths.get("/C/file5.csv"), lines, utf8);	
		SmartDashboard.putString("Publishing?", "Publishing");

	}
		
		
		
//		
//		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//	              new FileOutputStream("memorylog.csv"), "utf-8"))) {
//	   writer.write("something");
//	}
//		
//		
//		
//		try {
//			Files.write(memoryLog.toPath(), System.currentTimeMillis() + "," + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()), Charset.forName("UTF-8"));
//			Files.write(System.currentTimeMillis() + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()), memoryLog, StandardCharsets.UTF_8);
//		}
//	}

	
	public void getDriverStation(){
		SmartDashboard.putString("gotThere", "You made it!");
		final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest ();
		request.setHost ("169.254.153.224");
		
		final IcmpPingResponse response = IcmpPingUtil.executePingRequest (request);
		
		final String formattedResponse = IcmpPingUtil.formatResponse (response);

		SmartDashboard.putString("firstResponse",formattedResponse);
		
		
        Runtime pingCheck = Runtime.getRuntime();
        SmartDashboard.putNumber("Free memory in JVM before Garbage Collection = ", pingCheck.freeMemory());
        pingCheck.gc();
        SmartDashboard.putNumber("Free memory in JVM after Garbage Collection = ",   pingCheck.freeMemory());
     }
     
	
	
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}



