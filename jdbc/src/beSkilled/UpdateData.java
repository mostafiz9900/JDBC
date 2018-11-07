package beSkilled;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateData {
    
    static Connection conn = MySqlConncet.getConnection();
    
    public static void updateData(String name, int id) {
        String sql = "update division set name=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Data updat");
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void getDataById(int id) {
        String spl = "select * from division where id=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(spl);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(" Id " + rs.getInt(1) + " name " + rs.getString(2));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
