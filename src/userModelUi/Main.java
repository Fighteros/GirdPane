package userModelUi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("signIn/signIn.fxml"));
        Scene signInScene = new Scene(fxmlLoader.load(), 800, 500);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("Sign In");
        primaryStage.getIcons().add(new Image("resources/log-out-.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

