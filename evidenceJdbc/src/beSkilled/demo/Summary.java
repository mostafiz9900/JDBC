/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.demo;

import java.util.Date;

/**
 *
 * @author User
 */
public class Summary {
     private int pid;
    private String pname;
    private String pcode;
    private int totalQty;
    private int  soldQty;
    private int availableQty;
    private Date lastUpdate;
    //For foreign key
    purchase purchase;

    public Summary() {
    }

    public Summary(int pid, String pname, String pcode, int totalQty, int soldQty, int availableQty, Date lastUpdate, purchase purchase) {
        this.pid = pid;
        this.pname = pname;
        this.pcode = pcode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.lastUpdate = lastUpdate;
        this.purchase = purchase;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Summary{" + "pid=" + pid + ", pname=" + pname + ", pcode=" + pcode + ", totalQty=" + totalQty + ", soldQty=" + soldQty + ", availableQty=" + availableQty + ", lastUpdate=" + lastUpdate + ", purchase=" + purchase + '}';
    }
    
}
