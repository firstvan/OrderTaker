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
 * Created by firstvan on 2015.04.14..
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField nCustName;

    @FXML
    private DatePicker nCustDate;

    @FXML
    private TextField nCustAddr;

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
        DatabaseDAO.AddCustomer(new Customer(nCustName.getText(), date, nCustAddr.getText()));

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
