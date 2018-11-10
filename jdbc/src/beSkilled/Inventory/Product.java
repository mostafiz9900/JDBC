
package beSkilled.Inventory;

import java.util.Date;


public class Product{
   private int id;
   private String name;
   private int quantity;
   private double unitPrice;
   private double  totalPrice;
   private Date purchaseData;
   
   private Category category;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(Date purchaseData) {
        this.purchaseData = purchaseData;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
   

    
}
