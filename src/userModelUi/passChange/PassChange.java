package userModelUi.passChange;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class PassChange{
    @FXML
    private Button cancelBtn;
    // change scene to sing in view
    public void handleCancelBtn(MouseEvent mouseEvent) throws IOException{
        Stage primaryStage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader signInFxml =  new FXMLLoader(getClass().getResource("../signIn/signIn.fxml"));
        Scene signInScene = new Scene(signInFxml.load(), 800, 500);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("sign in");
    }


}
