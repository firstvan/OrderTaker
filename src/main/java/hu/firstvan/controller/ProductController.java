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
 * Created by firstvan on 2015.04.23..
 */
public class ProductController implements Initializable {

    ObservableList<Products> obList = FXCollections.observableArrayList(new ArrayList<>());

    @FXML
    private TableView<Products> productTable;

    @FXML
    private TableColumn<Products, Integer> itemID;

    @FXML
    private TableColumn<Products, String> itemName;

    @FXML
    private TableColumn<Products, Integer> itemPrice;

    @FXML
    private TableColumn<Products, Integer> itemPiece;

    @FXML
    private TableColumn<Products, Integer> subTotal;

    @FXML
    private Label totalPrice;

    @FXML
    private Button modifyButton;

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

    public void updateTable(ArrayList<Products> list) {
        obList.clear();
        obList = FXCollections.observableArrayList(list);
        productTable.setItems(obList);
    }

    @FXML
    public void addProductItem() {
        new AddProductStage();
        ProductStage.stage.close();
    }

    @FXML
    public void closeOrder() {
        DatabaseDAO.closeOrder();
        ProductStage.stage.close();
        Datas.getOrderdItems().clear();
        MainStage.stage.show();
    }

    @FXML
    public void deleteItem() {
        Datas.remove(productTable.getSelectionModel().getSelectedItem());
        ObservableList<Products> obList = FXCollections.observableArrayList(Datas.getOrderdItems());
        productTable.setItems(obList);
        updateOrderTotal();
    }

    @FXML
    public void close() {
        ProductStage.stage.close();
        MainStage.stage.show();
    }

    public void updateOrderTotal() {
        totalPrice.setText(Datas.getGrandTotal() + " FT");
    }

    public TableView<Products> getTableView() {
        return productTable;
    }

    public void disableButton(Boolean b) {
        modifyButton.setDisable(b);
    }

    @FXML
    public void modify() {
        Datas.modifyPiece(productTable.getSelectionModel().getSelectedItem(), Integer.valueOf(modifiedPiece.getText()));
        obList.clear();
        obList = FXCollections.observableArrayList(Datas.getOrderdItems());
        productTable.setItems(obList);
        updateOrderTotal();
        modifiedPiece.setText("");
    }
}
