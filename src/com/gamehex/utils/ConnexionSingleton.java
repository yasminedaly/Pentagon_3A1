/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasmine Daly
 */



public class ConnexionSingleton {
    
    private String url="jdbc:mysql://localhost:3306/gamehex";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static ConnexionSingleton instance;

    public Connection getCnx() {
        return cnx;
    }
    
    
    private ConnexionSingleton() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
   public static ConnexionSingleton getInstance(){
       
       if(instance==null)
       {
           instance=new ConnexionSingleton();
           System.out.println("connexion successful");
       }
       System.out.println("connexion successful");
       return instance;
   }
    
    
    
    
}
