/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beSkilled.service.test;

import beSkilled.connet.MySqlConnection;
import beSkilled.service.StudentService;

/**
 *
 * @author Mostafizur
 */
public class Test {
    public static void main(String[] args) {
        MySqlConnection.getConnection();
        StudentService.createTable();
    }
}
