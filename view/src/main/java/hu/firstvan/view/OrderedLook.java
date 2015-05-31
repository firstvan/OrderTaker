package hu.firstvan.view;

import hu.firstvan.model.Datas;
import hu.firstvan.model.Orders;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent ordered product window.
 */
public class OrderedLook {

    /**
     * Stage contains necessary widget of product stage.
     */
    public static Stage stage;

    /**
     * Connect controller of this area.
     */
    public hu.firstvan.controller.OrderedLook controller;

    /**
     * This is a static variable to logging.
     */
    private static Logger logger = LoggerFactory.getLogger(OrderedLook.class);

    /**
     * Constructor of {@code ProductStage} to load fxml file and show it.
     */
    public OrderedLook(Orders orders) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OrderedLook.fxml"));

        Parent root = null;

        try {
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ProductOrders fxml could not loaded.");
        }

        controller = loader.getController();
        controller.showOrder(orders);

        assert root != null;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Rendelt termékek");
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
