/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.Sale;
import beSkilled.Summary;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class SalesService {

    static Connection con = null;

    public static void insert(Sale sales) {

    }

    public static void insertForSales(Sale sales) {
        if (sales != null) {
            Summary summary = SummaryService.getSummaryByProductCode(sales.getCode());
            if (summary.getAvalabilQty() >= sales.getQty()) {
                int sQty = summary.getSoldQty() + sales.getQty();
                int aQty = summary.getAvalabilQty() - sales.getQty();
                summary.setSoldQty(sQty);
                summary.setAvalabilQty(aQty);
                SummaryService.insert(summary);

            } else {
                System.out.println("    Your Product not available");
            }

        }
    }
}
