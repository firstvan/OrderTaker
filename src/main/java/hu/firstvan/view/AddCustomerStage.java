package hu.firstvan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by firstvan on 2015.04.18..
 */
public class AddCustomerStage {
    public static Stage stage = new Stage();

    private static Logger logger = LoggerFactory.getLogger(AddCustomerStage.class);


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
