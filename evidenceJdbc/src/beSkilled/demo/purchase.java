
package beSkilled.demo;

import java.util.Date;

public class purchase {
    private int pid;
    private String pname;
    private String pcode;
    private int qty;
    private double unitPrice;
    private double totalPrice;
    private Date pdate;
    private int p_id;

    public purchase() {
    }

    public purchase(int pid, String pname, String pcode, int qty, double unitPrice, double totalPrice, Date pdate, int p_id) {
        this.pid = pid;
        this.pname = pname;
        this.pcode = pcode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.pdate = pdate;
        this.p_id = p_id;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

}
