package beSkilled.service;

import beSkilled.domain.Sales;
import beSkilled.domain.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesService {
static Connection con=null;
    public static void insert(Sales sales) {
 String sql="insert into purchase (id, name , code, qty, uPrice ,  tPrice, pid) values(?,?,?,?,?,?,?)";
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, sales.getId());
        ps.setString(2, sales.getName());
        ps.setString(3, sales.getCode());
        ps.setInt(4, sales.getQty());
        ps.setDouble(5, sales.getuPrice());
        ps.setDouble(6, sales.gettPrice());
        ps.setInt(7, sales.getPurchase().getId());
        ps.executeUpdate();
        System.out.println("data insert sales");
    } catch (SQLException ex) {
        Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public static void insertForSales(Sales sales) {
        if (sales != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getCode());
            if (summary.getAvailableQty() >= sales.getQty()) {
                int sQty = summary.getSoldQty() + sales.getQty();
                int aQty = summary.getAvailableQty() - sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvailableQty(aQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("your product does not available");
            }

        }
    }

}
