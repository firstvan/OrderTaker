package hu.firstvan.controller;

import hu.firstvan.model.DatabaseDAO;
import hu.firstvan.model.Datas;
import hu.firstvan.model.Products;
import hu.firstvan.view.AddProductStage;
import hu.firstvan.view.ProductStage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a class to controll the <code>AddProduct</code> stage's interaction.
 */
public class AddProductController implements Initializable {

    /**
     * <code>TableView</code> to show product in a table.
     */
    @FXML
    private TableView<Products> productTable;

    /**
     * First column of <code>TableView</code> to show product id.
     */
    @FXML
    private TableColumn<Products, Integer> itemID;

    /**
     * Second column of <code>TableView</code> to show product name.
     */
    @FXML
    private TableColumn<Products, String> itemName;

    /**
     * Third column of <code>TableView</code> to show product price.
     */
    @FXML
    private TableColumn<Products, Integer> itemPrice;

    /**
     * Fourth column of <code>TableView</code> to show how many piece need to be order to get first discount.
     */
    @FXML
    private TableColumn<Products, Integer> rabat1;

    /**
     * Fifth column of <code>TableView</code> to show first discount price.
     */
    @FXML
    private TableColumn<Products, Integer> rabat1Price;

    /**
     * Sixth column of <code>TableView</code> to show how many piece need to be order to get second discount.
     */
    @FXML
    private TableColumn<Products, Integer> rabat2;

    /**
     * Seventh column of <code>TableView</code> to show second discount price.
     */
    @FXML
    private TableColumn<Products, Integer> rabat2Price;

    /**
     * Eighth column of <code>TableView</code> to show how many piece need to be order to get third discount.
     */
    @FXML
    private TableColumn<Products, Integer> rabat3;

    /**
     * Ninth column of <code>TableView</code> to show third discount price.
     */
    @FXML
    private TableColumn<Products, Integer> rabat3Price;

    /**
     * <code>Text field</code> to assigned number.
     */
    @FXML
    private TextField productPiece;

    /**
     * <code>Text field</code> to fill products by name.
     */
    @FXML
    private TextField searchText;

    /**
     * {@code Button} to add product.
     */
    @FXML
    private Button addProduct;

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

        productTable.getSelectionModel().selectedItemProperty().addListener((obs, oldselection, newSelection) -> {
            if (newSelection != null) {
                disableButton(false);
                //logger.info("Add button disabled.");
            } else {
                disableButton(true);
                //logger.info("Add button enabled.");
            }
        });

    }

    /**
     * Update tableview width all product.
     */
    public void updateTable() {
        ObservableList<Products> obList = FXCollections.observableArrayList(DatabaseDAO.getSearchedProducts(""));
        productTable.setItems(obList);
    }

    /**
     * Add a product to orders.s
     */
    @FXML
    public void addProd() {
        try {
            Products products = productTable.getSelectionModel().getSelectedItem();
            products.setOrderdPiece(Integer.valueOf(productPiece.getText()));
            Datas.add(products);
            productPiece.setText("");
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Darabszám hiba.");
            alert.show();
        }

    }

    /**
     * Close addproduct stage.
     */
    @FXML
    public void closeStage() {
        AddProductStage.stage.close();
        ProductStage.stage.show();
    }

    /**
     * Update tableview width searched items.
     */
    @FXML
    public void search() {
        Task<Void> task = new Task<Void>() {
            @Override protected Void call() throws Exception {
                ObservableList<Products> obList = FXCollections.observableArrayList(DatabaseDAO.getSearchedProducts(searchText.getText()));
                productTable.setItems(obList);
                return null;
            }

        };

        new Thread(task).start();

    }

    /**
     * Return the table view of listed products.
     *
     * @return TableView table view of listed products.
     */
    public TableView<Products> getTableView() {
        return productTable;
    }

    /**
     * Disable add button when no selected item.
     *
     * @param b value of button is enabled
     */
    public void disableButton(Boolean b) {
        addProduct.setDisable(b);
    }
}
