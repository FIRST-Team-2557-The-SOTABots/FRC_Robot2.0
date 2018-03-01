import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {
	public static void Tie(){
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	
	
	
//	String stringAdd = "robot-ping" + dateFormat.format(date) + ".txt";
//	String superString = "C:\\Users\\Admin\\Desktop\\" + stringAdd;
	
	String superString = "C:\\Users\\Admin\\Desktop\\robot-ping.txt";
	
		BufferedReader br;



	try {
		br = new BufferedReader(new FileReader(superString));
		
		 StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    System.out.println(line);

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    System.out.println(line);
		    System.out.println(everything);
		    
		    int IndexofAverage = everything.indexOf("Average");
		    
		    if(IndexofAverage >= 0){
		    	String address  = everything.substring(everything.indexOf("Average") + 10);
				address = address.substring(0, address.indexOf("\r\n"));
				
				System.out.println(address);
				
				if(address.contains("ms")){
					address = address;
				}
				else{
					String addressParse = address.substring(0, address.indexOf("s"));
					double addressParseDouble = Double.parseDouble(addressParse);
					double addressParseMultiply = addressParseDouble * 100;
					String addressParseFinal = Double.toString(addressParseMultiply);
					address = addressParseFinal;
				}
		    	
//		    	String AverageNumber = everything.substring(everything.indexOf("Average" + 4), everything.indexOf("Average" + 4));
//		    	System.out.println(AverageNumber);
		    }
		    
		    
		    
		    br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	


		
		
		
		
		
	} 
	}

