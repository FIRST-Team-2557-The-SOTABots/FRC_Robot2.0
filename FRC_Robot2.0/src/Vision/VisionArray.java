package Vision;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionArray extends Subsystem {
	private int widthDataCount;
	private int heightDataCount;
	private int centerXDataCount;
	private int centerYDataCount;
	private int areaDataCount;
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
	areaDataCount = 0;
	widthDataCount = 0;
	centerXDataCount = 0;
	centerYDataCount = 0;
	heights = new double[heightDataCount];
	
	areas = new double[areaDataCount];
	
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
			areas = table.getNumberArray("area", areas);
			for(double area: areas){
				SmartDashboard.putNumber("area", area);
				areaDataCount++;
				}
		}
	public void interpretCamera(){
		
		if(areaDataCount > 0 && widthDataCount > 0 && heightDataCount > 0
				&& centerXDataCount > 0 && centerYDataCount > 0){
			
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

