package userModelUi;

import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    private Image ico;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FXMLLoader regsLoader = new FXMLLoader();
        try {
            ico = new Image("resources/log-out-.png");
        }catch (Exception e){
//            System.out.println("File Not Found");
            throw new FileNotFoundException();
        }

        fxmlLoader.setLocation(getClass().getResource("signIn/signIn.fxml"));
        regsLoader.setLocation(getClass().getResource("signUp/signUp.fxml"));
        Scene signInScene = new Scene(fxmlLoader.load(), 800, 500);
        Scene regScene = new Scene(regsLoader.load(), 800, 500);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("Sign In");
        primaryStage.getIcons().add(ico);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

