package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gp = makeForm();
        addUiSignInControls(gp);
        Scene scene = new Scene(gp, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration Form");
        primaryStage.show();
    }

    private GridPane makeForm() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        return gp;
    }

    // add User - interface controls to sign In
    private void addUiSignInControls(GridPane signInPane) {
        Text formName = new Text("Sign In");
        signInPane.setPadding(new Insets(25));
        GridPane.setMargin(formName, new Insets(20, 0, 20, 0));
        GridPane.setHalignment(formName, HPos.CENTER);
        signInPane.setHgap(5);
        signInPane.setVgap(5);
        formName.setFont(Font.font("Courier New, sans-serif", FontWeight.BOLD, 24));
        signInPane.add(formName, 0, 0, 2, 1);
        Label emailId = new Label("Email ID: ");
        TextField emailIdTf = new TextField();

        signInPane.add(emailId, 0, 2);
        signInPane.add(emailIdTf, 1, 2);

        Label passwd = new Label("Password: ");
        PasswordField passwdTf = new PasswordField();
        signInPane.add(passwd, 0, 3);
        signInPane.add(passwdTf, 1, 3);

        // create sign in button

        Button signInBtn = new Button("Sign In");
        GridPane.setHalignment(signInBtn, HPos.CENTER);
        GridPane.setMargin(signInBtn, new Insets(10, 0, 10, 0));
        signInBtn.setPrefWidth(100);
        signInBtn.setPrefHeight(45);
        signInBtn.setPadding(new Insets(11));
        signInBtn.setDefaultButton(true);
        signInPane.add(signInBtn, 0, 4);

        signInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (emailId.getText().isEmpty()){
                    responseMsg("Thank You!", "Registered Successfully", "success");
                }else {
                    responseMsg("your Email ID or password maybe wrong ", "Authentication failed", "err");
                }
            }
        });

        // add Register button

        Button registerBtn = new Button("Register");
        registerBtn.setPrefHeight(45);
        registerBtn.setDefaultButton(true);
        registerBtn.setPrefWidth(100);
        signInPane.add(registerBtn, 1, 4);
        GridPane.setHalignment(registerBtn, HPos.CENTER);
        GridPane.setMargin(registerBtn, new Insets(10, 0, 10, 0));

        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane grdRg = getRgForm();
                Scene scene = new Scene(grdRg, 800, 500);
                Stage newStage = new Stage();
                newStage.setScene(scene);
                newStage.show();
            }
        });
    }

    private void addUiRgControls(GridPane gp) {
        Text formName = new Text("Registration Form");
        gp.setPadding(new Insets(22));
        GridPane.setMargin(formName, new Insets(10, 0, 10, 0));
        GridPane.setHalignment(formName, HPos.CENTER);
        gp.setHgap(8);
        gp.setVgap(8);
        formName.setFont(Font.font("Courier New, sans-serif", FontWeight.BOLD, 24));
        gp.add(formName, 0, 0, 2, 1);

        Label fullName = new Label("Full name: ");
        TextField fullNameTf = new TextField();

        // add to pane
        gp.add(fullName, 0, 1);
        gp.add(fullNameTf, 1, 1);

        Label emailId = new Label("Email ID: ");
        TextField emailIdTf = new TextField();

        gp.add(emailId, 0, 2);
        gp.add(emailIdTf, 1, 2);

        Label passwd = new Label("Password: ");
        PasswordField passwdTf = new PasswordField();

        gp.add(passwd, 0, 3);
        gp.add(passwdTf, 1, 3);

        // add Submit button

        Button submitBtn = new Button("Submit");
        submitBtn.setPrefHeight(40);
        submitBtn.setDefaultButton(true);
        submitBtn.setPrefWidth(75);
        gp.add(submitBtn, 0, 4, 4, 2);
        GridPane.setHalignment(submitBtn, HPos.CENTER);
        GridPane.setMargin(submitBtn, new Insets(10, 0, 10, 0));

        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // validate form

                if (fullNameTf.getText().isEmpty()) {
                    responseMsg("please make sure to enter your name", "Credential must be filled", "err");
                } else if (emailIdTf.getText().isEmpty()) {
                    responseMsg("please make sure to enter your Email Id", "Credential must be filled", "err");
                } else if (passwdTf.getText().isEmpty()) {
                    responseMsg("please make sure to enter your password", "Credential must be filled", "err");
                } else {
                    responseMsg("Thank You!", "Registered Successfully", "success");
                }
            }
        });
    }

    private void responseMsg(String res, String resMsg, String status) {
        if (status.equals("success")) {
            JOptionPane.showMessageDialog(null, res, resMsg, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, res, resMsg, JOptionPane.ERROR_MESSAGE);
        }

    }

    // get a register form

    public GridPane getRgForm(){
        GridPane gp = makeForm();
        addUiRgControls(gp);
        return gp;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
