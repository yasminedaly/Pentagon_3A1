/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moudhaffer
 */
public class MyConnection {
    private String url = "jdbc:mysql://localhost:3306/gamehex11";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static MyConnection instance;
    
    private MyConnection(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection established successfully!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
    public Connection getCnx(){
        return cnx;
    }
    
    public static MyConnection getInstance(){
       
       if(instance==null)
           instance=new MyConnection();
       return instance;
   }
}
