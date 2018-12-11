package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SummaryService {

    public static void insert(Summary summary) {

        String sql = "insert into summary(id, name, cond, tqty, aqty , sqty, pid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTqty());
            ps.setInt(5, summary.getAqty());
            ps.setInt(6, summary.getSqty());
            ps.setInt(7, summary.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Summary summary) {

        String sql = "update  summary set  name=?, cond=?, tqty=?, aqty=?, sqty=?, pid=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, summary.getName());
            ps.setString(2, summary.getCode());
            ps.setInt(3, summary.getTqty());
            ps.setInt(4, summary.getAqty());
            ps.setInt(5, summary.getSqty());
            ps.setInt(6, summary.getPurchase().getId());
            ps.setInt(7, summary.getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static Summary getPurchaseByProductCode(String code) {
        Summary summary=new Summary();
        String sql = "select * from summary where code=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, code);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                summary.setId(rs.getInt(1));
                summary.setName(rs.getString(2));
                summary.setCode(rs.getString(3));
                summary.setTqty(rs.getInt(4));
                summary.setAqty(rs.getInt(5));
                summary.setSqty(rs.getInt(6));
                
                Purchase p=new Purchase();
                p.setId(rs.getInt(7));
                summary.setPurchase(p);
                
                
                
                
            }
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return summary;
    }
     
     public static List<Summary> getSummaryList() {
        List<Summary> list = new ArrayList<>();
        String sql = "select * from summary";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Summary p = new Summary();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCode(rs.getString(3));
                p.setTqty(rs.getInt(4));
                p.setAqty(rs.getInt(5));
                p.setSqty(rs.getInt(6));
            list.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
}
