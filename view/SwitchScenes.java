package view;

/**
 * This class will serve as the base class for switching between scenes
 *
 * @author Amantii Samson
 * last updated: 11/28/20
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
public class SwitchScenes {

    /**
     * Switches to different scenes using an ActionEvent, displays the chosen
     * page from the fxml file, and then sets a title for the page.
     *
     * @param _switch
     * @param _view
     * @param _title
     * @throws IOException
     */
    public void sceneSwitch(ActionEvent _switch, String _view, String _title) throws IOException {
        FXMLLoader page = new FXMLLoader();
        page.setLocation(getClass().getResource(_view));
        Parent root = page.load();

        Scene scene = new Scene(root);
        Stage switchStage = (Stage) ((Node) _switch.getSource()).getScene().getWindow();
        switchStage.setTitle(_title);
        switchStage.setScene(scene);
        switchStage.show();
    }

    /**
     * Opens a new stage with a new scene using an ActionEvent along with the
     * chosen fxml file view and then sets a title for the page.
     *
     * @param _change
     * @param _view
     * @param _title
     * @throws IOException
     */
    public void newScene(ActionEvent _change, String _view, String _title) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource(_view));
        Parent sceneRoot = load.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(sceneRoot));
        newStage.setTitle(_title);
        newStage.showAndWait();
    }
}
