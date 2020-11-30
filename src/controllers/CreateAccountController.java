package controllers;

/**
 * FXML Controller class for CreateAccount FXML file
 *
 * @author Amantii
 * last updated: 11/28/20
 */

import controllers.MainPageController.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.SwitchScenes;

public class CreateAccountController implements Initializable {

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

    /**
     * Enters the patient details page upon clicking signUp button
     *
     * @param _patientDetails
     * @throws IOException
     */
    public void signUp(ActionEvent _patientDetails) throws IOException {
        if (alertBox()) {
            SwitchScenes details = new SwitchScenes();
            details.sceneSwitch(_patientDetails, "PatientDetails.fxml", "Enter Details");
        }
    }

    /**
     * Returns to the login page when the signIn button is clicked from the
     * create account page.
     *
     * @param _return
     * @throws IOException
     */
    public void returnToLogin(ActionEvent _return) throws IOException {
        SwitchScenes loginReturn = new SwitchScenes();
        loginReturn.sceneSwitch(_return, "SignIn.fxml", "Login");
    }

    /**
     * Presents warning box if there are empty/invalid inputs
     *
     * @return
     */
    public boolean alertBox() {
        //Logic to guard against empty inputs for each field
        if (fullName.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            Alert empty = new Alert(AlertType.WARNING);
            empty.setTitle("Invalid Entry");
            empty.setContentText("Enter valid inputs into fields");
            empty.setHeaderText(null);
            empty.showAndWait();

            return false;
        }
        return true;
    }
}
