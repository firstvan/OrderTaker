package hu.firstvan.view;

import hu.firstvan.controller.AddProductController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Class to show a window to add products to order.
 */
public class AddProductStage {

    /**
     * Stage.
     */
    public static Stage stage;

    private static Logger logger = LoggerFactory.getLogger(AddProductStage.class);


    /**
     * Constructor of {@code AddProductStage}. Attach the fxml, and show the window.
     */
    public AddProductStage() {

        FXMLLoader fxmlLoader = new FXMLLoader(AddProductStage.class.getResource("/fxml/AddProduct.fxml"));
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
        logger.info("Add product stage is opened.");
    }
}
