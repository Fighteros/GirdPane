package userModelUi.signIn;

import dataAccessLayer.PersonDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;


public class signIn {
    // apply fake database temporary
    private PersonDao personDao;

    @FXML
    private Button signInBtn;
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    public Button signUpBtn;

    // buttons events
    public void signInBtnClicked(MouseEvent mouseEvent) {
        if(isDataValid() == 1){
            makeAlert(new Alert(Alert.AlertType.ERROR), "Username and Password can't be Empty");
        }
        if(isDataValid() == 2){
            makeAlert(new Alert(Alert.AlertType.ERROR), "Password can't be less than 6 characters");
        }
        if(isDataValid() == 0){
//            LoginUser();
            makeAlert(new Alert(Alert.AlertType.INFORMATION), "Logged in Successfully!");
        }
    }

    // change scene
    public void signUpBtnClicked(MouseEvent event) throws IOException {
        FXMLLoader regsLoader = new FXMLLoader(getClass().getResource("../signUp/signUp.fxml"));
        Scene regScene = new Scene(regsLoader.load(), 800, 500);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(regScene);
    }

    // design nice alert for the UI
    private void makeAlert(Alert alert, String headerMessage){
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(headerMessage);
        alert.setTitle(alert.getAlertType().name().toLowerCase(Locale.ROOT));
        alert.getDialogPane().setStyle("-fx-background-color: #f3f4ed; -fx-font-size: 14px; -fx-font-weight: bold ;-fx-font-family: Dubai");
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("resources/log-out-.png"));
        alert.showAndWait();
    }

    // authentication and validate form
    private void LoginUser() {
        isDataInDB();
    }
    public int isDataValid(){
        if(username.getText().isEmpty() || password.getText().isEmpty()){
           return 1;
        }
        if(password.getText().length() < 6){
            return 2;
        }
        return 0;
    }

    // check person is in the db
    public int isDataInDB(){
        return 0;
    }

    public void updatePassword(MouseEvent event) throws IOException{
        // applying the reset password Ui
        FXMLLoader resetPass = new FXMLLoader(getClass().getResource("../passChange/passChange.fxml"));
        Scene resetPassScene = new Scene(resetPass.load(), 800, 500);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(resetPassScene);
        primaryStage.setTitle("Reset your password!");
    }
}
