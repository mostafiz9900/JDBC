/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CreateMethod {
    static Connection con=MySqlConnect.getConnection();
    
//    public static void createTable(){
//        String sql="create table product(id, int(11) auto_increment primary key, name varchar(50) quitPrice int(11), unitePrice doubke, totalPrice doubke, purchaseDate Date, cat_id int(11), FOREIGN KEY (cat_id) REFERENCES category(id))";
//        try {
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1,Product.getN);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
    
    public static void insert(Product product){
        String sql="insert into product(name, quantity, unitprice, totalPrice, parchaseDate,Cat_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1,product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getUnitPrice());
            ps.setDouble(4, product.getTotalPrice());
            ps.setDate(4, product.getPurchaseData());
            ps.setInt(5, product.getCut_id());
            ps.executeUpdate();
            System.out.println("Data Inserted Successfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
