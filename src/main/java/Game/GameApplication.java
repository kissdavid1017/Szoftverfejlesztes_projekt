package Game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Class for building the user interface
 */

public class GameApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/ui.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Feladatok 2.15");
        stage.setResizable(false);
        stage.show();
        scene.getRoot().requestFocus();



    }
}
