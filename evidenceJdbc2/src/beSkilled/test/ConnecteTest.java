
package beSkilled.test;

import beSkilled.MysqlConnection;
import beSkilled.domain.Purchase;
import beSkilled.service.PurchaseService;
import java.util.Date;


public class ConnecteTest {
    public static void main(String[] args) {
        //MysqlConnection.getConnection();
       //PurchaseService.createTable();
        Purchase pur=new Purchase();
        pur.setProductName("tomtom");
        pur.setProductCode("tomtom");
        pur.setQty(2);
        pur.setUnitPrice(100);
        pur.setTotalPrice(200);
        pur.setPurchasedate(new Date());
        PurchaseService.insertData(pur);
        
    }
}
