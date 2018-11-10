package beSkilled.Service;

import beSkilled.connection.MyConnection;
import beSkilled.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductService {

    static Connection con = MyConnection.getConnect();

    public static void CreateTableP() {
        String sql = "create table product(id int(11) auto_increment primary key, name varchar(55), qty int(11), unity_price double, total_price double, purchase_date Date, cat_id int(11), FOREIGN KEY (cat_id) REFERENCES category(id))";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table Create Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertDataP(Product p) {
        String sql = "insert into product(name , qty, unity_price, total_price, purchase_date, cat_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQty());
            ps.setDouble(3, p.getUnitPrice());
            ps.setDouble(4, p.getTotalPrice());
            ps.setDate(5, new java.sql.Date(p.getPurchseDate().getTime()));
            ps.setInt(6, p.getCategory().getId());

            ps.executeUpdate();
            System.out.println("Data insert Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
