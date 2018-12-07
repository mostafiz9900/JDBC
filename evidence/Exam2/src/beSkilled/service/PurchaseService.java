/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Summary;
import java.sql.Connection;

/**
 *
 * @author Mostafizur
 */
public class PurchaseService {
    
    static Connection con = null;
    
    public static void insert(Purchase purchase) {
        
    }
    
    public static void update(Purchase purchase) {
        
    }
    
    public static Purchase getPurchaseByProductCode(String code) {
        return null;
        
    }
    
    public static void inseraMain(Purchase purchase) {
        if (purchase != null) {
            insert(purchase);
            Purchase p = getPurchaseByProductCode(purchase.getCode());
            try {
                Summary summary = SummaryService.getSummaryByProductCode(purchase.getCode());
                if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                    int totalQty = summary.getQqty() + purchase.getQty();
                    int avlableQty = summary.getAvlQty() + purchase.getQty();
                    summary.setQqty(totalQty);
                    summary.setAvlQty(avlableQty);
                    
                }
                SummaryService.update(summary);
            } catch (Exception e) {
                Summary summary2 = new Summary(purchase.getId(), purchase.getName(), purchase.getCode(), purchase.getQty(), 0, purchase.getQty(), p);
                SummaryService.insert(summary2);
            }
            
        }
        
    }
    
}
