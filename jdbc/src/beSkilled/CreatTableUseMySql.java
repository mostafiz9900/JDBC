package beSkilled;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatTableUseMySql {

    private static  Connection con2 = MySqlConncet.getConnection();

    public static void creatTable()  {
        String spl = "create table division(id int(10), name varchar(30))";
        try {
            PreparedStatement ps = con2.prepareStatement(spl);
            ps.executeUpdate();
            System.out.println("Table Create");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
