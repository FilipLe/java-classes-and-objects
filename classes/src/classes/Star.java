package classes;

import java.util.Random;

public class Star {
	//random generator
	static Random randomGenerator = new Random();
	
	//largest possible z value that any star can have
	static final int MAX_Z = 200; 
	
	//declare the coordinates
	double x;
	double y;
	double z;
	
	
	//creating constructor
	//inside constructor, we can write code, which will always happen when we create a new Star
	
	//-->Everytime we type 'new Star()', it will automatically run the following code (random x,y,z)
	Star()
	{
		//random x-coord between -200 and 200
		x = randomGenerator.nextDouble() * 400 - 200;

		//random y-coord between -200 and 200
		y = randomGenerator.nextDouble() * 400 - 200;
		
		//random z-coord between -0 and 200 for 3D
		z = randomGenerator.nextDouble() * MAX_Z;
		
		x *= MAX_Z;
		y *= MAX_Z;
	}
}
