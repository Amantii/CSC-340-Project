package LoginView;
/**
 * This class serves as the controller for the UserView and associated FXML files 
 *
 * @author Amantii
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Label update;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button createAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        // TODO
    }

    /**
     * Opens main user history page when correct login info is entered
     */
    public void submitButton(ActionEvent _event) throws Exception {
        if (username.getText().equals("username") && password.getText().equals("password")) {
            update.setText("Login Success");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("CancerStrong");
            stage.show();
        } else {
            update.setText("Failed to Login");
        }
    }

    /**
     * Opens new page to create account when create an account button is clicked
     */
    public void createAccountButton(ActionEvent _create) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("JoinUs!");
        stage.show();
    }
}
