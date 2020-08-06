
package frogger_arcade.test;

import frogger_arcade.score.Digit;
import javafx.scene.image.Image;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *Digit test runs several Junit tests such as checking the height of the digit image. and more.
 * @author psymp5
 */
public class DigitTest {

    Image im1;


    // checking image height on resource
    @Test (expected = RuntimeException.class)
    public void resourceImageHeight() {
        System.out.print("Image Resource Height: ");
        im1 = new Image("file:media/Score/1.png", 100, 100, true, true);

        assertEquals(100, im1.getHeight(), 2);
    }
        // checking image width on resource
      @Test (expected = RuntimeException.class)
    public void resourceImageWidth() {
        System.out.print("Image Resource width: ");
        im1 = new Image("file:media/Score/1.png", 100, 100, true, true);

        assertEquals(100, im1.getWidth(), 2);
    }
}
