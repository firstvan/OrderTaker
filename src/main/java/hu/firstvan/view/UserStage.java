package hu.firstvan.view;

import hu.firstvan.controller.CustomerChooserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by firstvan on 2015.04.18..
 */
public class UserStage {

    public static Stage stage;

    private static CustomerChooserController controller;

    public UserStage() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UserStage.class.getResource("/fxml/UserChooser.fxml"));

        Parent root = loader.load();

        controller = loader.getController();
        controller.setCustomerTable();


        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Vásárló választás");
        stage.setScene(scene);
        stage.show();


    }

    public static void update() {
        controller.setCustomerTable();
    }

    public static CustomerChooserController getController(){
        return controller;
    }

}
