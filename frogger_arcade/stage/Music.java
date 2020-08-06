package frogger_arcade.stage;
/**
 * Music class which implements the music
 * @author psymp5
 */

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music extends World {
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {

	}
	/**
	 * Imports and plays the Main Theme Song for Frogger Game
	 */
	public void playMusic() {
		String musicFile = "Frogger-Arcade-Game-master/frogger_arcade/media/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Stops the music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
