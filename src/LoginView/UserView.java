package LoginView;
/**
 *
 * last updated: 10/14/2020
 *
 * @author Amantii
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        _stage.setScene(scene);
        _stage.setTitle("CancerPatientPortal");
        _stage.show();
    }
}
