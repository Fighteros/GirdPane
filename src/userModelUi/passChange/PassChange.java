package userModelUi.passChange;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import userModelUi.appUtils;

import java.io.IOException;


public class PassChange {
    @FXML
    private Button cancelBtn;

    // change scene to sing in view
    public void handleCancelBtn(MouseEvent mouseEvent) throws IOException {
        appUtils.swapScenes(mouseEvent, "sign in", new FXMLLoader(getClass().getResource("../signIn/signIn.fxml")));
    }


}
