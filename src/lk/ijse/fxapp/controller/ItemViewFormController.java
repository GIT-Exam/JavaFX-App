package lk.ijse.fxapp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.fxapp.model.Item;
import lk.ijse.fxapp.view.tblModel.ItemTM;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class ItemViewFormController {
    public JFXTextField txtItemId;
    public JFXTextField txtItemDesc;
    public JFXTextField txtItemName;
    public JFXTextField txtItemQty;
    public JFXButton btnItemSave;
    public TableView<ItemTM> tblItems;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDesc;
    public TableColumn colQty;

    public void initialize() {
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("product_id"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("product_name"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtItemName.requestFocus();
            }
        });
    }

    public void saveItemOnAction(ActionEvent actionEvent) {

        ItemController controller = new ItemController();

        try {
            boolean saved = controller.saveItem(new Item(txtItemId.getText(), txtItemName.getText(), txtItemDesc.getText(), Integer.parseInt(txtItemQty.getText())));
            if (saved) {
                loadAllProducts();
                new Alert(Alert.AlertType.CONFIRMATION, "Successful").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Cannot Save").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadAllProducts() {

        ItemController controller = new ItemController();
        try {
            ArrayList<Item> items = controller.getAllItems();
            if (items != null){

                ObservableList<ItemTM> itemTMS = FXCollections.observableArrayList();
                for (Item item : items){
                    itemTMS.add(new ItemTM(item.getProduct_id(),item.getProduct_name(),item.getDescription(),item.getQty()));
                }
                tblItems.setItems(itemTMS);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
