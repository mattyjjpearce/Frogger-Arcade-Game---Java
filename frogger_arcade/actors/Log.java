package frogger_arcade.actors;

import javafx.scene.image.Image;
/**
 * Log class
 * @author psymp5

 * Class that helps define Log entity, which has access to the Entity interface
 */
public class Log extends Entity {
	private double speed;

	/**
	 * act sets the object depending on it's x coordinate and speed.
	 * @param now just sets the object, once the stage is set.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
	 * Log takes in all the parameters necessary to produce the object.
	 */
	public Log(String imageLink, int size, int xStartPos, int yStartPos, double s ) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xStartPos);
		setY(yStartPos);
		speed = s;
		
	}

	/**
	 * Makes sure that if an object is moving left, speed is below 0.
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
