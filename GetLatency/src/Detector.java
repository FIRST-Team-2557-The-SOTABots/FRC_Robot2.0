import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Detector {
	private static String LatencyString;
	private static FileWriter logFile;
	public static void main (String args[]){

		String InputString = new String();

		//final ProcessBuilder pb = new ProcessBuilder("java", "-version");
		while(true){
			try {
				Process p = Runtime.getRuntime().exec("ping youtube.com");
				System.out.println(p);
				InputStream Latency = p.getInputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(Latency, "UTF-8"));
				//LatencyString = reader.readLine();

//				int start = LatencyString.indexOf("\'");
//				int end = LatencyString.lastIndexOf("\'");


				int currentChar = 0;
				System.out.println(currentChar);

				currentChar = Latency.read();
				System.out.println(currentChar);


				//String maskAddress;
				while (currentChar >= 0) {
					//			if ((char)currentChar != '\r') {
					//				InputString += (char) currentChar;
					//				System.out.println("Here!");
					//				System.out.println(currentChar);
					//
					//			}
					//			else{
					//				System.out.println(InputString);
					//				System.out.println("There!");
					//			}
					InputString += (char) currentChar;
					currentChar = Latency.read();
				}

				LatencyString = InputString;
				System.out.println(LatencyString);
				InputString = new String();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
				
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				
				String stringAdd = "robot-ping" + dateFormat.format(date) + ".txt";
				String superString = "C:\\Users\\Admin\\Desktop\\" + stringAdd;
				logFile = new FileWriter(superString, true);

				logFile.write(LatencyString + "\r\n");
				logFile.flush();
				logFile.close();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			LatencyString = new String();

			//		String substring = LatencyString.substring(start + 1, end);
			//		String[] split = substring.split("\\.");
			//		
			//		System.out.println(substring);
			//		System.out.println(split);


			//return new Pair<>(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

		}
	}
}
