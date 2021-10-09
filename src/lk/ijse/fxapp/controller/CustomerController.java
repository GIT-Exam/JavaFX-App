package lk.ijse.fxapp.controller;

import lk.ijse.fxapp.db.DBConnection;
import lk.ijse.fxapp.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM Customer";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet rst = pstm.executeQuery();
        ArrayList<Customer> customers = new ArrayList<>();

        while (rst.next()){

            customers.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));

        }

        return customers;

    }
}
