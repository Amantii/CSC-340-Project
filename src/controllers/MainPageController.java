package controllers;

/**
 * FXML Controller class for MainPage FXML file
 *
 * @author Amantii
 * last updated: 11/28/20
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import view.SwitchScenes;

public class MainPageController implements Initializable {

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

    /**
     * Returns to the login page upon clicking the logout button
     *
     * @param _goBack
     * @throws IOException
     */
    public void returnToLogin(ActionEvent _goBack) throws IOException {
        CreateAccountController account = new CreateAccountController();
        account.returnToLogin(_goBack);
    }

    /**
     * Opens new scene to have the user set an appointment
     *
     * @param _appointment
     * @throws IOException
     */
    public void setAppointment(ActionEvent _appointment) throws IOException {
        SwitchScenes set = new SwitchScenes();
        set.newScene(_appointment, "SetAppointment.fxml", "Make an Appointment");
    }

    /**
     * Opens new scene to have the user cancel an existing appointment
     *
     * @param _appointment
     * @throws IOException
     */
    public void cancelAppointment(ActionEvent _appointment) throws IOException {
        SwitchScenes cancel = new SwitchScenes();
        cancel.newScene(_appointment, "CancelAppointment.fxml", "Cancel an Appointment");
    }
}
