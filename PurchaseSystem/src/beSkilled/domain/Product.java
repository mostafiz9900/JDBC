
package beSkilled.domain;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int qty;
    private double unitPrice;
    private double totalPrice;
    private Date purchseDate;
    private Category category;

    public Product(int id, String name, int qty, double unitPrice, double totalPrice, Date purchseDate, Category category) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.purchseDate = purchseDate;
        this.category = category;
    }
    
    

    Product(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Product(int aInt, String string, int aInt0, double aDouble, double aDouble0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Product(int aInt, String string, int aInt0, double aDouble, double aDouble0, java.sql.Date date, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public Date getPurchseDate() {
        return purchseDate;
    }

    public void setPurchseDate(Date purchseDate) {
        this.purchseDate = purchseDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
}
