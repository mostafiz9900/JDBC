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
public class Purchase {

    private int id;
    private String name;
    private String code;
    private int qty;
    private double uPrice;
    private double tPrice;

    public Purchase() {
    }

    public Purchase(int id, String name, String code, int qty, double uPrice, double tPrice) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.qty = qty;
        this.uPrice = uPrice;
        this.tPrice = tPrice;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }

    public double gettPrice() {
        return tPrice;
    }

    public void settPrice(double tPrice) {
        this.tPrice = tPrice;
    }
    
    

}
