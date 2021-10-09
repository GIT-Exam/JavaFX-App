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
public class CustomerViewFormController {
    public JFXTextField txtCustId;
    public JFXTextField txtCustAddress;
    public JFXTextField txtCustName;
    public JFXTextField txtCustContact;
    public JFXButton btnCustSave;
    public TableView tblCustomers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;

    public void initialize(){}

    public void SaveOnAction(ActionEvent actionEvent) {
    }
}
