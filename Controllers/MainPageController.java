package controllers;

/**
 * FXML Controller class for MainPage FXML file
 *
 * @author Amantii
 * @author Imran Al Nafiee
 * last updated: 12/01/20
 */
import Database.ConnectDB;
import apis.AppointmentAPIAdapter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.DeleteAppointment;
import models.GetAllAppt;
import models.MakeAppointment;
import view.SwitchScenes;

public class MainPageController implements Initializable {

    CreateAccountController alert = new CreateAccountController();

    @FXML
    protected TextField startTimeText;

    @FXML
    protected TextField endTimeText;

    @FXML
    protected TextField titleText;

    @FXML
    protected TextField apptID;

    @FXML
    protected TableView<GetAllAppt> mainTable;

    @FXML
    protected TableColumn<GetAllAppt, String> idCol;

    @FXML
    protected TableColumn<GetAllAppt, String> titleCol;

    @FXML
    protected TableColumn<GetAllAppt, String> startTimeCol;

    @FXML
    protected TableColumn<GetAllAppt, String> endTimeCol;

    @FXML
    protected TableColumn<GetAllAppt, String> noteCol;

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

    public void getAppointmentData(ActionEvent _get) throws IOException {
        SwitchScenes getAppt = new SwitchScenes();
        getAppt.newScene(_get, "GetAppointments.fxml", "Test View");
    }

    /*
     * to get appointments data
     *
     * @param _apptInfo
     */
    public ArrayList<GetAllAppt> apptList() throws SQLException {
        ArrayList<GetAllAppt> apptList = new ArrayList<>();
        GetAllAppt info = new GetAllAppt();
        ConnectDB connect = new ConnectDB();
        connect.GetAllAppt();

        AppointmentAPIAdapter get = new AppointmentAPIAdapter();
        get.getAppointment();
        return null;
    }

    /*
    //=================  SETTERS ===============//
    public void getAppt(GetAppointment _Id) {
        _Id.setId(this.startTimeText.getText());
    }*/
    /**
     * to set appointment
     *
     * @param _pressed
     * @throws java.sql.SQLException
     */
    public void setApptPressed(ActionEvent _pressed) throws SQLException {
        String apptId;
        MakeAppointment make = new MakeAppointment();
        if (startTimeText.getText().isEmpty() || endTimeText.getText().isEmpty()
                || titleText.getText().isEmpty()) {
            alert.displayAlerts(Alert.AlertType.WARNING, "Invalid Entry",
                    "Enter valid inputs into fields");
        } else {
            ConnectDB connect = new ConnectDB();

            alert.displayAlerts(Alert.AlertType.CONFIRMATION, "Added",
                    "Appointment created successfully");
            try {
                // Calling methods that set/get the values for use in the program
                setApptStartTime(make);
                setApptEndTime(make);
                setTitleText(make);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            AppointmentAPIAdapter appt = new AppointmentAPIAdapter();
            apptId = appt.makeAppointment(make.getStartTime(), make.getEndTime(), make.getTitle());
            connect.apptInsertion(startTimeText.getText(), endTimeText.getText(),
                    titleText.getText(), apptId);
        }

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
     * To cancel appointment
     *
     * @param _pressed
     */
    public void setCancelPressed(ActionEvent _pressed) throws SQLException {
        DeleteAppointment delete = new DeleteAppointment();
        if (apptID.getText().isEmpty()) {
            alert.displayAlerts(Alert.AlertType.WARNING, "Invalid Entry",
                    "Enter valid inputs into fields");
        } else {

            ConnectDB connect = new ConnectDB();

            alert.displayAlerts(Alert.AlertType.CONFIRMATION, "Deleted",
                    "Appointment deleted successfully");

            try {
                // Calling methods that set/get the values for use in the program
                setCancelPressed(delete);

            } catch (Exception ex) {
                System.out.println(ex);

            }
            AppointmentAPIAdapter cancel = new AppointmentAPIAdapter();
            cancel.deleteAppointment(delete.getId());
            connect.deleteAppt(apptID.getText());
        }
    }

    //=================  SETTERS ===============//
    /**
     *
     * @param _Id
     */
    public void setCancelPressed(DeleteAppointment _Id) {
        _Id.setId(this.apptID.getText());
    }

    /**
     * Copies the userID to the clipboard when the copy ID button is clicked and notifies the user that it is copied.
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
    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {

    }
}
