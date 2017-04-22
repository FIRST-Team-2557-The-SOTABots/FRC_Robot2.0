package org.usfirst.frc.team2557.robot.vision;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionArray_sub extends Subsystem {
	public int widthDataCount;
	public int heightDataCount;
	public int centerXDataCount;
	public int centerYDataCount;
//	public int areaDataCount;
//	public int coveredElements;
	public int areaImageTotal;
	public double filteredArea;
	public double[] areaLoop;
	public double[] heights;
	public static double[] areas;
	public static double[] widths;
	public double[] centerYs;
	public double[] centerXs;
	public boolean heightReq;
	public boolean areaReq;
	NetworkTable table;
	
	
	public void initializer(){
	heightDataCount = 0;
//	areaDataCount = 0;
	widthDataCount = 0;
	centerXDataCount = 0;
	centerYDataCount = 0;
//	coveredElements = 0;
	areaImageTotal = 0;
	filteredArea = 0;
	areaLoop = new double[3];
	heights = new double[heightDataCount];
	
	areas = new double[100];
	
	centerXs = new double[centerXDataCount];
	centerYs = new double[centerYDataCount];
	widths = new double[widthDataCount];
	table = NetworkTable.getTable("GRIP/myContoursReport");
	}
	public double findHeights(int n){
		heights = table.getNumberArray("height", heights);
			for(double height: heights){
				SmartDashboard.putNumber("height", height);
				heightDataCount++;
				SmartDashboard.putNumber("HeightsDataCount", heights.length);
			}
			
			try{
				return heights[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findWidths(int n){
		widths = table.getNumberArray("width", widths);
			for(double width: widths){
				SmartDashboard.putNumber("width", width);
				widthDataCount++;
			}
			try{
				return widths[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findCenterXs(int n){
			centerXs = table.getNumberArray("centerX", heights);
			for(double centerX: centerXs){
				SmartDashboard.putNumber("centerX", centerX);
				centerXDataCount++;
			}
			
			try{
				return centerXs[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
	
	public double findCenterYs(int n){
			centerYs = table.getNumberArray("centerY", centerYs);
			for(double centerY: centerYs){
				SmartDashboard.putNumber("centerY", centerY);
				centerYDataCount++;
				SmartDashboard.putNumber("centerYDataCount", centerYDataCount);
			}
			
			try{
				return centerYs[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
/*	
	public void findAreas(){
		int areaDataCount = 0;
		int coveredElements = 0;
		
		areas = table.getNumberArray("area", areas);
		areaDataCount = areas.length;
		
//		boolean isElse = false;

		SmartDashboard.putNumber("ADC", areaDataCount);

		if (areas.length > 0 && areas.length > areaImageTotal) {
			areaLoop[areaImageTotal++] = areas[0];
		}
		
		SmartDashboard.putNumber("areaImageTotal", areaImageTotal);

		if (areaImageTotal > 2) {
		    filteredArea = (areaLoop[0] + areaLoop[1] + areaLoop[2]) / 3;
		    areaImageTotal = 0;
		}
		else {
			if (areaImageTotal == 1) {
				filteredArea = areaLoop[0];
			}
			else {
				if (areaImageTotal != 0) {
					filteredArea = (areaLoop[0] + areaLoop[1]) / 2;
				}
				else {
					filteredArea = 0.0;
				}
			}
		}

//		isElse = true;
		SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
		
//		if(areaImageTotal < 3){
//			SmartDashboard.putNumber("ADC", areaDataCount);
//			for(double area: areas){
//				SmartDashboard.putNumber("area", area);
//				if (areaLoop.length > coveredElements) {
//				    areaLoop[coveredElements] = area;
//				    areaImageTotal++;
//				} else{
//					System.out.println("areaLoop length is less than coverElements");
//				}
//				coveredElements++;
//			}
//			SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
//		}
//		else{
//			filteredArea = (areaLoop[0] + areaLoop[1] + areaLoop[3]) / 3;
//			isElse = true;
//			SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
//		}
//
//		if(isElse){
//			SmartDashboard.putBoolean("isElse", isElse);
//		}
//		else{
//			System.out.println("failed");
//		}
		SmartDashboard.putNumber("filteredArea", filteredArea);
	}
*/
//	public void shooterAdjustment(){
//		if(RobotMap.shootReq){
//			RobotMap.visionShooterSpeed = (((findHeights() - 15) * 2.86) + ((findCenterXs() - 50) * 2) + ((findCenterYs() - 100) * 1.67)) / 3;				
//		}
//	}
//		
	
/*
 The Code below can be used to look at any one contour to determine if it is within the
 correct position. Right now I (Antonio) am trying to figure out how to make the thresholds modular  
  
 */
	public boolean singleInterpretation(int x, int n, double hPrime, double xPrime, double yPrime, double offset){
		boolean _height, _x, _y;
		///////////
		if(findHeights(n) < hPrime + (hPrime * offset) && findHeights(n) > hPrime - (hPrime * offset)){
			_height = true;
		}
		else{
			_height = false;
		}
		///////////
		if(findCenterXs(n) < xPrime + (xPrime * offset) && findCenterXs(n) > xPrime - (xPrime * offset)){
			_x = true;
		}
		else{
			_x = false;
		}
		///////////
		if(findCenterYs(n) < yPrime + (yPrime * offset) && findCenterYs(n) > yPrime - (yPrime * offset)){
			_y = true;
		}
		else{
			_y = false;
		}
		
		
		switch(x){
			default:
				return _x && _y && _height;
			case 1:
				return _height;
			case 2:
				return _x;
			case 3:
				return _y;
		}
	}
	public boolean averageInterpretation(int x, int n, double hPrime, double xPrime, double yPrime, double offset){
		boolean _height, _x, _y;
		///////////
		if(findHeights(n) < hPrime + (hPrime * offset) && findHeights(n) > hPrime - (hPrime * offset)){
			_height = true;
		}
		else{
			_height = false;
		}
		///////////
		if((findCenterXs(n) + findCenterXs(n + 1))/2 < xPrime + (xPrime * offset) && (findCenterXs(n) + findCenterXs(n + 1))/2 > xPrime - (xPrime * offset)){
			_x = true;
		}
		else{
			_x = false;
		}
		///////////
		if(findCenterYs(n) < yPrime + (yPrime * offset) && findCenterYs(n) > yPrime - (yPrime * offset)){
			_y = true;
		}
		else{
			_y = false;
		}
		
		
		switch(x){
			default:
				return _x && _y && _height;
			case 1:
				return _height;
			case 2:
				return _x;
			case 3:
				return _y;
		}
	}


	
	
/* 
 The code below should be manipulated in order to thoroughly compare
 two or more contours 
 */
//	public boolean gearInterpretation(){
//		boolean tooLeft = false;
//		boolean tooRight = false;
//		boolean goodToGear = false;
//		if((heights[0] > heights[1] + 3 && centerXs[0] > centerXs[1] + 3 && centerYs[0] > centerYs[1] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
//			tooLeft = true;
//		}
//		else if((heights[1] > heights[0] + 3 && centerXs[1] > centerXs[0] + 3 && centerYs[1] > centerYs[0] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
//			tooRight = true;
//		}
//		else{
//			goodToGear = true;
//		}
//		return tooLeft && tooRight && goodToGear;
//	}
//	
	
	
	
	
	
	
	
	
	
//	public void interpretCamera(){
//	if(areas.length > 0 && widthDataCount > 0 && heightDataCount > 0 && centerXDataCount > 0 && centerYDataCount > 0){
//		
//		
//		
//		if(heights[0] > heights[1]){
//			if(heights[0] > 100 && heights[0] < 120){
//				boolean heightReq = true;
//			}
//		}
//		
//		
//		
//		if(areas[0] > areas[1]){
//			if(areas[0] > 3000 && areas[0] < 3500){
//				boolean areaReq = true;
//			}
//		}
//		
//		if(heightReq && areaReq){
//			RobotMap.shootReq = true;
//		}
//	}
//	SmartDashboard.putBoolean("shootBool", RobotMap.shootReq);
//		
//	}
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public int widthDataCount2;
	public int heightDataCount2;
	public int centerXDataCount2;
	public int centerYDataCount2;
//	public int areaDataCount;
//	public int coveredElements;
	public int areaImageTotal2;
	public double filteredArea2;
	public double[] areaLoop2;
	public double[] heights2;
	public static double[] areas2;
	public static double[] widths2;
	public double[] centerYs2;
	public double[] centerXs2;
	public boolean heightReq2;
	public boolean areaReq2;
	NetworkTable table2;
	
	
	public void initializer2(){
	heightDataCount2 = 0;
//	areaDataCount = 0;
	widthDataCount2 = 0;
	centerXDataCount2 = 0;
	centerYDataCount2 = 0;
//	coveredElements = 0;
	areaImageTotal2 = 0;
	filteredArea2 = 0;
	areaLoop2 = new double[3];
	heights2 = new double[heightDataCount];
	
	areas2 = new double[100];
	
	centerXs2 = new double[centerXDataCount];
	centerYs2 = new double[centerYDataCount];
	widths2 = new double[widthDataCount];
	table2 = NetworkTable.getTable("GRIP/myContoursReport2");
	}
	public double findHeights2(int n){
		heights = table.getNumberArray("height", heights);
			for(double height: heights){
				SmartDashboard.putNumber("height", height);
				heightDataCount++;
				SmartDashboard.putNumber("HeightsDataCount", heights.length);
			}
			
			try{
				return heights2[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findWidths2(int n){
		widths2 = table2.getNumberArray("width", widths);
			for(double width: widths2){
				SmartDashboard.putNumber("width", width);
				widthDataCount2++;
			}
			try{
				return widths2[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findCenterXs2(int n){
			centerXs2 = table2.getNumberArray("centerX", heights2);
			for(double centerX: centerXs2){
				SmartDashboard.putNumber("centerX", centerX);
				centerXDataCount2++;
			}
			
			try{
				return centerXs[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
	
	public double findCenterYs2(int n){
			centerYs2 = table.getNumberArray("centerY", centerYs);
			for(double centerY: centerYs2){
				SmartDashboard.putNumber("centerY", centerY);
				centerYDataCount2++;
				SmartDashboard.putNumber("centerYDataCount", centerYDataCount);
			}
			
			try{
				return centerYs2[n];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
/*	
	public void findAreas(){
		int areaDataCount = 0;
		int coveredElements = 0;
		
		areas = table.getNumberArray("area", areas);
		areaDataCount = areas.length;
		
//		boolean isElse = false;

		SmartDashboard.putNumber("ADC", areaDataCount);

		if (areas.length > 0 && areas.length > areaImageTotal) {
			areaLoop[areaImageTotal++] = areas[0];
		}
		
		SmartDashboard.putNumber("areaImageTotal", areaImageTotal);

		if (areaImageTotal > 2) {
		    filteredArea = (areaLoop[0] + areaLoop[1] + areaLoop[2]) / 3;
		    areaImageTotal = 0;
		}
		else {
			if (areaImageTotal == 1) {
				filteredArea = areaLoop[0];
			}
			else {
				if (areaImageTotal != 0) {
					filteredArea = (areaLoop[0] + areaLoop[1]) / 2;
				}
				else {
					filteredArea = 0.0;
				}
			}
		}

//		isElse = true;
		SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
		
//		if(areaImageTotal < 3){
//			SmartDashboard.putNumber("ADC", areaDataCount);
//			for(double area: areas){
//				SmartDashboard.putNumber("area", area);
//				if (areaLoop.length > coveredElements) {
//				    areaLoop[coveredElements] = area;
//				    areaImageTotal++;
//				} else{
//					System.out.println("areaLoop length is less than coverElements");
//				}
//				coveredElements++;
//			}
//			SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
//		}
//		else{
//			filteredArea = (areaLoop[0] + areaLoop[1] + areaLoop[3]) / 3;
//			isElse = true;
//			SmartDashboard.putNumber("areaImageTotal", areaImageTotal);
//		}
//
//		if(isElse){
//			SmartDashboard.putBoolean("isElse", isElse);
//		}
//		else{
//			System.out.println("failed");
//		}
		SmartDashboard.putNumber("filteredArea", filteredArea);
	}
*/
//	public void shooterAdjustment(){
//		if(RobotMap.shootReq){
//			RobotMap.visionShooterSpeed = (((findHeights() - 15) * 2.86) + ((findCenterXs() - 50) * 2) + ((findCenterYs() - 100) * 1.67)) / 3;				
//		}
//	}
//		
	
/*
 The Code below can be used to look at any one contour to determine if it is within the
 correct position. Right now I (Antonio) am trying to figure out how to make the thresholds modular  
  
 */
	public boolean singleInterpretation2(int x, int n, double hPrime, double xPrime, double yPrime, double offset){
		boolean _height, _x, _y;
		///////////
		if(findHeights(n) < hPrime + (hPrime * offset) && findHeights(n) > hPrime - (hPrime * offset)){
			_height = true;
		}
		else{
			_height = false;
		}
		///////////
		if(findCenterXs(n) < xPrime + (xPrime * offset) && findCenterXs(n) > xPrime - (xPrime * offset)){
			_x = true;
		}
		else{
			_x = false;
		}
		///////////
		if(findCenterYs(n) < yPrime + (yPrime * offset) && findCenterYs(n) > yPrime - (yPrime * offset)){
			_y = true;
		}
		else{
			_y = false;
		}
		
		
		switch(x){
			default:
				return _x && _y && _height;
			case 1:
				return _height;
			case 2:
				return _x;
			case 3:
				return _y;
		}
	}
	public boolean averageInterpretation2(int x, int n, double hPrime, double xPrime, double yPrime, double offset){
		boolean _height, _x, _y;
		///////////
		if(findHeights(n) < hPrime + (hPrime * offset) && findHeights(n) > hPrime - (hPrime * offset)){
			_height = true;
		}
		else{
			_height = false;
		}
		///////////
		if((findCenterXs(n) + findCenterXs(n + 1))/2 < xPrime + (xPrime * offset) && (findCenterXs(n) + findCenterXs(n + 1))/2 > xPrime - (xPrime * offset)){
			_x = true;
		}
		else{
			_x = false;
		}
		///////////
		if(findCenterYs(n) < yPrime + (yPrime * offset) && findCenterYs(n) > yPrime - (yPrime * offset)){
			_y = true;
		}
		else{
			_y = false;
		}
		
		
		switch(x){
			default:
				return _x && _y && _height;
			case 1:
				return _height;
			case 2:
				return _x;
			case 3:
				return _y;
		}
	}


	
	
/* 
 The code below should be manipulated in order to thoroughly compare
 two or more contours 
 */
//	public boolean gearInterpretation(){
//		boolean tooLeft = false;
//		boolean tooRight = false;
//		boolean goodToGear = false;
//		if((heights[0] > heights[1] + 3 && centerXs[0] > centerXs[1] + 3 && centerYs[0] > centerYs[1] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
//			tooLeft = true;
//		}
//		else if((heights[1] > heights[0] + 3 && centerXs[1] > centerXs[0] + 3 && centerYs[1] > centerYs[0] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
//			tooRight = true;
//		}
//		else{
//			goodToGear = true;
//		}
//		return tooLeft && tooRight && goodToGear;
//	}
//	
	
	
	
	
	
	
	
	
	
//	public void interpretCamera(){
//	if(areas.length > 0 && widthDataCount > 0 && heightDataCount > 0 && centerXDataCount > 0 && centerYDataCount > 0){
//		
//		
//		
//		if(heights[0] > heights[1]){
//			if(heights[0] > 100 && heights[0] < 120){
//				boolean heightReq = true;
//			}
//		}
//		
//		
//		
//		if(areas[0] > areas[1]){
//			if(areas[0] > 3000 && areas[0] < 3500){
//				boolean areaReq = true;
//			}
//		}
//		
//		if(heightReq && areaReq){
//			RobotMap.shootReq = true;
//		}
//	}
//	SmartDashboard.putBoolean("shootBool", RobotMap.shootReq);
//		
//	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

