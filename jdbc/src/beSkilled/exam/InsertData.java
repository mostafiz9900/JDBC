/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.exam;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InsertData {
     static Connection con = ConnectionDbms.getConnection();
    
      public static void insert(Student s) {
        String sql = "insert into student(id, name, email) values(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();
            
            System.out.println("insert data");
        } catch (SQLException ex) {
            Logger.getLogger(CreatTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
