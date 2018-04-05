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
public static void writeToTimeFile(){
	String LatencyString;
	FileWriter logFile;

		String InputString = new String();

		//final ProcessBuilder pb = new ProcessBuilder("java", "-version");
			long lStartTime = System.nanoTime();
			


			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
				
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				
				String stringAdd = "time-passed" + dateFormat.format(date) + ".txt";
				String superString = "C:\\Users\\Michael\\Desktop\\" + stringAdd;
				logFile = new FileWriter(superString, true);
				
				long lEndTime = System.nanoTime();
				long lFinalTime;
				lFinalTime = lEndTime - lStartTime;
				
				

				logFile.write(lFinalTime + "\r\n");
				logFile.flush();
				logFile.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		}
	


