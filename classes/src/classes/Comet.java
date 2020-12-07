package classes;

import java.util.Random;
import tbs.simpleapp.SimpleApp;

public class Comet extends SimpleApp{
	//import random
	Random random = new Random();
	
	//amount of bubbles
	final int MAX_BUBBLES = 100;
	//final --> cannot change the value of this var
	
	
	//Single array, each item in the array will be a bubble
	//a bubble is an item which has the 4 datas in Bubble.java
	Bubble[] bubbles = new Bubble [MAX_BUBBLES];
	
	int numVal = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Comet();
	}
	
	public void main() 
	{
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

	public void onFrame() 
	{
		//clear background, set color black
		screen.setColour(0);
		
		//Make screen black so doesn't leave circle's trail
		screen.fill();
		
		
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
	
	//Draw more sprites on mouse movement 
	public void onMouseMove(int x, int y) 
	{
		bubbles[numVal].x = x;
		bubbles[numVal].y = y;
		
		
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

