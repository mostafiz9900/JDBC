/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MySqlDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SalesService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table sales(id int auto_increment primary key, name varchar(30), price double, date Date, pid int(11), foreign key (pid) references purchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created!");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
