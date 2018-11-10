package beSkilled.test;

import beSkilled.Service.CategoryService;
import beSkilled.domain.Category;


public class CategoryTest {

    public static void main(String[] args) {
        //CategoryService.CreateTable();
        Category ca=new Category();
        ca.setName("Note 2570");
        CategoryService.insertDatsC(ca);
    }
    
    
    
}
