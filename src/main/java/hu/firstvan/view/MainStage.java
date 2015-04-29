package hu.firstvan.view;

import hu.firstvan.controller.MainController;
import hu.firstvan.model.Datas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * It show the main infromation of customer, if user choosed.
 */
public class MainStage {

    /**
     * Stage.
     */
    public static Stage stage;

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);


    /**
     * Constructor of {@code Mainstage} to load fxml and show window.
     *
     * @throws Exception fxml can not be loaded
     */
    public MainStage() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Take order");
        stage.setScene(scene);

        stage.show();
        logger.info("The main stage is opened.");
    }

    /**
     * Set customer name, and display the lasts orders.
     *
     * @throws IOException fxml can not be loaded
     */
    public static void setCustName() throws IOException{
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(MainStage.class.getResource("/fxml/Main.fxml"));
        Parent root = fxmlLoader.load();
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
        logger.info("The main stage is changed. Loaded the customer.");
    }
}
