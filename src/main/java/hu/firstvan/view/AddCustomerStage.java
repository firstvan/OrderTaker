package hu.firstvan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by firstvan on 2015.04.18..
 */
public class AddCustomerStage {
    public static Stage stage = new Stage();

    public AddCustomerStage() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddCustomer.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Database connection");
        stage.setScene(scene);
        stage.show();
    }
}
