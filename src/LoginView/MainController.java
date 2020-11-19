package LoginView;

/**
 * Class serves as the controller for the UserView and associated FXML files
 * last updated: 11/19/2020
 *
 * @author Amantii
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController implements Initializable {

    //ObservableList genderMenu = FXCollections.observableArrayList("Male", "Female", "Nonbinary", "Other", "Decline to State");
    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        // TODO
        //selectGender();
    }

    Stage stage;
    Parent root;

    @FXML
    private Label update;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;

    @FXML
    private AnchorPane createAccountPane;

    @FXML
    private TextField email;

    @FXML
    private Button signUp;
    
    @FXML
    private Button signIn;

    @FXML
    private Button logout;

    @FXML
    private ChoiceBox<String> genderSelect;

    @FXML
    private ComboBox<String> combobox;

    @FXML
    public void patientDetails(ActionEvent _signUp) throws IOException {
        if (username.getText().isEmpty() || username.getText().trim().isEmpty()) {
            signUp.setOnAction(e -> popupError("New user Error", "Please provide a username"));
        } else if (email.getText().isEmpty() || email.getText().trim().isEmpty()) {
            signUp.setOnAction(e -> popupError("New user Error", "Please provide a valid email"));
        } else if (password.getText().isEmpty() || password.getText().trim().isEmpty()) {
            signUp.setOnAction(e -> popupError("New user Error", "Please provide a password"));
        } else {
            stage = (Stage) signUp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void createAccountBtn(ActionEvent _create) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        loginPane.getChildren().setAll(login);
    }

    @FXML
    public void setAppointment(ActionEvent _set) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("SetAppointment.fxml"));
    }

    /**
     * Opens main user history page when correct login info is entered
     *
     * @param _event
     * @throws java.io.IOException
     */
    @FXML
    public void submitButton(ActionEvent _event) throws IOException {
        if (username.getText().equals("username") && password.getText().equals("password")) {
            stage = (Stage) submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        } else {
            submit.setOnAction(e -> popupError("Login Failed", "Please enter a valid username and password"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates a popup window when user does not enter specified information
     *
     * @param _popupTitle
     * @param _popupMessage
     */
    public static void popupError(String _popupTitle, String _popupMessage) {
        Stage popup = new Stage();

        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle(_popupTitle);
        popup.setMinWidth(350);
        popup.setMinHeight(125);

        Label messageLabel = new Label();
        messageLabel.setText(_popupMessage);
        Button closeWindow = new Button("Exit");
        closeWindow.setMinWidth(30);
        closeWindow.setAlignment(Pos.BASELINE_CENTER);
        closeWindow.setOnAction(e -> popup.close());

        VBox popupLayout = new VBox();
        popupLayout.getChildren().addAll(messageLabel, closeWindow);
        popupLayout.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(popupLayout);
        popup.setScene(popupScene);
        popup.showAndWait();
    }

    /**
     * Returns to the Login page after logging out
     *
     * @throws IOException
     */
    public void goBack() throws IOException {
        stage = (Stage) logout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Returns to Login page
     * @throws IOException 
     */
   public void returnToLogin() throws IOException {
       stage = (Stage) signIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
}
