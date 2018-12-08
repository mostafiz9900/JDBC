/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.domain.Purchase;
import beSkilled.domain.Sales;
import beSkilled.domain.Summary;

/**
 *
 * @author User
 */
public class SalesService {

    public static void insert(Sales sales) {

    }

    public static void insertForSales(Sales sales) {
        if (sales != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getCpde());
            if (summary.getAvalqty() >= sales.getQty()) {
                int tQty = summary.getSoldqty() + sales.getQty();
                int avbQty = summary.getAvalqty() - sales.getQty();
                summary.setAvalqty(avbQty);
                summary.setSoldqty(avbQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("Your producet not suficient");
            }

        }

    }

}
