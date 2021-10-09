package lk.ijse.fxapp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    public TableView tblItems;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDesc;
    public TableColumn colQty;

    public void initialize(){}

    public void saveItemOnAction(ActionEvent actionEvent) {
    }
}
