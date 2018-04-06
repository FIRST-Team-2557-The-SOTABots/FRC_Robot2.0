package src;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDetector {
private static String superString;	
public static void writeToTimeFile(){
	String LatencyString;
	FileWriter logFile;

		String InputString = new String();

		//final ProcessBuilder pb = new ProcessBuilder("java", "-version");
		


			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
				
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				
				if(superString == null){
				
				String stringAdd = "time-passed" + dateFormat.format(date) + ".txt";
				superString = "C:\\Users\\Admin\\Desktop\\" + stringAdd;
				
				
				}
				logFile = new FileWriter(superString, true);
				
				
				

				logFile.write(Detector.Final + "\r\n");
				logFile.flush();
				logFile.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		}
	


