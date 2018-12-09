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
    
     public static Purchase getPurchaseByProductCode(String code) {
        return null;
            
    }
     
     public static void insertMain(Purchase purchase) {
         if (purchase !=null) {
             insert(purchase);
             Purchase p=getPurchaseByProductCode(purchase.getCode());
             try {
                 Summary summary=SummaryService.getSummaryByProductCode(purchase.getCode());
                 if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                     int tQty=summary.getTotalqty()+purchase.getQty();
                     int aQty=summary.getAvlqty()+purchase.getQty();
                     summary.setTotalqty(aQty);
                     summary.setAvlqty(aQty);
                     
                 }
                 SummaryService.update(summary);
             } catch (Exception e) {
                 Summary summary2=new Summary(purchase.getId(), purchase.getName(), purchase.getCode(), purchase.getQty(), 0, purchase.getQty(), p);
                 SummaryService.insert(summary2);
             }
             
         }
    }
}
