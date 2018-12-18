package beSkilled.domain;

public class Summary {

    private int id;
    private String name;
    private String code;
    private int totalQty;
    private int availableQty;
    private int soldQty;
    Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String code, int totalQty, int availableQty, int soldQty, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.totalQty = totalQty;
        this.availableQty = availableQty;
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

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
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
