/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled;

/**
 *
 * @author User
 */
public class Summary {
    private int id;
    private String name;
    private String code;
    private int totalQty;
    private int  avalabilQty;
    private int soldQty;
    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int totalQty, int avalabilQty, int soldQty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.totalQty = totalQty;
        this.avalabilQty = avalabilQty;
        this.soldQty = soldQty;
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

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getAvalabilQty() {
        return avalabilQty;
    }

    public void setAvalabilQty(int avalabilQty) {
        this.avalabilQty = avalabilQty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
    
}
