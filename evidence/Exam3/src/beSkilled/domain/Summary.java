
package beSkilled.domain;

public class Summary {
    private int id;
    private String name;
    private String cpde;
    private int totalqty;
    private int avalqty;
    private int soldqty;

    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String cpde, int totalqty, int avalqty, int soldqty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.cpde = cpde;
        this.totalqty = totalqty;
        this.avalqty = avalqty;
        this.soldqty = soldqty;
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

    public int getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(int totalqty) {
        this.totalqty = totalqty;
    }

    public int getAvalqty() {
        return avalqty;
    }

    public void setAvalqty(int avalqty) {
        this.avalqty = avalqty;
    }

    public int getSoldqty() {
        return soldqty;
    }

    public void setSoldqty(int soldqty) {
        this.soldqty = soldqty;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
    
    
}
