package beSkilled.jdbcConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectJdbc {

    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DBNAME = "mkt";
    private static final String URL = HOST + "/" + DBNAME;
   private static Connection con=null;
   
   public static Connection getConnect(){
        try {
            con=DriverManager.getConnection(URL,"root","1234");
            System.out.println("::Connection::");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
   
   }
   
   
}
