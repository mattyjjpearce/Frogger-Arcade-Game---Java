package frogger_arcade.stage;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainMenuController {

    @FXML private Button startButton;

    /**
     * How to play button, informing the user on how to play the game.
     * @throws IOException
     */
    @FXML
    void information() throws IOException{
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Further Information");
    alert.setHeaderText("How to Play");
    alert.setContentText("The aim of this game is to get Frogger accross the river. Firstly you need to pass the road and avoid being runover by the vehicles. Once you reach the middle 'safe zone' the aim is to hop onto the logs and swimming turtles so you do not drown! Be careful of the turtles tho! Some decide to go beneath the water... Try get the frog to the end 5 times! Good luck and have fun! ");
    alert.show();
    }

    /**
     * Play button which then sets the Scene from class file GameOne
     * @param event
     * @throws IOException
     */
    @FXML
    void startUp(ActionEvent event) throws IOException{
    GameOne GameOne = new GameOne();
    Stage stage = new Stage();

    GameOne.setUpGame();

        stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(GameOne.getScene());

    }
}
