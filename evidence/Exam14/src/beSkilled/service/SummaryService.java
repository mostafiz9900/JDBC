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
        String sql = "insert into sales(id , name , code, totalQty , availableQty, soldaQty, pId) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTotalQty());
            ps.setDouble(5, summary.getAvailableQty());
            ps.setDouble(6, summary.getSoldQty());
            ps.setInt(7, summary.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Summary summary) {
        String sql = "update  sales set totalQty=? , availableQty=?, soldaQty=?, where code=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, summary.getId());
            ps.setString(2, summary.getName());
            ps.setString(3, summary.getCode());
            ps.setInt(4, summary.getTotalQty());
            ps.setDouble(5, summary.getAvailableQty());
            ps.setDouble(6, summary.getSoldQty());
            ps.setInt(7, summary.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Summary getSummaryByProductCode(String code) {
        Summary summary = new Summary();
        String sql = "select * from summary where code =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                summary.setId(rs.getInt(1));
                summary.setName(rs.getString(2));
                summary.setCode(rs.getString(3));
                summary.setTotalQty(rs.getInt(4));
                summary.setAvailableQty(rs.getInt(5));
                summary.setSoldQty(rs.getInt(6));
                Purchase p = new Purchase();
                p.setId(rs.getInt(7));
                summary.setPurchase(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
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
                Summary s = new Summary();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setCode(rs.getString(3));
                s.setTotalQty(rs.getInt(4));
                s.setAvailableQty(rs.getInt(5));
                s.setSoldQty(rs.getInt(6));
                list.add(s);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
}
