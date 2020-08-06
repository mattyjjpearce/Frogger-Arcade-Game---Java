package frogger_arcade.actors;
/**
 * Turtle class
 * @author psymp5
 */

import javafx.scene.image.Image;



/**
 * Class that helps define Turtle entity, which has access to the Entity interface
 */
public class Turtle extends Entity {
	/**
	 * assigning variables
	 */
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;

	/**
	 * These if statements decide the turtles animation depending on time. As the turtle has 3 main animation movements when out of water.
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
		if (now / 900000000 % 3 == 0) {
			setImage(turtle2);

		} else if (now / 900000000 % 3 == 1) {
			setImage(turtle1);

		} else if (now / 900000000 % 3 == 2) {
			setImage(turtle3);

		}
	}

	/**
	 * Sets the animation for the 3 different images of turtle when swimming.
	 * @param xpos
	 * @param ypos
	 * @param s
	 * @param w
	 * @param h
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("frogger_arcade/media/Turtles/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("frogger_arcade/media/Turtles/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("frogger_arcade/media/Turtles/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
