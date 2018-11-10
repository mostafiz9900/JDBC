package beSkilled.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DBNAME = "mkt";
    private static final String URL = HOST + "/" + DBNAME;
    private static Connection con=null;
    
    public static Connection getConnect(){
        try {
            con=DriverManager.getConnection(URL,"root","1234");
            System.out.println(":::::Connection::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    
    
    }
}
