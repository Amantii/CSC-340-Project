package controllers;
/**
 * FXML Controller class for CreateAccount FXML file
 *
 * @author Amantii
 * last updated: 11/19/20
 */

import controllers.MainPageController.*;
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

public class CreateAccountController implements Initializable {

    Stage stage;
    Parent root;

    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        // TODO
    }

    @FXML
    protected TextField fullName;

    @FXML
    protected TextField email;

    @FXML
    protected PasswordField password;

    @FXML
    protected Button signUp;

    @FXML
    protected Button signIn;

    @FXML
    public void signUp() throws IOException {
        //Add logic to guard against invalid or no entries for name, email, and password
        stage = (Stage) signUp.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/PatientDetails.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void returnToLogin() throws IOException {
        stage = (Stage) signIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/SignIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
