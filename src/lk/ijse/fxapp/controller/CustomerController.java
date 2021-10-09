package lk.ijse.fxapp.controller;

import lk.ijse.fxapp.db.DBConnection;
import lk.ijse.fxapp.model.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class CustomerController {
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO Customer VALUES(?,?,?,?)";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(query);
        pstm.setObject(1,customer.getCustomer_id());
        pstm.setObject(2,customer.getCustomer_name());
        pstm.setObject(3,customer.getAddress());
        pstm.setObject(4,customer.getContact());

        return pstm.executeUpdate()>0;

    }
}
