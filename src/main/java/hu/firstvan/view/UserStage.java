package hu.firstvan.view;

import hu.firstvan.controller.CustomerChooserController;
import hu.firstvan.model.Customer;
import hu.firstvan.model.DatabaseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public UserStage() throws Exception {

        ObservableList<Customer> customerData = FXCollections.observableArrayList(DatabaseDAO.getAllCustomer());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/UserChooser.fxml"));

        Parent root = loader.load();

        controller = loader.getController();
        controller.setCustomerTable(customerData);


        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage = new Stage();
        stage.setTitle("Vásárló választás");
        stage.setScene(scene);
        stage.show();


    }

    public static void update() {
        ObservableList<Customer> customerData = FXCollections.observableArrayList(DatabaseDAO.getAllCustomer());
        controller.setCustomerTable(customerData);
    }

}
