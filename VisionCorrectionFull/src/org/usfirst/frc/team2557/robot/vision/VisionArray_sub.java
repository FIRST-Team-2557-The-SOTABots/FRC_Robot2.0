package org.usfirst.frc.team2557.robot.vision;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.lang.model.element.Element;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionArray_sub extends Subsystem {
	private int widthDataCount;
	private int heightDataCount;
	private int centerXDataCount;
	private int centerYDataCount;
//	private int areaDataCount;
//	private int coveredElements;
	private int areaImageTotal;
	private double filteredArea;
	//private ArrayList<double> areaLoop;
	private double[] heights;
	private double[] areas;
	private double[] widths;
	private double[] centerYs;
	private double[] centerXs;
	private double[] areaLoop;
	private boolean inRange;
	private double maxArea;
//	private boolean _height;
//	private boolean _x;
//	private boolean _y;
//	private boolean goodToGear;
//	private boolean tooLeft;
//	private boolean tooRight;
	private boolean heightReq;
	private boolean areaReq;
	private boolean readyToShoot;
	NetworkTable table;
	

	
	
	public void initializer(){
	readyToShoot = false;
	inRange = false;
//	_height = false;
//	_x = false;
//	_y = false;
//	goodToGear = false;
//	tooLeft = false;
//	tooRight = false;
//	heightDataCount = 0;
//	areaDataCount = 0;
	widthDataCount = 0;
	centerXDataCount = 0;
	centerYDataCount = 0;
//	coveredElements = 0;
	areaImageTotal = 0;
	filteredArea = 0;
	//areaLoop = new ArrayList<double>();
	
	heights = new double[heightDataCount];
	
	areas = new double[100];
	
	centerXs = new double[centerXDataCount];
	centerYs = new double[centerYDataCount];
	widths = new double[widthDataCount];
	table = NetworkTable.getTable("GRIP/myContoursReport");
	}
	public double findHeights(){
		heights = table.getNumberArray("height", heights);
			for(double height: heights){
				SmartDashboard.putNumber("height", height);
				heightDataCount++;
				SmartDashboard.putNumber("HeightsDataCount", heights.length);
			}
			
			try{
				return heights[0];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findWidths(){
		widths = table.getNumberArray("width", widths);
			for(double width: widths){
				SmartDashboard.putNumber("width", width);
				widthDataCount++;
			}
			try{
				return widths[0];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
	}
	
	public double findCenterXs(){
			centerXs = table.getNumberArray("centerX", heights);
			for(double centerX: centerXs){
				SmartDashboard.putNumber("centerX", centerX);
				centerXDataCount++;
			}
			
			try{
				return centerXs[0];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
	
	public double findCenterYs(){
			centerYs = table.getNumberArray("centerY", centerYs);
			for(double centerY: centerYs){
				SmartDashboard.putNumber("centerY", centerY);
				centerYDataCount++;
				SmartDashboard.putNumber("centerYDataCount", centerYDataCount);
			}
			
			try{
				return centerYs[0];
			} catch(IndexOutOfBoundsException e){
				return 0;
			}
		}
	
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
			double[] areaLoopCopy = new double[6];
			double maxNumber = areaLoop[0];
			for(int i = 1; i < areaLoop.length; i++){
				if(areaLoop[i] > maxNumber){
					maxNumber = areaLoop[i];
					areaLoop[i] = 0.0;
					System.arraycopy(areaLoop, 1-8, areaLoopCopy, 1-6, 6);
				}
				double minNumber = areaLoop[0];
				for(int j = 1; j < areaLoop.length; j++){
					if(areaLoop[j] < minNumber){
						minNumber = areaLoop[j];
						
					}
				}
			}
			double minNumber
			Math.max(areaLoop[0], areaLoop[1], areaLoop[2], areaLoop[3], areaLoop[4], areaLoop[5], areaLoop[6], areaLoop[7]);
			Math.max(1, ,)
			//int minimumPoint = areaLoop.indexOf(Collections.min(areaLoop));
		    filteredArea = (areaLoop[0] + areaLoop[1] + areaLoop[2] / 3);
		    
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
	
	public void shooterAdjustment(){
		if(RobotMap.shootReq){
			RobotMap.visionShooterSpeed = (((findHeights() - 15) * 2.86) + ((findCenterXs() - 50) * 2) + ((findCenterYs() - 100) * 1.67)) / 3;				
		}
	}
		
	public void fuelInterpretation(){
		boolean _height, _x, _y;
		///////////
		if(findHeights() < 50 && findHeights() > 15){
			_height = true;
		}
		else{
			_height = false;
		}
		///////////
		if(findCenterXs() < 100 && findCenterXs() > 50){
			_x = true;
		}
		else{
			_x = false;
		}
		///////////
		if(findCenterYs() < 160 && findCenterYs() > 100){
			_y = true;
		}
		else{
			_y = false;
		}
		if(_height && _x && _y){
			RobotMap.shootReq = true;
			
		}
		//return _height && _x && _y;
		if(_height && _x && _y){
			readyToShoot = true;
			SmartDashboard.putBoolean("in shooting range!", readyToShoot);
		}
		
	}
	public void gearInterpretation(){
		boolean tooLeft = false, tooRight = false, goodToGear = false;
		//boolean tooLeft = false;
		//boolean tooRight = false;
		//boolean goodToGear = false;
		if((heights[0] > heights[1] + 3 && centerXs[0] > centerXs[1] + 3 && centerYs[0] > centerYs[1] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
			tooLeft = true;
		}
		else if((heights[1] > heights[0] + 3 && centerXs[1] > centerXs[0] + 3 && centerYs[1] > centerYs[0] + 3) && heights[0] > 20/*to be determined*/ && heights[1] > 20/*to be determined*/){
			tooRight = true;
		}
		else{
			goodToGear = true;
		}
		//return tooLeft && tooRight && goodToGear;
		if(goodToGear && tooLeft == false && tooRight == false){
			inRange = true;
			SmartDashboard.putBoolean("You are now good to place a gear.", inRange);
		}
	}
	
	
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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

