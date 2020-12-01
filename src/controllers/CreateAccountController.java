package controllers;

/**
 * FXML Controller class for CreateAccount FXML file
 *
 * @author Amantii last updated: 11/28/20
 */
import Database.ConnectDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controllers.MainPageController.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    protected TextField firstname;

    @FXML
    protected TextField lastname;

    @FXML
    protected TextField email;

    @FXML
    protected PasswordField password;

    @FXML
    protected Button signUp;

    @FXML
    protected Button signIn;

    /**
     * Enters the patient details page upon creating new user and checks if
     * fields are empty.
     *
     * @param _patientDetails
     * @throws IOException
     * @throws java.sql.SQLException
     */
    public void signUp(ActionEvent _patientDetails) throws IOException, SQLException {
        //Logic to check if createAccount fields are empty and displays alert box accordingly
        if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            displayAlerts(Alert.AlertType.WARNING, "Invalid Entry", "Enter valid inputs into fields");
        }
        else {
            String firstName = firstname.getText();
            String lastName = lastname.getText();
            String userEmail = email.getText();
            String userPass = password.getText();

            ConnectDB connect = new ConnectDB();
            connect.accountInsertion(firstName, lastName, userEmail, userPass);

            displayAlerts(Alert.AlertType.CONFIRMATION, "Added", "Account was created successfully");

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
     * Method that creates specified alerts based upon set parameters.
     *
     * @param _type
     * @param _title
     * @param _msg
     */
    public void displayAlerts(Alert.AlertType _type, String _title, String _msg) {
        Alert alert = new Alert(_type);
        alert.setTitle(_title);
        alert.setHeaderText(null);
        alert.setContentText(_msg);
        alert.showAndWait();
    }
}
