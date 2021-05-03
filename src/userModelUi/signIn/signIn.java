package userModelUi.signIn;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class signIn {
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

    private void makeAlert(Alert alert, String headerMessage){
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(headerMessage);
        alert.setTitle(alert.getAlertType().name());
        alert.getDialogPane().setStyle("-fx-background-color: #dedede; -fx-text-fill: white; -fx-font-size: 14px");
        alert.showAndWait();
    }
    private void LoginUser() {
        makeAlert(new Alert(Alert.AlertType.INFORMATION), "Logged In Successfully");
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
