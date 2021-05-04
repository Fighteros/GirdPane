package userModelUi;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class appUtils {
    public static void swapScenes(Event event , String sceneTitle,FXMLLoader fxmlFilePath) throws IOException {
        Scene regScene = new Scene(fxmlFilePath.load(), 800, 500);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(regScene);
        primaryStage.setTitle(sceneTitle);
    }
}
