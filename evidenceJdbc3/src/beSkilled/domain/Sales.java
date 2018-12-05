
package beSkilled.domain;

import java.util.Date;

public class Sales {
     private int id;
    private String name;
    private String code;
    private int qut;
    private double uPrice;
    private double tprice;
    private Date sdate;
    Purchase purchase;

    public Sales() {
    }

    public Sales(int id, String name, String code, int qut, double uPrice, double tprice, Date sdate, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.qut = qut;
        this.uPrice = uPrice;
        this.tprice = tprice;
        this.sdate = sdate;
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

    public int getQut() {
        return qut;
    }

    public void setQut(int qut) {
        this.qut = qut;
    }

    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Sales{" + "id=" + id + ", name=" + name + ", code=" + code + ", qut=" + qut + ", uPrice=" + uPrice + ", tprice=" + tprice + ", sdate=" + sdate + ", purchase=" + purchase + '}';
    }
    
}
