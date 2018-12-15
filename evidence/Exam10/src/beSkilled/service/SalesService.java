/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.Sales;
import beSkilled.Summary;

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
            if (summary.getAvailableQty() >= sales.getQty()) {
                int sQty = summary.getSoldQty() + sales.getQty();
                int aQty = summary.getAvailableQty() - sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvailableQty(aQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("you does not available product");
            }
        }
    }
}
