package hu.firstvan.view;

import hu.firstvan.controller.ProductController;
import hu.firstvan.model.Datas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by firstvan on 2015.04.23..
 */
public class ProductStage {

    public static Stage stage;

    public ProductController controller;

    public ProductStage() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductOrders.fxml"));

        Parent root = null;

        try {
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        controller = loader.getController();

        controller.getTableView().getSelectionModel().selectedItemProperty().addListener((obs, oldselection, newSelection) -> {
            if (newSelection != null) {
                controller.disableButton(false);
            } else {
                controller.disableButton(true);
            }
        });

        assert root != null;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Vásárló választás");
        stage.setScene(scene);

        stage.setOnShowing(event -> {
            controller.updateTable(Datas.getOrderdItems());
            controller.updateOrderTotal();
        });

        stage.setOnCloseRequest(event -> MainStage.stage.show());

        stage.show();

    }


}
