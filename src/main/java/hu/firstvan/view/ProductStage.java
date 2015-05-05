package hu.firstvan.view;

import hu.firstvan.controller.ProductController;
import hu.firstvan.model.Datas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent ordered product window.
 */
public class ProductStage {

    /**
     * Stage contains necessary widget of product stage.
     */
    public static Stage stage;

    /**
     * Connect controller of this area.
     */
    public ProductController controller;

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);

    /**
     * Constructor of {@code ProductStage} to load fxml file and show it.
     */
    public ProductStage() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductOrders.fxml"));

        Parent root = null;

        try {
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ProductOrders fxml could not loaded.");
        }

        controller = loader.getController();

        controller.getTableView().getSelectionModel().selectedItemProperty().addListener((obs, oldselection, newSelection) -> {
            if (newSelection != null) {
                controller.disableButton(false);
                logger.info("Modify button disabled.");
            } else {
                controller.disableButton(true);
                logger.info("Modify button enabled.");
            }
        });

        assert root != null;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Rendelés");
        stage.setScene(scene);

        stage.setOnShowing(event -> {
            controller.updateTable(Datas.getOrderedItems());
            controller.updateOrderTotal();
        });

        stage.setOnCloseRequest(event -> MainStage.stage.show());

        stage.show();
        logger.info("ProductOrders stage is displayed.");

    }


}
