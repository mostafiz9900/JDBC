/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;


import beSkilled.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SummaryService {
    public static void insert(Summary summary) {
        String sql = "insert into summary(id , name , code , qty , uprice ) values(?,?,?,?,?,?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTotalQty());
            ps.setInt(5, summary.getAvalabilQty());
            ps.setInt(6, summary.getSoldQty());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static void update(Summary summary) {
        String sql = "update summary set name=? , code=? , qty=? , tqty=?, aQty=?,sQty=? pid=? where id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, summary.getName());
            ps.setString(2, summary.getCode());
            ps.setInt(3, summary.getTotalQty());
            ps.setInt(4, summary.getAvalabilQty());
            ps.setInt(4, summary.getSoldQty());
            ps.setInt(6, summary.getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static Summary getSummaryByProductCode(String code) {
        return null;
        
    }
}
