package hu.firstvan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by firstvan on 2015.04.14..
 */
public class DatabaseStage {

    public static Stage stage;

    public DatabaseStage() throws Exception{
        Parent root = FXMLLoader.load(DatabaseStage.class.getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Database connection");
        stage.setScene(scene);
        stage.show();
    }
}
