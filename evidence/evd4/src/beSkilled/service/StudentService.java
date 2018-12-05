package beSkilled.service;

import beSkilled.connet.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {

    static Connection conn = MySqlConnection.getConnection();

    public static void createTable() {
        String sql = "create table student(id varchar(40) primary key , name varchar(40) not null, email varchar(33) not null, pass varchar(22) not null";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("create table success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
