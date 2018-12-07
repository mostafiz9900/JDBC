/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.test;

import beSkilled.connection.MySqlConnection;
import beSkilled.domain.Student;
import beSkilled.service.StudentService;

/**
 *
 * @author Mostafizur
 */
public class Test {

    public static void main(String[] args) {
        MySqlConnection.getConnection();
        StudentService.creatTable();
    }
}
