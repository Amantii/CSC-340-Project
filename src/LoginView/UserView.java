package LoginView;

/**
 * This class creates the stage for the first scene that appears last updated:
 * 11/19/2020
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
import javafx.stage.Stage;

public class UserView extends Application {

    //Stage window;
    //Scene login, main, signUp, createAccount;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        _stage.setScene(scene);
        _stage.setTitle("CancerPatientPortal");
        _stage.show();
    }

}
