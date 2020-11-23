package controllers;
/**
 * FXML Controller class for SignIn FXML file
 *
 * @author Amantii
 * last updated: 11/19/20
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.SignIn;

public class SignInController implements Initializable {

    Stage stage;
    Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    protected TextField username;

    @FXML
    protected PasswordField password;

    @FXML
    protected Button submit;

    @FXML
    protected Button createAccount;

    @FXML
    public void signIn() throws IOException {
        if (username.getText().equals("username") && password.getText().equals("password")) {
            stage = (Stage) submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
        } else {
            System.out.println("Wrong username/password");
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void createAccount() throws IOException {
        stage = (Stage) createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/CreateAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
