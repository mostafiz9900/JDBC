package beSkilled.service;

import beSkilled.domain.Sales;
import beSkilled.domain.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesService {

    public static void insert(Sales sales) {
        String sql = "inset into sales(id, name, code, tqty, uprice, tprice, pid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sales.getId());
            ps.setString(2, sales.getName());
            ps.setString(3, sales.getCode());
            ps.setInt(4, sales.getQty());
            ps.setDouble(5, sales.getUprice());
            ps.setDouble(6, sales.getTprice());
            ps.setInt(1, sales.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("Data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertForSales(Sales sales) {
        if (sales != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getCode());
            if (summary.getAvlqty() >= sales.getQty()) {
                int sQty = summary.getSoldqty() + sales.getQty();
                int aQty = summary.getAvlqty() - sales.getQty();
                summary.setSoldqty(sQty);
                summary.setAvlqty(aQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("your does not sufficient product");
            }

        }
    }

    private static List<Sales> getSalesList() {
        List<Sales> list = new ArrayList<>();
        String sql = "select * from sales";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sales sales = new Sales();
                sales.setName(rs.getString(2));
                sales.setCode(rs.getString(3));
                sales.setQty(rs.getInt(4));
                sales.setUprice(rs.getDouble(5));
                sales.setTprice(rs.getDouble(6));
                list.add(sales);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}
