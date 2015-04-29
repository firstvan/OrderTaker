package hu.firstvan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Login window to get username and password of datebase (unideb).
 */
public class DatabaseStage {

    /**
     * Stage.
     */
    public static Stage stage;

    private static Logger logger = LoggerFactory.getLogger(MainApp.class);


    /**
     * Constructor of {@Code DatabaseStage} to load fxml, and show the window.
     *
     * @throws Exception it thrown when fxml file does not found.
     */
    public DatabaseStage() throws Exception{
        Parent root = FXMLLoader.load(DatabaseStage.class.getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Adatbázis kapcsolódás");
        stage.setScene(scene);
        stage.show();
        logger.info("Database stage display.");
    }
}
