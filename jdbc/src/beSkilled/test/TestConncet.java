package beSkilled.test;

import beSkilled.CreatTableUseMySql;
import beSkilled.DeleteData;
import beSkilled.InsertData;
import beSkilled.UpdateData;

import java.sql.SQLException;

public class TestConncet {

    public static void main(String[] args) throws SQLException {
        // Connection conne = MySqlConncet.getConnection();
        //CreatTableUseMySql.creatTable();
        //InsertData.insertData();
       //InsertData.insertData2(1, "Rajshahe");
//        InsertData.insertData2(2, "Khilna");
//        InsertData.insertData2(2, "Borishalssss");
        //DeleteData.dataDelet(2);
        //UpdateData.updateData("Mirpu", 1);
        UpdateData.getDataById(1);
        
    }
}
