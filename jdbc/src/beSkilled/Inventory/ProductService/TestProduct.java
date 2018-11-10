/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.Inventory.ProductService;

import beSkilled.Inventory.CatService.CategoryService;
import beSkilled.Inventory.Category;
import beSkilled.Inventory.Product;
import java.util.Date;


/**
 *
 * @author User
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p=new Product();
        p.setName("Computer");
        p.setQuantity(5);
        p.setUnitPrice(5000);
        p.setTotalPrice(25000);
        p.setPurchaseData(new Date());
       
        
       
        
         Category c=new Category();
         c.setId(1);
        p.setCategory(c);
        ProductService.insert(p);
        
    }
}
