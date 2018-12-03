package beSkilled.service;

import beSkilled.MysqlConnection;
import beSkilled.domain.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {

    static Connection conn = MysqlConnection.getConnection();

    public static void createTable() {
        String sql = "create table purchase(id int auto_increment primary key, productName varchar(30) not null,productCode varchar(30) not null, qty int not null, unitprice double not null, totalPrice double not null, purchasedate Date not null)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table create");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertData(Purchase purchase) {
        String sql = "insert into purchase(productName, productCode, qty, unitprice, totalPrice, purchasedate) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, purchase.getProductName());
            ps.setString(2, purchase.getProductCode());
            ps.setInt(3, purchase.getQty());
            ps.setDouble(4, purchase.getUnitPrice());
            ps.setDouble(5, purchase.getTotalPrice());
            ps.setDate(6, new java.sql.Date(purchase.getPurchasedate().getTime()));
            ps.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
