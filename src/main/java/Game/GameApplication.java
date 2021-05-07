package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/ui.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Feladatok 2.15");
        stage.setResizable(false);
        stage.show();

    }
}
