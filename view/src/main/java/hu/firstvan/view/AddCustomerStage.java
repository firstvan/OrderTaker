package hu.firstvan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent add customer window.
 */
public class AddCustomerStage {

    /**
     * Stage contains necessary widget of window.
     */
    public static Stage stage = new Stage();

    /**
     * This is a static variable to logging.
     */
    private static Logger logger = LoggerFactory.getLogger(AddCustomerStage.class);

    /**
     * Constructor of {@code AddCustomerStage} to load fxml file and attach stage.
     *
     * @throws Exception when fxml file does not load
     */
    public AddCustomerStage() throws Exception {
        Parent root = FXMLLoader.load(AddCustomerStage.class.getResource("/fxml/AddCustomer.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Vásárló hozzáadás");
        stage.setScene(scene);
        stage.show();
        logger.info("Add customer stage is opened.");
    }
}
