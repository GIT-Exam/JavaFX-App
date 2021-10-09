package lk.ijse.fxapp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.fxapp.model.Customer;
import lk.ijse.fxapp.view.tblModel.CustomerTM;

import java.sql.SQLException;

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
    public TableView<CustomerTM> tblCustomers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;

    public void initialize() {
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        tblCustomers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomers.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("contact"));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtCustName.requestFocus();
            }
        });
    }

    public void SaveOnAction(ActionEvent actionEvent) {

        CustomerController controller = new CustomerController();

        try {
            boolean saved = controller.saveCustomer(new Customer(txtCustId.getText(), txtCustName.getText(), txtCustAddress.getText(), txtCustContact.getText()));
            if (saved) {
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
}
