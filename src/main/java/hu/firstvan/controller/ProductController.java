package hu.firstvan.controller;

import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.model.Products;
import hu.firstvan.view.AddProductStage;
import hu.firstvan.view.MainStage;
import hu.firstvan.view.ProductStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Manage all interactions on Product window.
 */
public class ProductController implements Initializable {

    /**
     * List for table view to appear ordered items.
     */
    private ObservableList<Products> obList = FXCollections.observableArrayList(new ArrayList<>());

    /**
     * Table view to appear ordered items.
     */
    @FXML
    private TableView<Products> productTable;

    /**
     * First column of table. It's id of product.
     */
    @FXML
    private TableColumn<Products, Integer> itemID;

    /**
     * Second column of table. It's name of product.
     */
    @FXML
    private TableColumn<Products, String> itemName;

    /**
     * Third column of table. It's price of product.
     */
    @FXML
    private TableColumn<Products, Integer> itemPrice;

    /**
     * Fourth column of table. It's ordered piece of product.
     */
    @FXML
    private TableColumn<Products, Integer> itemPiece;

    /**
     * Fifth column of table. It's price * piece of ordered product.
     */
    @FXML
    private TableColumn<Products, Integer> subTotal;

    /**
     * Label for order total.
     */
    @FXML
    private Label totalPrice;

    /**
     * Button to modify an orderd item.
     */
    @FXML
    private Button modifyButton;

    /**
     * Field to set piece of modified item.
     */
    @FXML
    private TextField modifiedPiece;

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
        itemID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getItemNo()));
        itemName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getName()));
        itemPrice.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPrice()));
        itemPiece.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getOrderdPiece()));
        subTotal.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getSubTotal()));
    }

    /**
     * Update table of ordered items.
     *
     * @param list ordered item list.
     */
    public void updateTable(ArrayList<Products> list) {
        obList.clear();
        obList = FXCollections.observableArrayList(list);
        productTable.setItems(obList);
    }

    /**
     * Open a window to add product.
     */
    @FXML
    public void addProductItem() {
        new AddProductStage();
        ProductStage.stage.close();
    }

    /**
     * Finalize ordered products.
     */
    @FXML
    public void closeOrder() {
        DatabaseDAO databaseDAO = new DatabaseDAO();
        databaseDAO.closeOrder();
        ProductStage.stage.close();
        Datas.getOrderedItems().clear();
        MainStage.stage.show();
    }

    /**
     * Remove an item from ordered product list.
     */
    @FXML
    public void deleteItem() {
        Datas.remove(productTable.getSelectionModel().getSelectedItem());
        ObservableList<Products> obList = FXCollections.observableArrayList(Datas.getOrderedItems());
        productTable.setItems(obList);
        updateOrderTotal();
    }

    /**
     * Close current window.
     */
    @FXML
    public void close() {
        ProductStage.stage.close();
        MainStage.stage.show();
    }

    /**
     * Update the all ordered products price and show it.
     */
    public void updateOrderTotal() {
        totalPrice.setText(Datas.getGrandTotal() + " FT");
    }

    /**
     * Return the table view of ordered products.
     *
     * @return {@code tableview} of ordered items
     */
    public TableView<Products> getTableView() {
        return productTable;
    }

    /**
     * Disable modify button, when no item selected in table.
     *
     * @param b disable button
     */
    public void disableButton(Boolean b) {
        modifyButton.setDisable(b);
    }

    /**
     * Refresh the window's elements, after modify an ordered item piece.
     */
    @FXML
    public void modify() {
        Datas.modifyPiece(productTable.getSelectionModel().getSelectedItem(), Integer.valueOf(modifiedPiece.getText()));
        obList.clear();
        obList = FXCollections.observableArrayList(Datas.getOrderedItems());
        productTable.setItems(obList);
        updateOrderTotal();
        modifiedPiece.setText("");
    }
}
