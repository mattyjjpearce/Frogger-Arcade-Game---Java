
package frogger_arcade.test;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import frogger_arcade.actors.Log;
import frogger_arcade.actors.Turtle;
import frogger_arcade.stage.GameOne;
import frogger_arcade.stage.Main;
import frogger_arcade.stage.Music;
import frogger_arcade.stage.World;

/**
 *
 * @author psymp5
 */
public class GameOneTest {

    public GameOneTest() {
    }
    World w;

    Music background;
    ArrayList<Turtle> turtles = new ArrayList();

    //LoadFXML and init initializer for testGetScene()
    @Before
    public void init() {
//        try {
//            LoadFXML("MainMenu");
//        } catch (IOException ex) {
//            ex.getMessage();
//        }

    }

    private static Parent LoadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenuFX" + ".fxml"));
        return fxmlLoader.load();

    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        // Initialise Java FX

        System.out.printf("About to launch FX App\n");
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.printf("FX App thread started\n");
        Thread.sleep(500);
    }

    public static class AsNonApp extends Application {

        Scene scene;

        @Override
        public void start(Stage primaryStage) throws Exception {
            scene = new Scene(LoadFXML("MainMenu"));
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private static Parent LoadFXML(String fxml) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenuFX" + ".fxml"));
            return fxmlLoader.load();
        }
    }

    /**
     * Test of getScene method, of class GameOne.
     */
    @Test
    public void testGetScene() {
        System.out.print("GetScene: ");
        GameOne instance = new GameOne();
        Scene expResult = null;
        Scene result = instance.getScene();
        assertEquals(expResult, result);
        System.out.println("Scence returned");
    }

    /**
     * Test of addLogs method, of class GameOne.
     */
    @Test(expected = NullPointerException.class)
    public void testAddLogs() {
        System.out.println("AddLogs: ");
        background.add(new Log("file:media/Logs/log3.png", 150, 0, 166, 0.75));
        GameOne instance = new GameOne();
        instance.produceEntity();
        assertEquals("Adding ", 1, background.getBorder());
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTimer method, of class GameOne.
     */
    @Test
    public void testCreateTimer() {
        System.out.print("createTimer: ");
        GameOne instance = new GameOne();
        instance.createTimer();
        System.out.println("Time is Set up");
    }

    /**
     * Test of start method, of class GameOne.
     */
    @Test(expected = NullPointerException.class)
    public void testStart() {
        System.out.println("start");
        GameOne instance = new GameOne();
        instance.start();
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class GameOne.
     */
    @Test(expected = NullPointerException.class)
    public void testStop() {
        System.out.println("stop");
        GameOne instance = new GameOne();
        instance.stop();
        fail("The test case is a prototype.");
    }



}
