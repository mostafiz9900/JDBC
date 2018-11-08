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
public class UpdateData {

    static Connection con = ConnectionDbms.getConnection();

    public static void update(Student s) {
        String sql = "update  student set name=?, email=? where id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getId());
            ps.executeUpdate();
            

            System.out.println("update data");
        } catch (SQLException ex) {
            Logger.getLogger(CreatTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
