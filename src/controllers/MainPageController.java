package controllers;

/**
 * FXML Controller class for MainPage FXML file
 *
 * @author Amantii last updated: 11/29/20
 */
import apis.AppointmentAPIAdapter;
import apis.AppointmentApi;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import models.DeleteAppointment;
import models.GetAppointment;
import models.MakeAppointment;
import models.RetrieveAppointment;
import view.SwitchScenes;

public class MainPageController implements Initializable {

    @FXML
    protected TextField startTimeText;

    @FXML
    protected TextField endTimeText;

    @FXML
    protected TextField titleText;

    @FXML
    protected TextField apptID;

    @FXML
    protected TableView<GetAppointment> mainTable;

    @FXML
    protected TableColumn<GetAppointment, String> idCol;

    @FXML
    protected TableColumn<GetAppointment, String> titleCol;

    @FXML
    protected TableColumn<GetAppointment, String> startTimeCol;

    @FXML
    protected TableColumn<GetAppointment, String> endTimeCol;

    @FXML
    protected TableColumn<GetAppointment, String> noteCol;

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

    public String getApptData(ActionEvent _get) {
        GetAppointment info = new GetAppointment("id");
        AppointmentAPIAdapter get = new AppointmentAPIAdapter();
        get.getAppointments(info.getId());
        return get;
    }

    //=================  SETTERS ===============//
    /*
    public void getAppt(GetAppointment _Id) {
        _Id.setId(this.startTimeText.getText());
    }
    */

    /**
     * to get appointments data
     *
     * @param _apptInfo
     */
    /*
    public void getAppt(GetAppointment _apptInfo) {
        GetAppointment info = new GetAppointment();

        try {
            // Calling methods that set/get the values for use in the program
            getAppt(info);

        } catch (Exception ex) {
            System.out.println(ex);

        }
        AppointmentAPIAdapter get = new AppointmentAPIAdapter();
        get.getAppointments(info.getId());
    }

    //=================  SETTERS ===============//
    public void getAppt(GetAppointment _Id) {
        _Id.setId(this.startTimeText.getText());
    }*/
    /**
     * to set appointment
     *
     * @param _pressed
     */
    public void setApptPressed(ActionEvent _pressed) {
        MakeAppointment make = new MakeAppointment();

        try {
            // Calling methods that set/get the values for use in the program
            setApptStartTime(make);
            setApptEndTime(make);
            setTitleText(make);
        } catch (Exception ex) {
            System.out.println(ex);

        }
        AppointmentAPIAdapter appt = new AppointmentAPIAdapter();
        appt.makeAppointment(make.getStartTime(), make.getEndTime(), make.getTitle());
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
    public void setCancelPressed(ActionEvent _pressed) {
        DeleteAppointment delete = new DeleteAppointment();

        try {
            // Calling methods that set/get the values for use in the program
            setCancelPressed(delete);

        } catch (Exception ex) {
            System.out.println(ex);

        }
        AppointmentAPIAdapter cancel = new AppointmentAPIAdapter();
        cancel.deleteAppointment(delete.getId());
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
    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        //titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        //startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        //endTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        //noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));

        mainTable.setItems(retrieveApptData());
    }

    public ObservableList<GetAppointment> retrieveApptData() {
        //GetAppointment info = new GetAppointment();
        ObservableList<GetAppointment> data = FXCollections.observableArrayList();
        data.add(new GetAppointment(""));
        return data;
    }
}
