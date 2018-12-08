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
 * @author User
 */
public class PurchaseService {
    public static void insert(Purchase purchase){
    
    
    }
    
    public static void update(Purchase purchase){
    
    
    }
    
    public static Purchase getPurchaseByProductCode(String cpde){
        return null;
    
    
    }
    
   public static void insertMain(Purchase purchase){
       if (purchase !=null) {
           insert(purchase);
           
           Purchase p=getPurchaseByProductCode(purchase.getCpde());
           try {
               Summary summary=SummaryService.getSummaryByProductCode(purchase.getCpde());
               if (purchase.getCpde().equalsIgnoreCase(summary.getCpde())) {
                   int tQty=summary.getTotalqty()+ purchase.getQty();
                   int avQty=summary.getAvalqty()+ purchase.getQty();
                   summary.setTotalqty(avQty);
                   summary.setAvalqty(avQty);
                   
                   
               }
               SummaryService.update(summary);
               
           } catch (Exception e) {
               Summary summary2 =new Summary(purchase.getId(), purchase.getName(), purchase.getCpde(), purchase.getQty(), 0, purchase.getQty(), p);
               SummaryService.insert(summary2);
           }
           
       }
   
   }
}
