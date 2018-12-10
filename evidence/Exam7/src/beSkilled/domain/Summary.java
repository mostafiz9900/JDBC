/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.domain;

/**
 *
 * @author User
 */
public class Summary {
     private int id;
    private String name;
    private String code;
    private int tqty;
    private int avlqty;
    private int soldqty;

    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int tqty, int avlqty, int soldqty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.tqty = tqty;
        this.avlqty = avlqty;
        this.soldqty = soldqty;
        this.purchase = purchase;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTqty() {
        return tqty;
    }

    public void setTqty(int tqty) {
        this.tqty = tqty;
    }

    public int getAvlqty() {
        return avlqty;
    }

    public void setAvlqty(int avlqty) {
        this.avlqty = avlqty;
    }

    public int getSoldqty() {
        return soldqty;
    }

    public void setSoldqty(int soldqty) {
        this.soldqty = soldqty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
    
    
}
