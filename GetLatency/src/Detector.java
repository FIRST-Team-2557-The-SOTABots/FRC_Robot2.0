import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Detector {
public static void main (String args[]){
	//final ProcessBuilder pb = new ProcessBuilder("java", "-version");
	
	try {
		Process p = Runtime.getRuntime().exec("ping youtube.com");
		System.out.println(p);
		InputStream Latency = p.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(Latency, "UTF-8"));
		String LatencyString = reader.readLine();
		
		int start = LatencyString.indexOf("\'");
		int end = LatencyString.lastIndexOf("\'");
		
		
		int currentChar = 0;
		System.out.println(currentChar);
		
		currentChar = Latency.read();
		System.out.println(currentChar);
		
		String InputString = new String();
		
		
		//String maskAddress;
		while (currentChar >= 0) {
			if ((char)currentChar != '\n') {
				InputString += (char) currentChar;
				System.out.println("Here!");
				System.out.println(currentChar);

			}
			else{
				System.out.println(InputString);
				System.out.println("There!");
			}
		}
			
			
		
		
		
		String substring = LatencyString.substring(start + 1, end + 1);
		String[] split = substring.split("\\.");
		
		System.out.println(substring);
		System.out.println(split);
		
		
		//return new Pair<>(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		
		

		System.out.println(LatencyString);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
