package beSkilled.Inventory.CatService;

import beSkilled.Inventory.Category;

public class TestCategory {

    public static void main(String[] args) {
        Category c = new Category();
        c.setName("Mobail");
        CategoryService.insertC(c);
    }
}
