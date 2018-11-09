/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.jdbcConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mostafizur
 */
public class lists {
    static Connection con=ConnectJdbc.getConnect();
    public static List<Student> getStudentList(){
        List<Student> list=new ArrayList<>();
        String sql="select * from student";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Student(rs.getInt(1),rs.getString(2), rs.getString(3)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(lists.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    
    
    }
}
