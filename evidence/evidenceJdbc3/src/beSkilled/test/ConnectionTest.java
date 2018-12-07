
package beSkilled.test;

import beSkilled.connection.MySqlDbConnection;
import beSkilled.domain.Purchase;
import beSkilled.service.PurchaseService;
import beSkilled.service.SalesService;
import java.util.Date;


public class ConnectionTest {
    public static void main(String[] args) {
        //MySqlDbConnection.getConnection();
        //PurchaseService.createTable();
        //SalesService.createTable();
        Purchase p=new Purchase();
        p.setName("pan");
        p.setCode("p001");
        p.setQut(10);
        p.setuPrice(4.50);
        p.setTprice(45);
        p.setPdate(new Date());
        PurchaseService.insert(p);
    }
}
