
package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Sales;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesService {
     public static void insert(Sales sales) {
        String sql = "insert into sales(id, name , code, qty, uprice, tprice, pid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sales.getId());
            ps.setString(2, sales.getName());
            ps.setString(3, sales.getCode());
            ps.setInt(4, sales.getQty());
            ps.setDouble(5, sales.getTprice());
            ps.setDouble(6, sales.getTprice());
            ps.setInt(7, sales.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
