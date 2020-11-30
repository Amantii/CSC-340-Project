package controllers;

/**
 * FXML Controller class for SignIn FXML file
 *
 * @author Amantii last updated: 11/28/20
 */
import Database.ConnectDB;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.SignIn;
import view.SwitchScenes;
import Database.DatabaseConnect;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class SignInController implements Initializable {

    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        if (connect == null) {
            reportError.setTextFill(Color.RED);
            reportError.setText("Error: Check");
        }
        else {
            reportError.setTextFill(Color.GREEN);
            reportError.setText("Working");
        }
    }

    @FXML
    protected TextField email;

    @FXML
    protected PasswordField password;

    @FXML
    protected Button submit;

    @FXML
    protected Button createAccount;
    
    @FXML
    protected Label reportError;

    /**
     * Switches to main application page if valid email and password are
     * entered.
     *
     * @param _login
     * @throws IOException
     */
    public void signIn(ActionEvent _login) throws IOException {
        if (email.getText().isEmpty() | password.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Enter valid email and password");
        }
            try {
                SwitchScenes loginToAccount = new SwitchScenes();
                loginToAccount.sceneSwitch(_login, "MainPage.fxml", "User Account");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    /**
     * Switches to the create account page upon clicking the createAccount
     * button
     *
     * @param _create
     * @throws IOException
     */
    public void createAccount(ActionEvent _create) throws IOException {
        SwitchScenes newAccount = new SwitchScenes();
        newAccount.sceneSwitch(_create, "CreateAccount.fxml", "Join Us!");
    }

    /**
     * Opens new scene to prompt user to enter info if password is forgotten
     *
     * @param _forgot
     * @throws IOException
     */
    public void forgotPassword(ActionEvent _forgot) throws IOException {
        SwitchScenes changePass = new SwitchScenes();
        changePass.newScene(_forgot, "ForgotPassword.fxml", "Verify");
    }

    /**
     * Opens new scene for user to enter a new password for reset
     *
     * @param _reset
     * @throws IOException
     */
    public void resetPassword(ActionEvent _reset) throws IOException {
        SwitchScenes resetPass = new SwitchScenes();
        resetPass.newScene(_reset, "ResetPassword.fxml", "Reset");
    }

    /**
     * Sends warning alert to user if valid username and password are not
     * entered.
     *
     * @return
     */
    /*
    public boolean checkSignIn() {
        if (email.getText().equals("email") && password.getText().equals("password")) {
            Alert empty = new Alert(Alert.AlertType.WARNING);
            empty.setTitle("Valid Entry");
            empty.setContentText("Successfully logged in");
            empty.setHeaderText(null);
            empty.setTitle("Invalid entry");
            empty.showAndWait();

            return true;
        } else {
            Alert empty = new Alert(Alert.AlertType.WARNING);
            empty.setTitle("Invalid Entry");
            empty.setContentText("Enter valid email and password");
            empty.setHeaderText(null);
            empty.setTitle("Invalid entry");
            empty.showAndWait();

            return false;
        }
    }
     */
    
    public SignInController() {
        connect = ConnectDB.dbConnect();
    }

    private String confirmLogin() {
        String status = "Success";
        String userEmail = email.getText();
        String userPass = password.getText();
        if (userEmail.isEmpty() || userPass.isEmpty()) {
            labelError(Color.RED, "Empty fields!");
            status = "Error";
        } else {
            String query = "SELECT * FROM cancer_patient WHERE email = ? AND password = ?";
            try {
                ps = connect.prepareStatement(query);
                ps.setString(1, userEmail);
                ps.setString(2, userPass);
                rs = ps.executeQuery();
                if (!rs.next()) {
                    labelError(Color.RED, "Incorrect Email and Password");
                    status = "Error";
                } else {
                    labelError(Color.GREEN, "Successfully Logged In");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                status = "Exception";
            }
        }
        return status;
    }
    
    public void labelError(Color _color, String _text) {
        reportError.setTextFill(_color);
        reportError.setText(_text);
        System.out.println(_text);
    }
}
