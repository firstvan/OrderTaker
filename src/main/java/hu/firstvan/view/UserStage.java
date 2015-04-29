package hu.firstvan.view;

import hu.firstvan.controller.CustomerChooserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Window to show all users.
 */
public class UserStage {

    /**
     * Stage.
     */
    public static Stage stage;

    private static CustomerChooserController controller;

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);

    /**
     * Constructor of {@code UserStage} to load fxml and display it.
     *
     * @throws Exception
     */
    public UserStage() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UserStage.class.getResource("/fxml/UserChooser.fxml"));

        Parent root = loader.load();

        controller = loader.getController();
        controller.setCustomerTable();


        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Vásárló választás");
        stage.setScene(scene);
        stage.show();
        logger.info("User chooser stage is opened.");

    }

    /**
     * Update users table.
     */
    public static void update() {
        controller.setCustomerTable();
        logger.info("User chooser table is updated.");
    }

    /**
     * Access the User stage controller.
     *
     * @return controller class of this stage.
     */
    public static CustomerChooserController getController(){
        return controller;
    }

}
