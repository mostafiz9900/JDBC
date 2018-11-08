package beSkilled.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lists {

    static Connection con = ConnectionDbms.getConnection();

    public static List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        //Student students;
        String sql = "select * from student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;

    }

}
