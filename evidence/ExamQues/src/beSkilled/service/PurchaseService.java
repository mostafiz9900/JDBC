package beSkilled.service;

import beSkilled.domain.Purcahse;
import beSkilled.domain.Summary;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {

    static Connection con = null;

    public static void insert(Purcahse purchase) {
        String sql = "insert into purchase(id, name , code, qty, uprice, tprice) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, purchase.getId());
            ps.setInt(1, purchase.getId());
            ps.setInt(1, purchase.getId());
            ps.setInt(1, purchase.getId());
            ps.setInt(1, purchase.getId());
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static Purcahse getProductByProductCode(String code) {
        String sql = "insert into purchase(id, name , code, qty, uprice, tprice) values(?,?,?,?,?,?)";
        return null;
        
          

    }
      public static Purcahse getProductByDetails(String purchase) {
        String sql = "insert into purchase(id, name , code, qty, uprice, tprice) values(?,?,?,?,?,?)";
        return null;
       

    }
     
      public static void insertMain(Purcahse purchase) {
        if(purchase !=null){
            insert(purchase);
            Purcahse p=getProductByProductCode(purchase.getCode());
            
            try {
                Summary summary=SummaryService.getSummaryProducDetail(purchase.getCode());
                if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                    int totalQty=summary.getTqty() + purchase.getQty();
                    int avalQty=summary.getAvlbqty()+ purchase.getQty();
                    summary.setTqty(totalQty);
                    summary.setAvlbqty(avalQty);
                    
                }
               SummaryService.update(summary);
            } catch (Exception e) {
                Summary summary3=new Summary(purchase.getId(), purchase.getName(), purchase.getCode(), purchase.getQty(), 0, purchase.getQty(),p);
                SummaryService.insert(summary3);
            }
            
        
        
        }

    }
}
