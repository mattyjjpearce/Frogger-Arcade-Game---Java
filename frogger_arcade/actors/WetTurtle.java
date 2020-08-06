package frogger_arcade.actors;
/**
 * Wet Turtle class
 * @author psymp5
 */

import javafx.scene.image.Image;

/**
 * Class that helps define WetTurtle entity, which has access to the Entity interface
 */
public class WetTurtle extends Entity {
	/**
	 * assigning variables
	 */
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	public boolean sunk = false;

	
	

	/**
	 * Assigns values / animations for when the turtle is in the water, as well as determining if the turtle is beneath the water (Sunk)
	 * @param now
	 * @super.act allows the subclass to invoke Entity class method.
	 */

	@Override
	public void act(long now) {

			move(speed , 0);
			if (getX()>600 && speed>0)
				setX(-180);
			if (getX()<-300 && speed<0)
				setX(700);

				super.act(now);
				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}

	}

	/**
	 * Setting the 4 separate animations depending on the time the object has been created. 
	 * @param xpos sets the x-axis position of the image
	 * @param ypos sets the y-axis position of the image
	 * @param s = speed
	 * @param w = width
	 * @param h = height 
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("frogger_arcade/media/Turtles/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("frogger_arcade/media/Turtles/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("frogger_arcade/media/Turtles/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("frogger_arcade/media/Turtles/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * Calls the method, and returns if turtle has sunk.
	 * @return
	 */
	public boolean isSunk() {
		return sunk;
	}
}
