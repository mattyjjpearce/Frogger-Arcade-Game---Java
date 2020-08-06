package frogger_arcade.stage;
/**
 * End class
 * @author psymp5
 */

import javafx.scene.image.Image;
import frogger_arcade.actors.Actor;

/**
 * Class end which displays two images, one which is the top of the screen (the end) and the end once the frog reaches it.
 */
public class End extends Actor {
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * sets the end image, where the frogger has to reach
	 * @param x
	 * @param y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("frogger_arcade/media/End.png", 60, 60, true, true));
	}

	/**
	 * Once the frogger has reached the end, this image replaces the old one.
	 */
	public void setEnd() {
		setImage(new Image("frogger_arcade/media/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Boolean to check if frog has reached end.
	 */
	
	public boolean isActivated() {
		return activated;
	}
	

}
