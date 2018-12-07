package beSkilled.service;

import beSkilled.connection.MySqlDbConnection;
import static beSkilled.service.PurchaseService.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table sales(id int auto_increment primary key, name varchar(30) not null, pcode varchar(20) not null, qut int not null, uprice double not null, tprice double not null, date Date, pid int, foreign key (pid) references purchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("create table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
