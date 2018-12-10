package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {

    static Connection con = null;

    public static void insert(Purchase purchase) {
        String sql = "inset into purchase(id, name, code, tqty, uprice, tprice) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, purchase.getId());
            ps.setString(2, purchase.getName());
            ps.setString(3, purchase.getCode());
            ps.setInt(4, purchase.getQty());
            ps.setDouble(5, purchase.getUprice());
            ps.setDouble(6, purchase.getTprice());
            ps.executeUpdate();
            System.out.println("Data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Purchase purchase) {
        String sql = "update  purchase set  name=?, code=?, tqty=?, uprice=?, tprice=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, purchase.getName());
            ps.setString(2, purchase.getCode());
            ps.setInt(3, purchase.getQty());
            ps.setDouble(4, purchase.getUprice());
            ps.setDouble(4, purchase.getTprice());
            ps.setInt(6, purchase.getId());
            ps.executeUpdate();
            System.out.println("Data update success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Purchase purchase) {
        String sql = "delete from purchase where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, purchase.getId());
            ps.executeUpdate();
            System.out.println("Data delete success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Purchase getPurchaseByProductCode(String code) {
        Purchase purchase = new Purchase();
        String sql = "select * from purchase where code=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setCode(rs.getString(3));
                purchase.setQty(rs.getInt(4));
                purchase.setUprice(rs.getDouble(5));
                purchase.setTprice(rs.getDouble(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return purchase;

    }
    
    public static List<Purchase> getList(){
        List<Purchase> list=new ArrayList<>();
        String sql="select * from purchase";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                Purchase purchase=new Purchase();
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setCode(rs.getString(3));
                purchase.setQty(rs.getInt(4));
                purchase.setUprice(rs.getDouble(5));
                purchase.setTprice(rs.getDouble(6));
                list.add(purchase);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    
    
    }
            

    public static void insretMain(Purchase purchase) {
        if (purchase != null) {
            insert(purchase);
            Purchase p = getPurchaseByProductCode(purchase.getCode());
            try {
                Summary summary = SummaryService.getSummaryByProductCode(purchase.getCode());
                if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                    int totalQty = summary.getTqty() + purchase.getQty();
                    int aviableQty = summary.getAvlqty() + purchase.getQty();
                    summary.setTqty(totalQty);
                    summary.setAvlqty(aviableQty);

                }
                SummaryService.update(summary);
            } catch (Exception e) {
                Summary summary2 = new Summary(purchase.getId(), purchase.getName(), purchase.getCode(), purchase.getQty(), 0, purchase.getQty(), p);
                SummaryService.insert(summary2);
            }

        }
    }
}
