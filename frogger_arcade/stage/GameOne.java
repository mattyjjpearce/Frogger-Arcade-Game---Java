package frogger_arcade.stage;
/**
 * @author psymp5
 */

import frogger_arcade.score.newHighScore;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import frogger_arcade.actors.*;
import frogger_arcade.score.Digit;

/**
 * GameOne class is where everything gets pulled together onto the stage, to be displayed for the user. And calls all methods and classes to make the game work
 */
public class GameOne extends Main {
    AnimationTimer timer;
    Music background;
    Animal frogger;
    Scene scene;
    newHighScore highScore;
    BackgroundImage newBackground;

    /**
     * Gets the scene
     * @return
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @method produceEntity()
     * Uses the EntityFactory Class to initiate the new obstacles and pass them the necessary parameters. For Logs, Turtles and Wet Turtles
     */
    public void produceEntity() {

        // produces logs from Entity Factory Class
        background.add( EntityFactory.makeNewEntity("LOGS", 200, 166, 0.75));
//        background.add( EntityFactory.makeNewEntity("LOG", 400, 166, 0.75));
        background.add( EntityFactory.makeNewEntity("LOGS", 600, 166, 0.75));
        background.add( EntityFactory.makeNewEntity("LOG3", 600, 276, -0.75));
        background.add( EntityFactory.makeNewEntity("LOG3", 200, 276, -0.75));
        background.add( EntityFactory.makeNewEntity("LOG3", 400, 276, -0.75));
        background.add( EntityFactory.makeNewEntity("LOG2", 0, 329, 0.75));
        background.add( EntityFactory.makeNewEntity("LOG2", 250, 329, 0.75));
        background.add( EntityFactory.makeNewEntity("LOG2", 500, 329, 0.75));

        // produces Turtle from Entity Factory Class

        background.add( EntityFactory.makeNewEntity("TURTLE", 0, 376, -1));
        background.add( EntityFactory.makeNewEntity("TURTLE", 300, 376, -1));
        background.add( EntityFactory.makeNewEntity("TURTLE", 600, 376, -1));
        background.add( EntityFactory.makeNewEntity("TURTLE", 600, 217, -1));



        // produces Wet Turtles from Entity Factory Class

        background.add( EntityFactory.makeNewEntity("WET_TURTLE", 300, 217, -1));
        background.add( EntityFactory.makeNewEntity("WET_TURTLE", 0, 217, -1));


    }


    /**
     * Placing end images for when frog reaches end
     */
    public void addEnd(){
        // End of course
        background.add(new End(13,96));
        background.add(new End(137,96));
        background.add(new End(137 + 130-15,96));
        background.add(new End(137 + 130-15+137-15,96));
        background.add(new End(137 + 130-15+137-15+137-15,96));
    }
    /**
     * Placing the vehicle obstacles in method addVehicles to call later.
     */
    public void addVehicles(){

        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/truck1Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/truck1Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/truck1Right.png", 600, 649, 1, 120, 120));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 500, 490, -2, 50, 50));
        background.add(new Obstacle("p4_group_8_repo/media/Vehicles/car1Left.png", 250, 490, -2, 50, 50));

    }


    /**
     * Sets the timer, using .getPoints, showing the user their score at the end of the game, as well as using the newHighScore class to display the highScofe
     */

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frogger.changeScore()) {
                    setScore(frogger.getPoints());
                }
                if (frogger.getStop()) {
                    System.out.print("STOP:");
                    highScore = new newHighScore();
                    highScore.storeScore(frogger.getPoints());

                    background.stopMusic();
                    stop();
                    background.stop();




                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your Score: "+ frogger.getPoints());
                    alert.setContentText("Current High Score: "+ highScore.getHighScore());
                    alert.show();


                }
            }
        };

    }




    /**
     * initiates all of the other methods through this one method (start)
     */
    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    /**
     * Method to stop the game through timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     *
     * @param n is the value of the score. Displays up to 3 of these images, in order to display the score to the user.
     */
    public void setScore(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 25, 525 - shift, 25));
            shift+=30;
        }

    }

    /**
     * Sets background and window for Game.
     */
    public void setUpGame(){

        background = new Music();
        scene  = new Scene(background,565,800);

        /**
         * uses singleton principle to implement a single instance of the background image.
         */
        newBackground = BackgroundImage.getBackgroundImage();
        background.add(newBackground);



        /**
        * @method produceEntity implements all entities such as logs, turtles and wet turtles.
        */
        produceEntity();

        /**
         * @method addEnd implements end frog images.
         */
        addEnd();

        /**
         * Implements animal class.
         */
       frogger = Animal.getAnimal();
        background.add(frogger);


        /**
         * @method addVehicle implements all vehicles previously called.
         */
       addVehicles();

        /**
         * Implements the timer, and end menu
         */
        start();
        background.start();
        start();
        timer.stop();

    }



}

