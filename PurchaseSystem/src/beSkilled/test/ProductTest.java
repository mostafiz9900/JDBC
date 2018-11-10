
package beSkilled.test;

import beSkilled.Service.ProductService;
import beSkilled.domain.Category;
import beSkilled.domain.Product;
import java.util.Date;


public class ProductTest {
    public static void main(String[] args) {
        //ProductService.CreateTableP();
        
        Product p=new Product();
        p.setName("Lenovo d500");
        p.setQty(2);
        p.setUnitPrice(5000);
        p.setTotalPrice(10000);
        p.setPurchseDate(new Date());
        Category c=new Category();
        c.setId(3);
        p.setCategory(c);
        ProductService.insertDataP(p);
    }
}
