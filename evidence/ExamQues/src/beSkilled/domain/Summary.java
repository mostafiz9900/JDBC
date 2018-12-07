package beSkilled.domain;

public class Summary {

    private int id;
    private String name;
    private String code;
    private int tqty;
    private int sqty;
    private int avlbqty;
    Purcahse purchase;

    public int getId() {
        return id;
    }

    public Summary(int id, String name, String code, int tqty, int sqty, int avlbqty, Purcahse purchase) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.tqty = tqty;
        this.sqty = sqty;
        this.avlbqty = avlbqty;
        this.purchase = purchase;
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

    public int getTqty() {
        return tqty;
    }

    public void setTqty(int tqty) {
        this.tqty = tqty;
    }

    public int getSqty() {
        return sqty;
    }

    public void setSqty(int sqty) {
        this.sqty = sqty;
    }

    public int getAvlbqty() {
        return avlbqty;
    }

    public void setAvlbqty(int avlbqty) {
        this.avlbqty = avlbqty;
    }

    public Purcahse getPurchase() {
        return purchase;
    }

    public void setPurchase(Purcahse purchase) {
        this.purchase = purchase;
    }

}
