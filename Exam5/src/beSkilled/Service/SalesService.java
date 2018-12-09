/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.Service;

import beSkilled.Sales;
import beSkilled.Summary;

/**
 *
 * @author User
 */
public class SalesService {

    public static void insert(Sales sales) {

    }

    public static void insertForSales(Sales sales) {
        if (sales != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getCode());

            if (summary.getAvlQty() >= sales.getQty()) {
                int sQty = summary.getSoldQty() + sales.getQty();
                int aQty = summary.getAvlQty() - sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvlQty(aQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("your does not unsafficient Product ");
            }

        }
    }

}
