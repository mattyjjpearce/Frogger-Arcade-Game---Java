package frogger_arcade.stage;

import frogger_arcade.actors.Animal;
import javafx.scene.image.Image;
import frogger_arcade.actors.Actor;

/**
 * Class Background Image, gives the bounds for the image displayed in the frogger background.
 */
public class BackgroundImage extends Actor {

	/**
	 * Static backgroundImage is implemented in order to produce the idea of singleton, where only one instance on the background is used.
	 */
	public static BackgroundImage backgroundImage = new BackgroundImage("frogger_arcade/media/iKogsKW.png");
	@Override
	public void act(long now) {
	}

	/**
	 * The method gets called in main, as only background image is called, supporting singleton pattern.
	 * @return the static background image.
	 */
	public static BackgroundImage getBackgroundImage()
	{
		return backgroundImage;
	}

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
