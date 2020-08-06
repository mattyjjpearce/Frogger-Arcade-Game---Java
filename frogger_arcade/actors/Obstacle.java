package frogger_arcade.actors;
/**
 * Obstacle class which extends the interface class Actor
 * @author psymp5
 */

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	@Override
	/**
	 * Moves obstacles left and resets their position when they reach the end.
	 */
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/**
	 * @Obstacle
	 * 	 * Method obstacle assigns all the necessary information new objects need. including their  image, positioning and speed.
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
