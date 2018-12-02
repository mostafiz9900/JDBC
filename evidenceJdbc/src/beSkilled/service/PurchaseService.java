/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service;

import beSkilled.connection.jdbcConnection;
import beSkilled.demo.purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PurchaseService {

    static Connection conn = jdbcConnection.getConnection();

    public static void creatTable() {
        String sql = "create table purchase(pid int auto_increment primary key, pname varchar(30) not null, pcode varchar(30) not null, qty int (11) not null, unitPrice double not null, totalPrice double not null , pdate Date not null)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //insert purchase table

    public static void insertData() {
        String sql = "insert into purchase( pname, pcode , qty, unitPrice, totalPrice  , pdate ) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, purchase.);
            ps.execute();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //insert purchase table

}
