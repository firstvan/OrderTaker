package hu.firstvan.controller;

import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.model.Orders;
import hu.firstvan.view.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Manage all interactions on {@code Main Window}.
 */
public class MainController implements Initializable {

    /**
     * Table for show all orders.
     */
    @FXML
    private TableView<Orders> ordered;

    /**
     * First column of table. It's order id.
     */
    @FXML
    private TableColumn<Orders, Integer> o_id;

    /**
     * Second column of table. It's order date.
     */
    @FXML
    private TableColumn<Orders, Date> o_date;

    /**
     * Third column of table. It's order price.
     */
    @FXML
    private TableColumn<Orders, Integer> o_prices;

    /**
     * Add new order button.
     */
    @FXML
    private Button addOrder;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        o_id.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getO_id()));
        o_date.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDate()));
        o_prices.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getOrder_total()));

        ordered.setRowFactory(tv -> {
            TableRow<Orders> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())){
                    Orders o = row.getItem();
                    new hu.firstvan.view.OrderedLook(o);
                    MainStage.stage.close();
                }
            });
            return row;
        });
    }

    /**
     * Open customer chooser dialog.
     */
    @FXML
    private void newOrderTake() {
        try {
            new CustomerStage();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error dialog");
            alert.setHeaderText("Hiba a vásárlók betöltésénél.");
            alert.show();
        }
    }

    /**
     * Label for customer name.
     */
    @FXML
    private Label custName;

    /**
     * Set's customer name.
     *
     * @param s customer's name
     */
    public void setLabel(String s) {
        custName.setText(s);
    }

    /**
     * Set's ordered table with selected customer's orders.
     */
    public void changeTable() {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        ArrayList<Orders> orders = databaseDAO.GetUserOrders(Datas.getCustomer().getC_id());
        if (!orders.isEmpty()) {
            ObservableList<Orders> customerData = FXCollections.observableArrayList(orders);
            ordered.setItems(customerData);
        }
    }

    /**
     * Open the stage for add new order.
     */
    @FXML
    public void addOrder() {
        new ProductStage();
        MainStage.stage.close();
    }

    /**
     * Close the program.
     */
    @FXML
    public void close() {
        System.exit(0);
    }

    /**
     * Enable {@code addOrder} button, after customer is selected.
     */
    public void enableButton() {
        addOrder.setDisable(false);
    }

    /**
     * Exit from the menu.
     *
     * @param actionEvent an event.
     */
    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
