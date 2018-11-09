package beSkilled.jdbcConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateMethod {

    static Connection conn = ConnectJdbc.getConnect();

    public static void CreateTale() {
        String sql = "create table student(id int(10), name varchar(30), email varchar(30))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("table create");
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertData(Student s) {
        String sql = "insert into student(id, name, email) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();
            System.out.println("insert data");
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateData(Student s) {
        String sql = "update student set name=?, email=? where id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getId());
            ps.executeUpdate();
            System.out.println("update data");
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteData(Student s) {
        String sql = "delete from student where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
//            ps.setString(2, s.getName());
//            ps.setString(3, s.getEmail());

            ps.executeUpdate();
            System.out.println("delete data");
        } catch (SQLException ex) {
            Logger.getLogger(CreateMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
