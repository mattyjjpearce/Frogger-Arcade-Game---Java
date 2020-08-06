
package frogger_arcade.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import frogger_arcade.actors.Obstacle;
import frogger_arcade.actors.WetTurtle;
import frogger_arcade.stage.Main;

/**
 *
 * @author psymp5
 */
public class MainTest {

    public MainTest() {

    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.print("Main: ");
        String[] args = null;
        Main.main(args);
        System.out.println("Main Class set up args");
    }
      // checking x position of obstacle
   @Test (expected = RuntimeException.class)
    public void ObstaclexPosTest() {
        System.out.print("Obstacle: ");

        Obstacle ob = new Obstacle("file:media/Score/1.png", 100, 50, 20, 10, 20);
        assertEquals(100, ob.getX(), 2);
    }

      // checking y position of obstacle
    @Test
    public void ObstacleyPosTest() {
        System.out.print("Obstacle: ");

        Obstacle ob = new Obstacle("file:media/Score/1.png", 100, 50, 20, 10, 20);
        assertEquals(50, ob.getY(), 2);
    }



       // testing sunk for the wet turtle
    @Test
    public void WetTurtleTest() {
        System.out.print("WetTurtle: ");

        WetTurtle wt = new WetTurtle(100, 50, 20, 10, 20);
        assertEquals(false, wt.sunk);
    }


}
