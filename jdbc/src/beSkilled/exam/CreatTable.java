package beSkilled.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatTable {

    static Connection con = ConnectionDbms.getConnection();

    public static void CreateTable3() {
        String sql = "create table student(id int(10), name varchar(30),email varchar(30))";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Creat table");
        } catch (SQLException ex) {
            Logger.getLogger(CreatTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    
}
