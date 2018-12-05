package beSkilled.service;

import beSkilled.connection.MySqlDbConnection;
import beSkilled.domain.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table purchase(id int auto_increment primary key, name varchar(30) not null, pcode varchar(20) not null, qut int not null, uprice double not null, tprice double not null, date Date)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("create table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Purchase purchase) {
        String sql = "insert into purchase(name, pcode, qut, uprice, tprice, date) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, purchase.getName());
            ps.setString(2, purchase.getCode());
            ps.setInt(3, purchase.getQut());
            ps.setDouble(4, purchase.getuPrice());
            ps.setDouble(5, purchase.getTprice());
            ps.setDate(6, new java.sql.Date(purchase.getPdate().getTime()));
            ps.executeUpdate();
            System.out.println("insert data");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Purchase purchase) {
        String sql = "update  purchase set name=?, pcode=?, qut=?, uprice=?, tprice=?,  where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, purchase.getName());
            ps.setString(2, purchase.getCode());
            ps.setInt(3, purchase.getQut());
            ps.setDouble(4, purchase.getuPrice());
            ps.setDouble(5, purchase.getTprice());

            ps.setInt(6, purchase.getId());
            ps.executeUpdate();
            System.out.println("insert data");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(Purchase purchase) {
        String sql = "delete  from purchase where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, purchase.getId());
            ps.executeUpdate();
            System.out.println("delete data");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static List<Purchase> getProductList() {
        List<Purchase> list = new ArrayList<>();

        String sql = "select * from purchase";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Purchase purchase = new Purchase();
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setCode(rs.getString(3));
                purchase.setQut(rs.getInt(4));
                purchase.setuPrice(rs.getDouble(5));
                purchase.setTprice(rs.getDouble(6));
                purchase.setPdate(rs.getDate(7));             
                list.add(purchase);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
