/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author user
 */
public class PurchaseSalesSummary {
    private int id;
    private String name;
    private String pCode;
    private int totalQuantity;
    private int soldQuantity;
    private int availableQuantity;
    private Date lastUpdate;
    private carPurchase cp;

    public PurchaseSalesSummary() {
    }

    public PurchaseSalesSummary(int id, String name, String pCode, int totalQuantity, int soldQuantity, int availableQuantity, Date lastUpdate, carPurchase cp) {
        this.id = id;
        this.name = name;
        this.pCode = pCode;
        this.totalQuantity = totalQuantity;
        this.soldQuantity = soldQuantity;
        this.availableQuantity = availableQuantity;
        this.lastUpdate = lastUpdate;
        this.cp = cp;
    }

    public PurchaseSalesSummary(String name, String pCode, int quantity, int i, int quantity0, Date date, carPurchase p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public carPurchase getCp() {
        return cp;
    }

    public void setCp(carPurchase cp) {
        this.cp = cp;
    }

   
    
    
}
