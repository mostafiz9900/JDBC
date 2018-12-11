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
     private  int id;
    private  String name;
    private  String code;
    private  int tqty;
    private  int aqty;
    private  int sqty;
    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int tqty, int aqty, int sqty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.tqty = tqty;
        this.aqty = aqty;
        this.sqty = sqty;
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

    public int getAqty() {
        return aqty;
    }

    public void setAqty(int aqty) {
        this.aqty = aqty;
    }

    public int getSqty() {
        return sqty;
    }

    public void setSqty(int sqty) {
        this.sqty = sqty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    
    
}
