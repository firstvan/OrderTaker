package hu.firstvan.view;

import hu.firstvan.controller.AddProductController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by firstvan on 2015.04.23..
 */
public class AddProductStage {
    public static Stage stage;

    public AddProductStage() {

        FXMLLoader fxmlLoader = new FXMLLoader(MainStage.class.getResource("/fxml/AddProduct.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddProductController addProductController = fxmlLoader.getController();

        addProductController.updateTable();


        assert root != null;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Termék hozzáadás");
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> ProductStage.stage.show());

        stage.show();
    }
}
