package org.usfirst.frc.team2557.robot.vision;

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
	private double[] areaLoop;
	private double[] heights;
	private double[] areas;
	private double[] widths;
	private double[] centerYs;
	private double[] centerXs;
	private boolean heightReq;
	private boolean areaReq;
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
	public void findHeights(){
		heights = table.getNumberArray("height", heights);
			for(double height: heights){
				SmartDashboard.putNumber("height", height);
				heightDataCount++;
				SmartDashboard.putNumber("HeightsDataCount", heights.length);
			
		}
	}
	public void findWidths(){
		widths = table.getNumberArray("width", widths);
			for(double width: widths){
				SmartDashboard.putNumber("width", width);
				widthDataCount++;
			}
		}
	
	public void findCenterXs(){
			heights = table.getNumberArray("centerX", heights);
			for(double centerX: centerXs){
				SmartDashboard.putNumber("centerX", centerX);
				centerXDataCount++;
			}
		}
	
	public void findCenterYs(){
			centerYs = table.getNumberArray("centerY", centerYs);
			for(double centerY: centerYs){
				SmartDashboard.putNumber("centerY", centerY);
				centerYDataCount++;
				SmartDashboard.putNumber("centerYDataCount", centerYDataCount);
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
	
	public void findIterations(){
		
	}
			
	public void interpretCamera(){
	if(areas.length > 0 && widthDataCount > 0 && heightDataCount > 0 && centerXDataCount > 0 && centerYDataCount > 0){
		
		
		
		if(heights[0] > heights[1]){
			if(heights[0] > 100 && heights[0] < 120){
				boolean heightReq = true;
			}
		}
		
		
		
		if(areas[0] > areas[1]){
			if(areas[0] > 3000 && areas[0] < 3500){
				boolean areaReq = true;
			}
		}
		
		if(heightReq && areaReq){
			RobotMap.shootReq = true;
			
			
			
			
			
		}
	}
	SmartDashboard.putBoolean("shootBool", RobotMap.shootReq);
		
	}
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

