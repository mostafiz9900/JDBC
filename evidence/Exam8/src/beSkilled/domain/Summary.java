
package beSkilled.domain;

/**
 *
 * @author User
 */
public class Summary {
    private int id;
    private String name;
    private String code;
    private int totalqty;
    private int avabileqty;
    private int soldqty;
    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int totalqty, int avabileqty, int soldqty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.totalqty = totalqty;
        this.avabileqty = avabileqty;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(int totalqty) {
        this.totalqty = totalqty;
    }

    public int getAvabileqty() {
        return avabileqty;
    }

    public void setAvabileqty(int avabileqty) {
        this.avabileqty = avabileqty;
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
