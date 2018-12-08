

package beSkilled.domain;


public class Purchase {

   private int id;
   private String name;
   private String cpde;
   private int qty;
   private double uprice;
   private double tprice;

    public Purchase() {
    }

    public Purchase(int id, String name, String cpde, int qty, double uprice, double tprice) {
        this.id = id;
        this.name = name;
        this.cpde = cpde;
        this.qty = qty;
        this.uprice = uprice;
        this.tprice = tprice;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUprice() {
        return uprice;
    }

    public void setUprice(double uprice) {
        this.uprice = uprice;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }
   
   
   
    
}
