package userModelUi.signIn;

import dataAccessLayer.fakePersonDataAccessService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class signIn {
    // apply fake database temporary
    private fakePersonDataAccessService fakePerson;
    @FXML
    private Button signInBtn;
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    public Button signUpBtn;


    public void signInBtnClicked(MouseEvent mouseEvent) {
        if(isDataValid() == 1){
            makeAlert(new Alert(Alert.AlertType.ERROR), "Username and Password can't be Empty");
        }
        if(isDataValid() == 2){
            makeAlert(new Alert(Alert.AlertType.ERROR), "Password can't be less than 6 characters");
        }
        if(isDataValid() == 0){
            LoginUser();
        }
    }

    // change scene
    public void signUpBtnClicked(MouseEvent event) throws IOException {
//        System.out.println("clicked");
        FXMLLoader regsLoader = new FXMLLoader(getClass().getResource("../signUp/signUp.fxml"));
        Scene regScene = new Scene(regsLoader.load(), 800, 500);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(regScene);
    }

    public  void updatePassword(MouseEvent event){
        // should apply another Scene
        System.out.println("okay working!");
    }


    private void makeAlert(Alert alert, String headerMessage){
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(headerMessage);
        alert.setTitle(alert.getAlertType().name());
        alert.getDialogPane().setStyle("-fx-background-color: #dedede; -fx-text-fill: white; -fx-font-size: 14px");
        alert.showAndWait();
    }
    private void LoginUser() {

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

}
