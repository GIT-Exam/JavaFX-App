package lk.ijse.fxapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/git","root","1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
