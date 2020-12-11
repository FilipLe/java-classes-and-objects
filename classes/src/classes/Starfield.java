package classes;

import tbs.simpleapp.SimpleApp;
import util.ColourUtil;

/*
 * Video:
 * https://www.youtube.com/watch?v=ZS-y8aHcM1E 
 */

public class Starfield extends SimpleApp {	
	//var to store amount of stars
	final int NUM_STARS = 2000;
	
	//create array to store the stars
	Star[] stars = new Star[NUM_STARS];
	
	
	
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
	}
}
