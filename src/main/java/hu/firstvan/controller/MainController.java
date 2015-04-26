package hu.firstvan.controller;

import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.model.Orders;
import hu.firstvan.view.MainStage;
import hu.firstvan.view.ProductStage;
import hu.firstvan.view.UserStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;


/**
 * Created by firstvan on 2015.04.18..
 */
public class MainController implements Initializable {

    @FXML
    private TableView<Orders> ordered;

    @FXML
    private TableColumn<Orders, Integer> o_id;

    @FXML
    private TableColumn<Orders, Date> o_date;

    @FXML
    private TableColumn<Orders, Integer> o_prices;

    @FXML
    private Button addOrder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        o_id.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getO_id()));
        o_date.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDate()));
        o_prices.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getOrder_total()));
    }

    @FXML
    private void newOrderTake() {
        try {
            new UserStage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Exit() {
        System.exit(0);
    }

    @FXML
    private Label custName;

    public void setLabel(String s) {
        custName.setText(s);
    }

    public void changeTable() {
        ArrayList<Orders> orders = DatabaseDAO.GetUserOrders(Datas.getCustomer().getC_id());
        if (!orders.isEmpty()) {
            ObservableList<Orders> customerData = FXCollections.observableArrayList(orders);
            ordered.setItems(customerData);
        }
    }

    @FXML
    public void addOrder() {
        new ProductStage();
        MainStage.stage.close();
    }

    @FXML
    public void close() {
        System.exit(0);
    }

    public void enableButton() {
        addOrder.setDisable(false);
    }
}
