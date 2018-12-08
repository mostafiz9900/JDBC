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
public class Sales {

    private int id;
    private String name;
    private String cpde;
    private int qty;
    private double uprice;
    private double tprice;

    Purchase purchase;

    public Sales() {
    }

    public Sales(int id, String name, String cpde, int qty, double uprice, double tprice, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.cpde = cpde;
        this.qty = qty;
        this.uprice = uprice;
        this.tprice = tprice;
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

    public String getCpde() {
        return cpde;
    }

    public void setCpde(String cpde) {
        this.cpde = cpde;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUprice() {
        return uprice;
    }

    public void setUprice(double uprice) {
        this.uprice = uprice;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

}
