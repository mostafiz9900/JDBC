package beSkilled.domain;

import java.util.Date;

public class Purchase {

    private int id;
    private String name;
    private String code;
    private int qut;
    private double uPrice;
    private double tprice;
    private Date pdate;

    public Purchase() {
    }

    public Purchase(int id, String name, String code, int qut, double uPrice, double tprice, Date pdate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.qut = qut;
        this.uPrice = uPrice;
        this.tprice = tprice;
        this.pdate = pdate;
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

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

   
}
