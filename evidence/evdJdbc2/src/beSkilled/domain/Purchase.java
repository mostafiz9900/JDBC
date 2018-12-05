package beSkilled.domain;

import java.util.Date;

public class Purchase {

    private int id;
    private String name;
    private double price;
    private Date date;

    public Purchase() {
    }

    public Purchase(int id, String name, double price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", name=" + name + ", price=" + price + ", date=" + date + '}';
    }

}
