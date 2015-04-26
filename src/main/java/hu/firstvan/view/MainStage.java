package hu.firstvan.view;

import hu.firstvan.controller.MainController;
import hu.firstvan.model.Datas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by firstvan on 2015.04.14..
 */
public class MainStage {
    public static Stage stage;

    public MainStage() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Take order");
        stage.setScene(scene);

        stage.show();
    }

    public static void setCustName() {
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(MainStage.class.getResource("/fxml/Main.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainController mainController = fxmlLoader.getController();
        mainController.setLabel("Név: " + Datas.getCustomer().getC_name());
        mainController.changeTable();
        mainController.enableButton();
        assert root != null;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Take order");
        stage.setScene(scene);
        stage.setOnShowing(event -> mainController.changeTable());

        stage.show();
    }
}
