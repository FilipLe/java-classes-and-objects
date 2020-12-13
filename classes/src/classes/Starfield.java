package classes;


import java.util.Random;

import tbs.simpleapp.SimpleApp;
import util.ColourUtil;

/*
 * Video:
 * https://www.youtube.com/watch?v=ZS-y8aHcM1E 
 */

public class Starfield extends SimpleApp {	
	Random random = new Random();
	
	//Stars
	final int NUM_STARS = 2000;
	//create array to store the stars
	Star[] stars = new Star[NUM_STARS];
	
	
	//Bubbles
	final int MAX_BUBBLES = 100;
	//create array for bubbles effect
	Bubble[] bubbles = new Bubble [MAX_BUBBLES];
	int numVal=0;
	
	
	//spaceship
	Spaceship spaceship = new Spaceship();
	int shipX;
	int shipY;
	int dShipX;
	int dShipY;
	
	
	public static void main(String[] args) {
		new Starfield();
	}

	
	
	public void main() 
	{
		//fill up array with stars objects 
		//each object has random x and y values
		for(int i = 0; i < NUM_STARS; i++) 
		{				
			//assign new star into array 
			stars[i] = new Star();
		}
		
		
		//To get rid of the first 100 bubbles appearing in the middle of the screen at start
		for(int i = 0; i < MAX_BUBBLES; i++) 
		{
			//create new bubble
			//making space for the data of the bubble to be stored
			bubbles[i] = new Bubble();
			
			//initializing x values of the ith bubble
			bubbles[i].x = 1000; 
			
			//give bubble random color
			bubbles[i].colour = random.nextInt(0xffffff);
			
			//give bubble random radius between 2 and 8
			bubbles[i].radius = random.nextInt(6) + 2;
		}		
		
	}
	
	//every frame program clears screen and draws one pixel for each of those star positions
	public void onFrame() 
	{
		screen.setColour(0);
		screen.fill();
		screen.setColour(0xffffff);
			
		
		//for loop to plot one pixel for each star
		//iterating through all of the stars
		for(int i = 0; i < NUM_STARS; i++) 
		{
			//get star from location 'i' in the array
			Star star = stars[i];
			
			//Adding movement to stars
			star.z -= 1;
			
			//if z gets too small, gonna add val to it so that it gets to close to viewer, it will get transported back to furthest distance away from viewer
			if(star.z <= 0) star.z += star.MAX_Z;
			
			/*
			 *create color by blending black (0) and white (0xffffff)
			 *star.z ÷ star.MAX_Z to calculate ratio of blending B and W
			 *more B or more W? based on distance from user
			 *If closer, star brighter
			 *if further away, star dimmer
			 */
			
			int colour = ColourUtil.blend(0, 0xffffff, star.z / star.MAX_Z);
			screen.setColour(colour);

			
			//plot on the screen that star
			//÷star.z to add perspective
			screen.plot((int)(star.x/star.z), (int)(star.y/star.z));
		}
		
		
		/*
		 * STILL NEED TO WORK ON HERE
		 * 
		//ship moving from bottom left
		if(dShipX > 0 && dShipY > 0)
			screen.drawImage(spaceship.fromLeft, shipX, shipY);
			
		//from top left
		else if(dShipX > 0 && dShipY < 0)
			screen.drawImage(spaceship.topLeft, shipX, shipY);
			
		//from bottom right
		else if(dShipX < 0 && dShipY > 0)
			screen.drawImage(spaceship.fromRight, shipX, shipY);
			
		//from top right
		else if(dShipX < 0 && dShipY < 0)
			screen.drawImage(spaceship.topRight, shipX, shipY);
			
		//ship going straight up
		else if (dShipX == 0 && dShipY > 0)
		{
			screen.drawImage(spaceship.spaceship, shipX, shipY);
		}
		
		//ship going straight down
		else if(dShipX == 0 && dShipY < 0)
		{
			screen.drawImage(spaceship.spaceshipDown,shipX, shipY);
		}
		*/
		
		
		if(shipX > 0)
			screen.drawImage(spaceship.fromLeft, shipX, shipY);
		
		if(shipX < 0)
			screen.drawImage(spaceship.fromRight, shipX, shipY);	
			
		
		for(int i = 0; i < MAX_BUBBLES; i++) 
		{
			//set bubble to its current color
			screen.setColour(bubbles[i].colour);
			
			//draw circle with radius of current bubble at coord x and y in array
			screen.drawCircle((int)bubbles[i].x, (int)bubbles[i].y, bubbles[i].radius);
			
			//Add movement to y-coord and x-coord
			bubbles[i].x += bubbles[i].dx;
			bubbles[i].y += bubbles[i].dy;
		}
	}
	
	public void onMouseMove(int x, int y) 
	{
		dShipX = x - shipX;
		shipX = x;
		dShipY = y - shipY;
		shipY = y;
		
		
		bubbles[numVal].x = x;
		bubbles[numVal].y = y - 70;
		
		
		//To get it moving to random positions, we give it random gradients
		//Initial Speed in x-coord
		bubbles[numVal].dx = random.nextDouble() * 2 - 1;
		
		//Initial Speed in y-coord
		bubbles[numVal].dy = random.nextDouble() * 2 - 1;
		
		//Move onto next value in array
		numVal += 1;
		
		//Array is gonna be full quickly if we use mouseMove, so we need to reset array when full
		if(numVal == MAX_BUBBLES) 
		{
			numVal = 0;
		}
	}
	
}
