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
            if (summary.getAvlQty() >= sales.getQty()) {
                insert(sales);
                int sQty = summary.getSoldQty() + sales.getQty();
                int avQty = summary.getAvlQty() - sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvlQty(avQty);
                SummaryService.update(summary);

            } else {
                System.out.println("You have do not sufficient product");
            }

        }

    }
}
