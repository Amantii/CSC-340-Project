package LoginView;

/**
 * This class will provide a more efficient way to switch between scenes
 * @author Amantii Samson
 * last updated: 11/12/20
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amantii
 */
public class ChangeScene {
    /**
     * 
     * @param _switch
     * @param _scene
     * @param _title
     * @throws IOException 
     */
    public void setScene(ActionEvent _switch, String _scene, String _title) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource(_scene));
        Parent root = load.load();
        Scene scene  = new Scene(root);
        Stage stage = (Stage)((Node)_switch.getSource()).getScene().getWindow();
        stage.setTitle(_title);
        stage.setScene(scene);
        stage.show();

    }

}
