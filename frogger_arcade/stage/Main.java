package frogger_arcade.stage;
/**
 * Main Class for Frogger Arcade Game
 * @author psymp5
 */


import java.io.IOException;
import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private static Scene scene;

	/**
	 * @method start
	 * Creates a new instance of Scene which loads the main menu, and provides the initial scene for the user, which in this case is the main menu.
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		scene = new Scene(LoadFXML("MainMenu"));
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	/**
	 * Below links the FXML class to our project, allowing me to edit the main menu in Scene Builder and connecting it to the project
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent LoadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenuFX" + ".fxml"));
		return fxmlLoader.load();
	}


}
