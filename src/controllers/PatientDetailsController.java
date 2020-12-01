package controllers;

/**
 * FXML Controller class for PatientDetails FXML file
 *
 * @author Amantii last updated: 11/28/20
 */
import Database.ConnectDB;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.SwitchScenes;

public class PatientDetailsController implements Initializable {

    CreateAccountController patient = new CreateAccountController();

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
    protected TextField gender;

    @FXML
    protected TextField dob;

    /**
     * Exits to signIn page when patient details are uploaded
     *
     * @param _login
     * @throws IOException
     * @throws java.sql.SQLException
     */
    public void goToLogin(ActionEvent _login) throws IOException, SQLException {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || gender.getText().isEmpty() || dob.getText().isEmpty()) {
            patient.displayAlerts(Alert.AlertType.WARNING, "Invalid Entry", "Enter valid inputs into fields");
        } else {
            String fn = firstName.getText();
            String ln = lastName.getText();
            String userGender = gender.getText();
            String userDob = dob.getText();

            ConnectDB connect = new ConnectDB();
            connect.patientDetailsInsertion(fn, ln, userGender, userDob);

            patient.displayAlerts(Alert.AlertType.CONFIRMATION, "Added", "Account was created successfully");
        }
        SwitchScenes change = new SwitchScenes();
        change.sceneSwitch(_login, "SignIn.fxml", "Login for the first time");
    }

    //Figure out how to check fields for patient details page
    /*
    public void checkFields(ActionEvent _check) {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || dob.getText().isEmpty()) {
            CreateAccountController patient = new CreateAccountController();
            patient.alertBox();

            return true;
        }
        return false;
    }
     */
}
