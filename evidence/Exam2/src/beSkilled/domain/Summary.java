/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.domain;

/**
 *
 * @author Mostafizur
 */
public class Summary {

    private int id;
    private String name;
    private String code;
    private int Qqty;
    private int soldQty;
    private int avlQty;
    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int Qqty, int soldQty, int avlQty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.Qqty = Qqty;
        this.soldQty = soldQty;
        this.avlQty = avlQty;
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

    public int getQqty() {
        return Qqty;
    }

    public void setQqty(int Qqty) {
        this.Qqty = Qqty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getAvlQty() {
        return avlQty;
    }

    public void setAvlQty(int avlQty) {
        this.avlQty = avlQty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

}
