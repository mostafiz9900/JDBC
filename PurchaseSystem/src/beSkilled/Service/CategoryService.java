
package beSkilled.Service;

import beSkilled.connection.MyConnection;
import beSkilled.domain.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoryService {
   static Connection con=MyConnection.getConnect();
   
   public static void CreateTable(){
   String sql="create table category(id int(11) auto_increment primary key, name varchar(50))";
       try {
           PreparedStatement ps=con.prepareStatement(sql);
           ps.executeUpdate();
           System.out.println("Table Create Successfully");
       } catch (SQLException ex) {
           Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public static void insertDatsC(Category c){
        String sql="insert into category(name) values(?)";
       try {
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setString(1, c.getName());
           ps.executeUpdate();
           System.out.println("Data Inserted Successfully");
       } catch (SQLException ex) {
           Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }

    public static List<Category> getCatList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
