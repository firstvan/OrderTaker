package hu.firstvan.view;

import hu.firstvan.controller.CustomerChooserController;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent the window of customer chooser window.
 */
public class CustomerStage {

    /**
     * Stage contains necessary widget of customer chooser window.
     */
    public static Stage stage;

    private static CustomerChooserController controller;

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);

    /**
     * Constructor of {@code CustomerStage} to load fxml and display it.
     *
     * @throws Exception when fxml file can not be loaded
     */
    public CustomerStage() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CustomerStage.class.getResource("/fxml/UserChooser.fxml"));

        Parent root = loader.load();

        controller = loader.getController();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Vásárló választás");
        stage.setScene(scene);
        stage.show();
        logger.info("User chooser stage is opened.");

        Task<Void> task = new Task<Void>() {
            @Override protected Void call() throws Exception {
                controller.setCustomerTable();
                return null;
            }

        };

        new Thread(task).start();
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
