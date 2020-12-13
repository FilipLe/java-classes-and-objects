package classes;

import java.awt.Image;
import java.util.Random;

import util.FileUtil;

public class Spaceship {
	static Random randomGenerator = new Random();
	
	Image spaceship;
	Image fromLeft;
	Image fromRight;
	Image topLeft;
	Image topRight;
	Image spaceshipDown;
	
	double gradient = 0;
	
	Spaceship()
	{
		spaceship = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/rocket.png");
		fromLeft = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/bottomleft.png"); 
		fromRight = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/bottomright.png"); 
		topLeft = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/topleft.png"); 
		topRight = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/topright.png"); 
		spaceshipDown = FileUtil.loadImage("/Users/nguyenle/Starsfield-spaceship-game-graphics/rocketdown.png"); 
	}
	
	
}

