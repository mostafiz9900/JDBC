/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.domain.Sales;
import beSkilled.domain.Summary;

/**
 *
 * @author Mostafizur
 */
public class SalesService {

    public static void insert(Sales sales) {

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
                System.out.println("you are not unsufficient product");
            }

        }
    }
}
