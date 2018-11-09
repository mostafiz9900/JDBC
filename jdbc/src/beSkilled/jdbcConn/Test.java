package beSkilled.jdbcConn;

public class Test {

    public static void main(String[] args) {
        //CreateMethod.CreateTale();
        
//        Student stu=new Student();
//        stu.setId(1);
//        stu.setName("mostafizur");
//        stu.setEmail("mos@gmail.com");
//        CreateMethod.insertData(stu);
        
//        Student stu=new Student();
//        stu.setId(1);
//        stu.setName("sofiqul");
//        stu.setEmail("mos@gmail.com");
//        CreateMethod.updateData(stu);
        
         Student stu=new Student();
        stu.setId(1);
        
        CreateMethod.deleteData(stu);
    }
}
