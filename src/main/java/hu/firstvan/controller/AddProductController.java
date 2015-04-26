package hu.firstvan.controller;

import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.model.Products;
import hu.firstvan.view.AddProductStage;
import hu.firstvan.view.ProductStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by firstvan on 2015.04.23..
 */
public class AddProductController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Products> productTable;

    @FXML
    private TableColumn<Products, Integer> itemID;

    @FXML
    private TableColumn<Products, String> itemName;

    @FXML
    private TableColumn<Products, Integer> itemPrice;

    @FXML
    private TableColumn<Products, Integer> rabat1;

    @FXML
    private TableColumn<Products, Integer> rabat1Price;

    @FXML
    private TableColumn<Products, Integer> rabat2;

    @FXML
    private TableColumn<Products, Integer> rabat2Price;

    @FXML
    private TableColumn<Products, Integer> rabat3;

    @FXML
    private TableColumn<Products, Integer> rabat3Price;

    @FXML
    private TextField productPiece;

    @FXML
    private TextField searchText;

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
        rabat1.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat1()));
        rabat1Price.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat1Price()));
        rabat2.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat2()));
        rabat2Price.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat2Price()));
        rabat3.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat3()));
        rabat3Price.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRabat3Price()));
    }

    public void updateTable() {
        ObservableList<Products> obList = FXCollections.observableArrayList(DatabaseDAO.getSearchedProducts(""));
        productTable.setItems(obList);
    }

    @FXML
    public void addProd() {
        if (productTable.getSelectionModel().getSelectedItem() != null) {
            Products products = productTable.getSelectionModel().getSelectedItem();
            products.setOrderdPiece(Integer.valueOf(productPiece.getText()));
            Datas.add(products);
            productPiece.setText("");
        }
    }

    @FXML
    public void closeStage() {
        AddProductStage.stage.close();
        ProductStage.stage.show();
    }

    @FXML
    public void search() {
        ObservableList<Products> obList = FXCollections.observableArrayList(DatabaseDAO.getSearchedProducts(searchText.getText()));
        productTable.setItems(obList);
    }
}
