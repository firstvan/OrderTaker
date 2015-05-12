package hu.firstvan.controller;

import hu.firstvan.model.Customer;
import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.view.AddCustomerStage;
import hu.firstvan.view.CustomerStage;
import hu.firstvan.view.MainStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * Class for manage {@code CustomerChooserStage's} interactions.
 */
public class CustomerChooserController implements Initializable {

    /**
     *  Appear all customer in this table.
     */
    @FXML
    private TableView<Customer> customerTable;

    /**
     * First column of table. This is the customer id.
     */
    @FXML
    private TableColumn<Customer, Integer> v_id;

    /**
     * Second column of table. This is the cusomer name.
     */
    @FXML
    private TableColumn<Customer, String> v_nev;

    /**
     * Third column of table. This is the cusomer start day.
     */
    @FXML
    private TableColumn<Customer, Date> v_aldatum;

    /**
     * Fourth column of table. This is the customer's address.
     */
    @FXML
    private TableColumn<Customer, String> v_szall_cim;

    /**
     * Fifth column of table. This is the customer's first shopping date.
     */
    @FXML
    private TableColumn<Customer, Date> v_elso_vasarlas;

    @FXML
    private Button o_take;

    /**
     * Stage for access CustomerStage.
     */
    private CustomerStage customerStage;

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

        customerTable.getSelectionModel().selectedItemProperty().addListener((obs, oldselection, newSelection) -> {
            if (newSelection != null) {
                o_take.setDisable(true);
                //logger.info("Add button disabled.");
            } else {
                o_take.setDisable(false);
                //logger.info("Add button enabled.");
            }
        });
    }

    /**
     * List all of customer to <code>TableView</code>.
     */
    @FXML
    public void setCustomerTable() {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        ObservableList<Customer> customerData = FXCollections.observableArrayList(databaseDAO.getAllCustomer());
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
        CustomerStage.stage.close();
    }

    /**
     * Set the actual customer, and show the changed <code>MainStage</code>.
     */
    @FXML
    public void selectedCustomer() {
        Datas.setCustomer(customerTable.getSelectionModel().getSelectedItem());
        CustomerStage.stage.close();

        try {
            MainStage.setCustName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
