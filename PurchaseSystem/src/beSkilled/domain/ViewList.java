package beSkilled.domain;

import beSkilled.connection.MyConnection;
import beSkilled.domain.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewList {

    static Connection con = MyConnection.getConnect();

    public static List<Category> getCategoryList() {
        List<Category> catList = new ArrayList<>();

        String sql = "select * from category";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                catList.add(new Category(rs.getInt(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;

    }

    public static List<Product> getProductList() {
        List<Product> produList = new ArrayList<>();

        String sql = "select * from product";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(7));
                produList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), c));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produList;

    }
}
