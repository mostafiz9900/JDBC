/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.Inventory.ProductService;

import beSkilled.Inventory.CreateMethod;
import beSkilled.Inventory.MySqlConnect;
import beSkilled.Inventory.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ProductService {
    
     static Connection con=MySqlConnect.getConnection();
     public static void insert(Product product){
        String sql="insert into product(name, quantity, unitPrice, totalPrice, parchaseDate, Cat_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1,product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getUnitPrice());
            ps.setDouble(4, product.getTotalPrice());
            ps.setDate(5, new java.sql.Date(product.getPurchaseData().getTime()));
            ps.setInt(6, product.getCategory().getId());
            ps.executeUpdate();
            System.out.println("Data Inserted Successfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
