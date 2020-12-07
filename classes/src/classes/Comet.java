package classes;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import tbs.simpleapp.SimpleApp;
import util.FileUtil;

public class Comet extends SimpleApp{
	Image car;
	double[] xValues = new double[100];
	double[] yValues = new double[100];
	double[] dxValues = new double[100];
	double[] dyValues = new double[100];
	int numCars = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Comet();
	}
	
	public void main() 
	{
		//load sprite
		Path path = Paths.get("/Users/nguyenle/Desktop/My_Work/Programming/Free_Time/Car/car.png");
		car = FileUtil.loadImage(path);
	}

	public void onFrame() 
	{
		//Make screen white so doesn't leave sprite's trail
		screen.fill();
		
		for(int i = 0; i < numCars; i++) 
		{
			//Draw car at mouseclick
			screen.drawImage(car, (int)xValues[i], (int)yValues[i]);
			
			//Add movement to y-coord and x-coord
			yValues[i] += dyValues[i];
			xValues[i] += dxValues[i];
						
			
			//Make sprite bounce
			//Check y values, if it hits bottom of screen (y-coord = -168)
			if(yValues[i] < -168) 
			{
				yValues[i] = -168;
				//Change direction --> change sign of number
				dyValues[i] = -dyValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			//x direction
			
			//If it hits left edge, change the sign of movement in x-direction
			//Movement to left now becomes movement to right
			if(xValues[i] < -168) 
			{
				xValues[i] = -168;
				//Change direction --> change sign of number
				dxValues[i] = -dxValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			
			//If it hits right edge, change the sign of movement in x-direction
			//Movement to right now becomes movement to left
			if(xValues[i] > 168) 
			{
				xValues[i] = 168;
				//Change direction --> change sign of number
				dxValues[i] = -dxValues[i]*0.8;
				//x 0.8 because in real life, everytime object bounces off, rebound is lower
			}
			
			//Decrease y velocity as the rebound force is lower that dropping force, due to gravity
			dyValues[i] -= 0.5;
		}
		
		
	}
	
	//Draw more sprites on mouse click position
	public void onMouseClick(int x, int y) 
	{
		//Initial Speed in x-coord
		dxValues[numCars] = 10;
		xValues[numCars] = x;
		yValues[numCars] = y;
		numCars += 1;
	}
}

