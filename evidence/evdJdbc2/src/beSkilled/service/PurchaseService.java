
package beSkilled.service;

import beSkilled.connection.MySqlDbConnection;
import beSkilled.domain.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {
    static Connection con=MySqlDbConnection.getConnection();
    
    public static void createTable(){
    String sql="create table purchase(id int(11) primary key, name varchar(50) not null, price double not null, date Date)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            System.out.println("Table cteate success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void insert(Purchase pur){
    String sql="insert into purchase values(?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, pur.getId());
            ps.setString(2, pur.getName());
            ps.setDouble(3, pur.getPrice());
            ps.setDate(4, new java.sql.Date(pur.getDate().getTime()));
            ps.executeUpdate();
            System.out.println("insert data success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public static void update(Purchase pur){
    String sql="insert into purchase values(?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, pur.getId());
            ps.setString(2, pur.getName());
            ps.setDouble(3, pur.getPrice());
            ps.setDate(4, new java.sql.Date(pur.getDate().getTime()));
            ps.executeUpdate();
            System.out.println("insert data success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static List<Purchase> getPurchaseLisst(){
    List<Purchase> list=new ArrayList<>();
    String sql="select * from purchase";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                list.add(new Purchase(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
