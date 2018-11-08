package beSkilled.exam;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbms {

    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DBNAME = "mkt";
    private static final String URL = HOST + "/" + DBNAME;
    private static java.sql.Connection con = null;

    public static java.sql.Connection getConnection() {
        try {
            con = DriverManager.getConnection(URL, "root", "1234");
            System.out.println("Conncection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
}
