package controllers;

/**
 * FXML Controller class for PatientDetails FXML file
 *
 * @author Amantii
 * last updated: 11/28/20
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import view.SwitchScenes;

public class PatientDetailsController implements Initializable {

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
    protected TextField firstName;

    @FXML
    protected TextField lastName;

    @FXML
    protected TextField email;

    /**
     * Exits to signIn page when patient details are uploaded
     *
     * @param _login
     * @throws IOException
     */
    public void goToLogin(ActionEvent _login) throws IOException {
        SwitchScenes change = new SwitchScenes();
        change.sceneSwitch(_login, "SignIn.fxml", "Login for the first time");
    }


    //Figure out how to check fields for patient details page
    public boolean checkFields(ActionEvent _check) {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty()) {
            CreateAccountController patient = new CreateAccountController();
            patient.alertBox();

            return true;
        }
        return false;
    }
}
