/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.test;

import beSkilled.connection.MySqlDbConnection;
import beSkilled.domain.Purchase;
import beSkilled.service.PurchaseService;
import java.util.Date;

/**
 *
 * @author Mostafizur
 */
public class PurchaseTest {

    public static void main(String[] args) {
        //MySqlDbConnection.getConnection();
        //PurchaseService.createTable();
        Purchase p=new Purchase();
        p.setId(1);
        p.setName("coumpeter");
        p.setPrice(50.0);
        p.setDate(new Date());
        PurchaseService.insert(p);
    }
}
