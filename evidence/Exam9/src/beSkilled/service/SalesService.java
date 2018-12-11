
package beSkilled.service;



import beSkilled.domain.Sales;
import beSkilled.domain.Summary;
import static beSkilled.service.PurchaseService.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalesService {
    public static void insert(Sales sales) {

        String sql = "insert into sales(id, name, cond, qty, uprice , tprice, pid) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sales.getId());
            ps.setString(2, sales.getName());
            ps.setString(3, sales.getCode());
            ps.setInt(4, sales.getQty());
            ps.setDouble(5, sales.getUprice());
            ps.setDouble(6, sales.getTprice());
            ps.setInt(7, sales.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("data insert success");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void insertForSales(Sales sales) {
        if (sales !=null) {
            Summary summary=SummaryService.getPurchaseByProductCode(sales.getCode());
            if (summary.getAqty()>=sales.getQty()) {
                int soldeQty=summary.getSqty()+sales.getQty();
                int availableQty=summary.getAqty()-sales.getQty();
                summary.setSqty(soldeQty);
                summary.setSqty(soldeQty);
                SummaryService.insert(summary);
                
            }else{
                System.out.println("your product not sufficint");
            }
            
        }
    }
}
