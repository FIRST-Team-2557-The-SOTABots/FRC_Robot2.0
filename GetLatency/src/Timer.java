import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {
	public void Tie(){
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	
	
	
	String stringAdd = "robot-ping" + dateFormat.format(date) + ".txt";
	String superString = "C:\\Users\\Admin\\Desktop\\" + stringAdd;
	
	BufferedReader br = new BufferedReader(new FileReader(superString));
	try {
		
		
		 StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
		
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

