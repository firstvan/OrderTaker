package hu.firstvan.view;

import hu.firstvan.controller.AddProductController;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Class to represent add product window.
 */
public class AddProductStage {

    /**
     * Stage contains necessary widget of add product stage.
     */
    public static Stage stage;

    /**
     * Logger object.
     */
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

        addProductController.getTableView().getSelectionModel().selectedItemProperty().addListener((obs, oldselection, newSelection) -> {
            if (newSelection != null) {
                addProductController.disableButton(false);
                //logger.info("Add button disabled.");
            } else {
                addProductController.disableButton(true);
                //logger.info("Add button enabled.");
            }
        });

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                addProductController.updateTable();
                return null;
            }

        };

        new Thread(task).start();


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
