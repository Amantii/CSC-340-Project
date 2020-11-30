package models;

/**
 * This class creates the view of the first page for the application and controls the opening of the application.
 *
 * @author Amantii Samson last updated: 11/29/20
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amantii
 */
public class SignIn extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/SignIn.fxml"));
        Scene scene = new Scene(root);
        _stage.setScene(scene);
        _stage.show();
    }
}
