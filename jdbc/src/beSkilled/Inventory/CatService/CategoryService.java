package beSkilled.Inventory.CatService;

import beSkilled.Inventory.Category;
//import beSkilled.Inventory.CreateMethod;
import beSkilled.Inventory.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CategoryService {

    static Connection con = MySqlConnect.getConnection();

    public static void insertC(Category category) {
        String sql = "insert into category(name) values(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, category.getName());

            ps.executeUpdate();
            System.out.println("Data Inserted Successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
