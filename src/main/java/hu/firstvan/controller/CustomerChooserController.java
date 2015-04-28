package hu.firstvan.controller;

import hu.firstvan.model.Customer;
import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.view.AddCustomerStage;
import hu.firstvan.view.MainStage;
import hu.firstvan.view.UserStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * Created by firstvan on 2015.04.17..
 */
public class CustomerChooserController implements Initializable {

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Integer> v_id;

    @FXML
    private TableColumn<Customer, String> v_nev;

    @FXML
    private TableColumn<Customer, Date> v_aldatum;

    @FXML
    private TableColumn<Customer, String> v_szall_cim;

    @FXML
    private TableColumn<Customer, Date> v_elso_vasarlas;

    private UserStage userStage;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        v_id.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(cellData.getValue().getC_id()));
        v_nev.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<String>(cellData.getValue().getC_name()));
        v_aldatum.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Date>(cellData.getValue().getC_startDate()));
        v_szall_cim.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<String>(cellData.getValue().getC_addr()));
        v_elso_vasarlas.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Date>(cellData.getValue().getC_firstOrder()));
    }

    /**
     * List all of customer to <code>TableView</code>.
     */
    @FXML
    public void setCustomerTable() {
        ObservableList<Customer> customerData = FXCollections.observableArrayList(DatabaseDAO.getAllCustomer());
        customerTable.setItems(customerData);
    }

    /**
     * Display a <code>AddCustomer stage</code> when "Új vásárló" button is clicked.
     */
    @FXML
    public void newCustomer() {
        try {
            new AddCustomerStage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Close actual stage.
     */
    @FXML
    public void closeStage() {
        UserStage.stage.close();
    }

    /**
     * Set the actual customer, and show the changed <code>MainStage</code>.
     */
    @FXML
    public void selectedCustomer() {
        Datas.setCustomer(customerTable.getSelectionModel().getSelectedItem());
        UserStage.stage.close();

        try {
            MainStage.setCustName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
