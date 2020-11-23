package controllers;
/**
 * FXML Controller class for MainPage FXML file
 *
 * @author Amantii
 * last updated: 11/19/20
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    Stage stage;
    Parent root;

    /**
     * Initializes the controller class.
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        // TODO
    }

    @FXML
    protected Button logout;

    @FXML
    public void returnToLogin() throws IOException {
        stage = (Stage) logout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/SignIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
