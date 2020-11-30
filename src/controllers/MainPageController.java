package controllers;

/**
 * FXML Controller class for MainPage FXML file
 *
 * @author Amantii last updated: 11/29/20
 */
import apis.AppointmentAPIAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import models.MakeAppointment;
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

    @FXML
    protected TextField startTimeText;

    @FXML
    protected TextField endTimeText;

    @FXML
    protected TextField titleText;

    /**
     * Returns to the login page upon clicking the logout button.
     *
     * @param _goBack
     * @throws IOException
     */
    public void returnToLogin(ActionEvent _goBack) throws IOException {
        CreateAccountController account = new CreateAccountController();
        account.returnToLogin(_goBack);
    }

    /**
     * Opens new scene to have the user set an appointment.
     *
     * @param _appointment
     * @throws IOException
     */
    public void setAppointment(ActionEvent _appointment) throws IOException {
        SwitchScenes set = new SwitchScenes();
        set.newScene(_appointment, "SetAppointment.fxml", "Make an Appointment");
        
    }

    /**
     * Opens new scene to have the user cancel an existing appointment.
     *
     * @param _appointment
     * @throws IOException
     */
    public void cancelAppointment(ActionEvent _appointment) throws IOException {
        SwitchScenes cancel = new SwitchScenes();
        cancel.newScene(_appointment, "CancelAppointment.fxml", "Cancel an Appointment");
    }

    /**
     * Opens new scene to copy the users ID to be used to set an appointment
     *
     * @param _userID
     * @throws IOException
     */
    public void getUserID(ActionEvent _userID) throws IOException {
        SwitchScenes getID = new SwitchScenes();
        getID.newScene(_userID, "UserID.fxml", "Copy your ID");
    }
    
    public void setApptPressed(ActionEvent _pressed) {
        MakeAppointment make = new MakeAppointment();
        setApptStartTime(make);
        setApptEndTime(make);
        setTitleText(make);
    }

    //=================  SETTERS ===============//

    public void setApptStartTime(MakeAppointment _startTime) {
        _startTime.setStartTime(this.startTimeText.getText());
    }

    public void setApptEndTime(MakeAppointment _endTime) {
        _endTime.setEndTime(this.endTimeText.getText());
    }

    public void setTitleText(MakeAppointment _title) {
        _title.setTitle(this.titleText.getText());
    }


















    /**
     * Copies the userID to the clipboard when the copy ID button is clicked and
     * notifies the user that it is copied.
     */
/*
    public void copyUserID() {
        AppointmentAPIAdapter contact = new AppointmentAPIAdapter();
        final Clipboard userID = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString("");
        content.putHtml("<b>Some<b> text");
        userID.setContent(content);

        Alert copied = new Alert(AlertType.CONFIRMATION);
        copied.setContentText("User ID has been copied");
        copied.setHeaderText(null);
        copied.showAndWait();
    }
*/
}
