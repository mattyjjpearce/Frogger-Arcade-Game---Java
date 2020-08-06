package frogger_arcade.score;
/**
 * Digit class
 * @author psymp5
 */

import javafx.scene.image.Image;
import frogger_arcade.actors.Actor;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the image of the score.
	 * @param n being which image is being displayed as it increments depending on score. 
	 * @param dim
	 * @param x
	 * @param y
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("frogger_arcade/media/Score/" +n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
