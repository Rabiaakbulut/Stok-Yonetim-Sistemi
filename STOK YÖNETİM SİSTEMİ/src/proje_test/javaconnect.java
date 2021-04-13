/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class javaconnect {
        public static void main(String[] args) {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
