
package beSkilled.service;

import beSkilled.Sales;
import beSkilled.Summary;


public class SalesService {
    public static void insert(Sales sales) {
        
    }
    
    public static void insertForSales(Sales sales) {
        if (sales!=null) {
            Summary summary=SummaryService.getSummaryByProductCode(sales.getCode());
            if (summary.getAvailableQty()>=sales.getQty()) {
                int sQty=summary.getSoldQty()+sales.getQty();
                int aQty=summary.getAvailableQty()-sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvailableQty(aQty);
                SummaryService.insert(summary);
                
            }else{
                System.out.println("your are not available");
            }
            
        }
    }
}
