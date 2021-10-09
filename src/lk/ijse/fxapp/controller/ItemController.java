package lk.ijse.fxapp.controller;

import lk.ijse.fxapp.db.DBConnection;
import lk.ijse.fxapp.model.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class ItemController {
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO Product VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(query);
        pstm.setObject(1,item.getProduct_id());
        pstm.setObject(2,item.getProduct_name());
        pstm.setObject(3,item.getDescription());
        pstm.setObject(4,item.getQty());

        return pstm.executeUpdate()>0;

    }

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM Item";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet rst = pstm.executeQuery();
        ArrayList<Item> items = new ArrayList<>();

        while (rst.next()){

            items.add(new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4)
            ));

        }

        return items;

    }
}
