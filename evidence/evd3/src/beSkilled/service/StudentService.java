package beSkilled.service;

import beSkilled.connection.MySqlConnection;
import beSkilled.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {

    static Connection con = MySqlConnection.getConnection();

    public static void creatTable() {
        String sql = "create table student(id varchar(11) primary key, name varchar(50) not null, email varchar(20) not null)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("Create Table Success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insert(Student stu) {
        String sql = "insert into student(id, name , email) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stu.getId());
            ps.setString(2, stu.getName());
            ps.setString(3, stu.getEmail());
            ps.executeUpdate();
            System.out.println("Insert data Success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Student stu) {
        String sql = "update  student set  name=? , email=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, stu.getName());
            ps.setString(2, stu.getEmail());
            ps.setString(3, stu.getId());
            ps.executeUpdate();
            System.out.println("update data Success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(Student stu) {
        String sql = "delete  from student  where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, stu.getName());
            ps.setString(2, stu.getEmail());
            ps.setString(3, stu.getId());
            ps.executeUpdate();
            System.out.println("update data Success");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
}
