/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MySqlDbConnection;
import domain.carSales;
import domain.PurchaseSalesSummary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SalesService {
    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table carSales(id int auto_increment primary key, name varchar(30), pCode varchar(30), quantity int(11), unitPrice double, totalPrice double, salesDate Date, pId int(11), foreign key (pId) references carPurchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(carSales sales) {
        String sql = "insert into carSales(name, pCode, quantity, unitPrice, totalPrice, salesDate, pId) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sales.getName());
            ps.setString(2, sales.getpCode());
            ps.setInt(3, sales.getQuantity());
            ps.setDouble(4, sales.getUnitPrice());
            ps.setDouble(5, sales.getTotlalPrice());
            ps.setDate(6, new java.sql.Date(sales.getSalesDate().getTime()));
            ps.setInt(7, sales.getCp().getId());
            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertForSales(carSales sales) {
        if (sales != null) {
            PurchaseSalesSummary summary = SummaryService.getSummaryByProductCode(sales.getpCode());
            if (summary.getAvailableQuantity()>= sales.getQuantity()) {
                insert(sales);
                int soldQrt = summary.getSoldQuantity()+ sales.getQuantity();
                int avilQty = summary.getAvailableQuantity()- sales.getQuantity();
                summary.setSoldQuantity(soldQrt);
                summary.setAvailableQuantity(avilQty);
                summary.setLastUpdate(new Date());
                SummaryService.update(summary);
            } else {
                System.out.println("You do not have sufficient Product");
            }
        }
    }
}
