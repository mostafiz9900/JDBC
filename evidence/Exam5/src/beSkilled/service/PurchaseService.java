/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Summary;

/**
 *
 * @author Mostafizur
 */
public class PurchaseService {

    public static void insert(Purchase purchase) {
        
    }

    public static void update(Purchase purchase) {
        
    }

    public static Purchase getPurchaseByProductCode(String code) {
        return null;
        
    }

    public static void insertMain(Purchase purchase) {
        if (purchase != null) {
            insert(purchase);
            Purchase p = getPurchaseByProductCode(purchase.getCode());
            try {
                Summary summary = SummaryService.getSummaryByPoductCode(purchase.getCode());
                if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                    int totalQty = summary.getTqty() + purchase.getQty();
                    int avblQty = summary.getAvlqty() + purchase.getQty();
                    summary.setTqty(avblQty);
                    summary.setAvlqty(avblQty);
                    
                }
                SummaryService.update(summary);
            } catch (Exception e) {
                Summary summary2 = new Summary(purchase.getId(), purchase.getName(), purchase.getCode(), purchase.getQty(), 0, purchase.getQty(), p);
                SummaryService.insert(summary2);
            }
            
        }
        
    }
}
