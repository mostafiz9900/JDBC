
package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SummaryService {
    
    
     public static void insert(Summary summary) {
        String sql = "insert into summary(id, name , code, tqty, avableqty, soltQty, pid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTotalqty());
            ps.setDouble(5, summary.getAvabileqty());
            ps.setDouble(6, summary.getSoldqty());
            ps.setDouble(6, summary.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void update(Summary summary) {
        String sql = "update  summary set  name=? , code=?, tqty=?, avableqty=?, soltQty=?, pid=? where id=?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTotalqty());
            ps.setDouble(5, summary.getAvabileqty());
            ps.setDouble(6, summary.getSoldqty());
            ps.setDouble(6, summary.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
}
