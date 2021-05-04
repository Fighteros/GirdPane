package userModelUi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    public Stage appStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        appStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signIn/signIn.fxml"));
        Image iconImg = new Image("resources/log-out-.png");
        Scene signInScene = new Scene(fxmlLoader.load(), 800, 500);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("Sign In");
        primaryStage.getIcons().add(iconImg);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

