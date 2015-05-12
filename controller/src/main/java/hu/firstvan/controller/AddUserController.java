package hu.firstvan.controller;

import hu.firstvan.model.Customer;
import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.view.AddCustomerStage;
import hu.firstvan.view.CustomerStage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * Class to controll the add user stage.
 */
public class AddUserController implements Initializable {

    /**
     * Field to add new customer's name.
     */
    @FXML
    private TextField nCustName;

    /**
     * Field to add new customer's start day.
     */
    @FXML
    private DatePicker nCustDate;

    /**
     * Field to add new customer's address.
     */
    @FXML
    private TextField nCustAddr;

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
    }

    /**
     * Add new customer to database via <code>DatabaseDAO.AddCustomer</code> methods.
     * New customer's data come from fields and first order date will be the system date.
     */
    @FXML
    public void addNewCustomer() {
        Date date = Date.valueOf(nCustDate.getValue());
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.AddCustomer(new Customer(nCustName.getText(), date, nCustAddr.getText()));

        AddCustomerStage.stage.close();

        CustomerStage.update();
    }

    /**
     * Close the <code>AddCustomer stage</code>.
     */
    @FXML
    public void closeStage() {
        AddCustomerStage.stage.close();
    }
}
