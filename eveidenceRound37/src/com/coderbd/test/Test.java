package com.coderbd.test;

import com.coderbd.conn.MySqlDbConnection;
import com.coderbd.service.PurchaseService;
import com.coderbd.service.SalesService;
import com.coderbd.service.SummaryService;
import com.mysql.jdbc.integration.c3p0.MysqlConnectionTester;

/**
 *
 * @author User
 */
public class Test {

    public static void main(String[] args) {
       // MySqlDbConnection.getConnection();
        //PurchaseService.createTable();
        // SummaryService.createTable();
       SalesService.createTable();
    }
}
