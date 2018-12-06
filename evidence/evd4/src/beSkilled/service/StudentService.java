package beSkilled.service;

import beSkilled.connet.MySqlConnection;
import beSkilled.domail.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {

    static Connection conn = MySqlConnection.getConnection();

    public static void createTable() {
        String sql = "create table student(id varchar(10) primary key , name varchar(20) not null, email varchar(30) not null, pass varchar(22) not null)";
        // String sql2 = "create table student(id varchar(11) primary key, name varchar(50) not null, email varchar(20) not null)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("create table success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insert(Student stu) {
        String sql = "insert into  student(id, name, email, pass) values(?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stu.getId());
            ps.setString(2, stu.getName());
            ps.setString(3, stu.getEmail());
            ps.setString(4, stu.getPsaa());
            ps.executeUpdate();
            System.out.println("insert success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updat(Student stu) {
        String sql = "update   student set name=?, email=?, pass=? where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, stu.getName());
            ps.setString(2, stu.getEmail());
            ps.setString(3, stu.getPsaa());
            ps.setString(4, stu.getId());
            ps.executeUpdate();
            System.out.println("update success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(Student stu) {
        String sql = "delete from student  where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, stu.getId());
            ps.executeUpdate();
            System.out.println("update success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Student> studentList() {

        List<Student> list = new ArrayList<>();
        String sql = "select * from student";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }

            System.out.println("update success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
